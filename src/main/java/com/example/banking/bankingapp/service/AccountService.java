package com.example.banking.bankingapp.service;

import com.example.banking.bankingapp.dto.AccountDto;

public interface AccountService {
    
    // here we can use dto to transferdata between client and server
    // what is the benefit of using dto?
    // 1. we can hide the internal implementation of the server from the client
    // 2. we can transfer only the required data between client and server
    AccountDto createAccount(AccountDto account);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    
}
