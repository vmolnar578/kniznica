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

    public List<CustomerEntity> getCustomers(String lastname){
        List<CustomerEntity> full = (List<CustomerEntity>) customerRepository.findAll();
        if(lastname == null) { return full; }
        List<CustomerEntity> filtered = new ArrayList<>();
        for (CustomerEntity c : full){
            if (lastname.equals(c.getLastname())) { filtered.add(c); }
        }
        return filtered;
    }

    public CustomerEntity getCustomer(Integer id) {
        Optional<CustomerEntity> customer = customerRepository.findById(Long.valueOf(id));
        return customer.orElse(null);
    }

    public CustomerEntity updateCustomer(Long customerId, CustomerDto customer) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(customerId);
        customerEntity.get().setFirstname(customer.getFirstname());
        customerEntity.get().setLastName(customer.getLastname());
        customerEntity.get().setContact(customer.getContact());
        return customerRepository.save(customerEntity.get());
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
