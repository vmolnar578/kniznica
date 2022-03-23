package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customersRepository) {
        this.customerRepository = customersRepository;
    }

    public CustomerEntity createCustomer(CustomerDto customer){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstname(customer.getFirstname());
        customerEntity.setLastName(customer.getLastname());
        customerEntity.setContact(customer.getContact());
        return this.customerRepository.save(customerEntity);
    }

    public CustomerEntity getCustomer(Integer id) {
        Optional<CustomerEntity> customer = customerRepository.findById(Long.valueOf(id));
        return customer.orElse(null);
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
