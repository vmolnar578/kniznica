package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class customerController {
    private List<Customer> customers;

    public customerController(){
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
    @PostMapping("/api/customers")
    public Integer createCustomer(@RequestBody Customer customer){
        this.customers.add(customer);
        return this.customers.size() -1;
    }
    @GetMapping("/api/customers")
    public List<Customer> listCustomers(@RequestParam(name="lastname") String lastname) {
        List<Customer> filteredCustomers = new ArrayList<>();
        for(Customer c : customers){
            if (c.getLastname().equals(lastname)){
                filteredCustomers.add(c);
                System.out.println("xd");
            }
        }
        return filteredCustomers;
    }
    @GetMapping("/api/customers/{customerId}")
    public Customer customerById(@PathVariable Integer customerId) {
        return this.customers.get(customerId);
    }
    @PutMapping("/api/customers/{customerId}")
    public Customer updateCustomer(@PathVariable Integer customerId, @RequestBody Customer customer) {
        this.customers.get(customerId).setFirstname(customer.getFirstname());
        this.customers.get(customerId).setLastname(customer.getLastname());
        this.customers.get(customerId).setContact(customer.getContact());
        return this.customers.get(customerId);
    }
    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId) {
        this.customers.remove(this.customers.get(customerId));
    }
}
