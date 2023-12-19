package com.example.accountservice.model;

import lombok.*;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@ToString @Builder
public class Customer {

    long customerId;
    String firstname;
    String lastname;
    String mail;
}
