package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class customerController {
    private CustomerService customerService;

    public customerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/api/customers")
    public Integer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }
    @GetMapping("/api/customers")
    public List<Customer> listCustomers(@RequestParam(name="lastname") String lastname) {
        return customerService.listCustomers(lastname);
    }
    @GetMapping("/api/customers/{customerId}")
    public Customer customerById(@PathVariable Integer customerId) {
        return customerService.customerById(customerId);
    }
    @PutMapping("/api/customers/{customerId}")
    public Customer updateCustomer(@PathVariable Integer customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId,customer);
    }
    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);
    }
}
