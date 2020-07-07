package gau.nau.springmvc.service;

import org.springframework.stereotype.Service;

import java.util.List;

import gau.nau.springmvc.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Override
    public List<Customer> getCustomers() {
        return null;
    }

    @Override
    public void saveCustomer(Customer customer) {

    }

    @Override
    public Customer getCustomer(int id) {
        return null;
    }

    @Override
    public void deleteCustomer(int id) {

    }
}
