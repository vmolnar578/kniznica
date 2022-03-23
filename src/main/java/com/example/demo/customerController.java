package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class customerController {
    private CustomerService customerService;

    public customerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/api/customers")
    public CustomerEntity createCustomer(@RequestBody CustomerDto customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/api/customers/{customerId}")
    public CustomerDto customerById(@PathVariable Integer customerId) {
        CustomerEntity customerEntity = customerService.getCustomer(customerId);
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customerEntity.getId());
        customerDto.setFirstname(customerEntity.getFirstname());
        customerDto.setLastname(customerEntity.getLastname());
        customerDto.setContact(customerEntity.getContact());
        return customerDto;
    }

    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}
