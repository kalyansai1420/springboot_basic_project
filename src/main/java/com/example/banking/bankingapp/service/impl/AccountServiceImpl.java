package com.example.banking.bankingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banking.bankingapp.dto.AccountDto;
import com.example.banking.bankingapp.entity.Account;
import com.example.banking.bankingapp.mapper.AccountMapper;
import com.example.banking.bankingapp.repository.AccountRepo;
import com.example.banking.bankingapp.service.AccountService;

@Service // to automatically create spring bean class
public class AccountServiceImpl implements AccountService{

    // let us inject the dependency
    private AccountRepo accountRepo;

    // constructor based dependency injection
    // why not using autowired annotation here?
    // we can use it but it is not mandatory
    // if we use it then we can remove the constructor
    // what's difference between constructor based and field based dependency injection?
    // in constructor based, we can make the dependency as final
    // in field based, we cannot make the dependency as final
    // if we make the dependency as final, then we can avoid the null pointer exception
    // if we make the dependency as final, then we can avoid the cyclic dependency
    // if we make the dependency as final, then we can avoid the memory leaks
    // if we make the dependency as final, then we can avoid the thread safety issues
    // if we make the dependency as final, then we can avoid the concurrency issues
    // is constructor based dependency is best or field based dependency is best?
    // both are best, but constructor based is better than field based
    
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

        // what is happening above?
        // 1. we are converting the accountDto to account entity
        // 2. we are saving the account entity to the database
        // 3. we are converting the saved account entity to accountDto and returning it

    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepo.findById(id).orElseThrow(
            () -> new RuntimeException("Account not found with id: "+id)
        );
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {

        //get the account by id
        Account account = accountRepo.findById(id).orElseThrow(
            () -> new RuntimeException("Account does not exists")
        );

        account.setBalance(account.getBalance()+amount);
        Account updatedAccount = accountRepo.save(account);

        return AccountMapper.mapToAccountDto(updatedAccount);

    }
    
}
