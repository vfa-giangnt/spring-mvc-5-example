package gau.nau.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import gau.nau.springmvc.entity.Customer;
import gau.nau.springmvc.exception.ResourceNotFoundException;
import gau.nau.springmvc.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) throws ResourceNotFoundException {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
