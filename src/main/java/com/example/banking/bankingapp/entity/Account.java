package com.example.banking.bankingapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="accounts") // to map this entity to a table in the database
@Entity // to make this class a jpa entity
public class Account {
    

    @Id //to make this as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // to make this as auto increment
    private Long id;

    @Column(name="account_holder_name")
    private String accountHolderName;
    private double balance;
}
