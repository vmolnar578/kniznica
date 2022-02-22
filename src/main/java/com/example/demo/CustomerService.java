package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private List<Customer> customers;

    public CustomerService(){
        this.customers = init();
    }

    private List<Customer> init(){
        List<Customer> customers = new ArrayList<>();
        Customer c1 = new Customer();
        c1.setFirstname("Zakaznik 1");
        c1.setLastname("Priezvisko 1");
        c1.setContact("email1@gmail.com");
        Customer c2 = new Customer();
        c2.setFirstname("Zakaznik 2");
        c2.setLastname("Priezvisko 2");
        c2.setContact("email2@outlook.com");
        customers.add(c1);
        customers.add(c2);
        return customers;
    }
    public Integer createCustomer(Customer customer){
        this.customers.add(customer);
        return this.customers.size() -1;
    }
    public List<Customer> listCustomers(String lastname) {
        List<Customer> filteredCustomers = new ArrayList<>();
        for(Customer c : customers){
            if (c.getLastname().equals(lastname)){
                filteredCustomers.add(c);
                System.out.println("xd");
            }
        }
        return filteredCustomers;
    }
    public Customer customerById(Integer customerId) {
        return this.customers.get(customerId);
    }
    public Customer updateCustomer(Integer customerId, Customer customer) {
        this.customers.get(customerId).setFirstname(customer.getFirstname());
        this.customers.get(customerId).setLastname(customer.getLastname());
        this.customers.get(customerId).setContact(customer.getContact());
        return this.customers.get(customerId);
    }
    public void deleteCustomer(Integer customerId) {
        this.customers.remove(this.customers.get(customerId));
    }
}
