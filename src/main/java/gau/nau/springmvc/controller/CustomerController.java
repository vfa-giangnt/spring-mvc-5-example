package gau.nau.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import gau.nau.springmvc.entity.Customer;
import gau.nau.springmvc.exception.ResourceNotFoundException;
import gau.nau.springmvc.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "list-customers";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {

        LOG.debug("Inside show customer-form handler method.");

        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model) throws ResourceNotFoundException {

        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);

        return "customer-form";

    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id) throws ResourceNotFoundException {
        customerService.deleteCustomer(id);

        return "redirect:/customer/list";
    }
}
