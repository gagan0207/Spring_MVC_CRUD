package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springmvc.model.Customer;
import springmvc.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
    // need to inject service layer

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String customerList(Model m)
    {
        //get customers from service
        List<Customer> theCustomers=customerService.getCustomers();
        //add cstomers to spring mvc model
        m.addAttribute("customers",theCustomers);
        return "list-customers";
    }

    @GetMapping("/AddCustomerForm")
    public String showFormForAdd(Model m)
    {

        //create model attribute to bind the form data
        Customer theCustomer=new Customer();
        m.addAttribute("customer",theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
    {
        System.out.println("saveCustomer()");
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";

    }


    @GetMapping("/showFormForUpdate")
    public String updateCustomer(@RequestParam("customerId") int theId, Model m)
    {
        Customer theCustomer=customerService.getCustomers(theId);
        m.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @GetMapping("/search")
    public String search(@RequestParam("theSearchName") String theSearchName,Model m)
    {
        List<Customer> theCustomers = customerService.searchCustomer(theSearchName);

        m.addAttribute("customers", theCustomers);

        return "list-customers";
    }


}
