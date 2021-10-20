package springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc.model.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{
    //need to inject session factory
    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> getCustomers()
    {
        //get the current hibernate session
        Session session=sessionFactory.getCurrentSession();
        //session.beginTransaction();
        System.out.println("transaction begin");
       session.beginTransaction();

        String hql="FROM Customer";

        Query<Customer> theQuery=session.createQuery(hql, Customer.class);
        System.out.println("get customer query executing..");
       List<Customer> customers=theQuery.getResultList();
        System.out.println("query executed to get the customers...");
       return customers;

    }

    @Override
    public Customer getCustomers(int theId)
    {
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();
        Customer theCustomer=session.get(Customer.class,theId);

        return theCustomer;
    }


    @Override
    public void saveCustomer(Customer theCustomer)
    {
        System.out.println("saveCustomer() method");
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.println(theCustomer.getId()+" "+theCustomer.getFirstName()+""+theCustomer.getLastName());
        session.saveOrUpdate(theCustomer);

        session.getTransaction().commit();
        session.close();
        System.out.println("new customer saved");

    }

    public List <Customer> searchCustomer(String theSearchName)
    {
        System.out.println(theSearchName);
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
       // String hqlSearch="SELECT c FROM Customer c WHERE c.firstName LIKE '%' || :keyword || '%' "
              //  + "OR c.lastName LIKE '%' || :keyword || '%'" +"OR c.email LIKE '%' || :keyword || '%'";
       // Query<Customer> theQuery1=session.createQuery(hqlSearch, Customer.class);

        //List<Customer> searchCustomers=theQuery1.getResultList();
        Query theQuery = null;
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            theQuery =session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName");
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        }
        else {

            theQuery =session.createQuery("from Customer", Customer.class);
        }

        List<Customer> customers = theQuery.getResultList();

        return customers;

    }



}
