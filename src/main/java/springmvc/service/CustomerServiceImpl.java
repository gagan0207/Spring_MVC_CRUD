package springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc.dao.CustomerDAO;
import springmvc.model.Customer;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerDAO customerDAO;


    @Transactional
    public List<Customer> getCustomers()
    {

        return customerDAO.getCustomers();

    }

    @Transactional
    public void saveCustomer(Customer theCustomer)
    {
        customerDAO.saveCustomer(theCustomer);

    }

    @Override
    @Transactional
    public Customer getCustomers(int theId) {
        return customerDAO.getCustomers(theId);
    }


    public List<Customer> searchCustomer(String theSearchName)
    {
        return customerDAO.searchCustomer(theSearchName);
    }

}
