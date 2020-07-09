package gau.nau.springmvc.service;

import java.util.List;

import gau.nau.springmvc.entity.Customer;
import gau.nau.springmvc.exception.ResourceNotFoundException;

public interface CustomerService {

    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);

    public Customer getCustomer(int id) throws ResourceNotFoundException;
    public void deleteCustomer(int id) throws ResourceNotFoundException;
}
