package com.example.accountservice.controller;

import com.example.accountservice.clients.CustomerRestClient;
import com.example.accountservice.entities.BankAccount;
import com.example.accountservice.model.Customer;
import com.example.accountservice.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class BankAccountController {
    @Autowired
    BankAccountRepository bankAccountRepository;
    @Autowired
    CustomerRestClient customerRestClient;

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
List<BankAccount> accountList= bankAccountRepository.findAll();
accountList.forEach(bankAccount -> {
    bankAccount.setCustomer(customerRestClient.findCustomerById(bankAccount.getCustomerId()));
    //System.out.println((bankAccount.getCustomer()).getCustomerId());
            bankAccount.getCustomer().setCustomerId(bankAccount.getCustomerId());
       }

   );

        return accountList;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount accountById(@PathVariable String id){
         BankAccount bankAccount= bankAccountRepository.findById(id).get();

        Customer customer= customerRestClient.findCustomerById(bankAccount.getCustomerId());
        customer.setCustomerId(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        System.out.println("id from account " +bankAccount.getCustomerId());
        System.out.println("id from customer " +customer.getCustomerId());
        System.out.println(customer);System.out.println(bankAccount);

        return bankAccount;
    }

}
