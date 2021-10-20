package springmvc.service;


import org.springframework.web.bind.annotation.RequestParam;
import springmvc.dao.CustomerDAO;
import springmvc.model.Customer;

import java.util.List;

public interface CustomerService
{

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);


   public Customer getCustomers(int theId);

   public List<Customer> searchCustomer(String theSearchName);
}
