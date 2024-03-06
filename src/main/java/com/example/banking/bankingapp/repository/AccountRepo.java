package com.example.banking.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.banking.bankingapp.entity.Account;

public interface AccountRepo extends JpaRepository<Account,Long> {  //JpaRepo is generic so we have to pass two paramters
    // we can crud database methods to perform crud database operations on this accoutn jpa entity    
}
