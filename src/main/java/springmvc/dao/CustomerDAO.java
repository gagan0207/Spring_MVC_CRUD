package springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc.model.Customer;

import java.util.List;

public interface CustomerDAO
{
     public void saveCustomer(Customer theCustomer);

    public List<Customer> getCustomers();


   public  Customer getCustomers(int theId);

   public  List<Customer> searchCustomer(String theSearchName);
}
