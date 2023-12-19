package com.example.customer_service.controller;

import com.example.customer_service.entities.Customer;
import com.example.customer_service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
@Autowired
    CustomerRepository customerRepository;

@GetMapping("/customers")
    public List<Customer> customerList(){
    List<Customer> customerList = customerRepository.findAll();
    customerList.forEach( customer ->{
            System.out.println(customer);}
    );
    return customerList;

}
    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id){
        return customerRepository.findById(id).orElseThrow();

    }
}
