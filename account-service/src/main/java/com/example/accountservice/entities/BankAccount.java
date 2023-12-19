package com.example.accountservice.entities;

import com.example.accountservice.enumerator.AccountType;
import com.example.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString @Builder
@Entity
public class BankAccount {
    @Id
    String accountId;
    double balance;
    LocalDate createAt;
    String currency;
    @Enumerated(EnumType.STRING)
    AccountType type;
    @Transient
    Customer customer ;
    long customerId;

}
