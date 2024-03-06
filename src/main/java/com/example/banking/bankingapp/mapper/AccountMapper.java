package com.example.banking.bankingapp.mapper;

import com.example.banking.bankingapp.dto.AccountDto;
import com.example.banking.bankingapp.entity.Account;

public class AccountMapper {
    
    public static Account mapToAccount(AccountDto accountDto) {

        // Account account = new Account();
        // account.setId(accountDto.getId());
        // account.setAccountHolderName(accountDto.getAccountHolderName());
        // account.setBalance(accountDto.getBalance());
        // return account;

        // we can use two ways 
        // above uses the setter methods of the Account
        // its more flexible because u can set the properties in any order
        // but it requires that account class should have setter methods
        // if account class does not have setter methods, then this approach will not work


        // below uses the constructor of the Account
        // this approach is ofter used when class is designed to be immutable
        // i.e. once an object is created, its state cannot be changed
        // this can be beneficial in multi-threaded environment
        // however, it requires that account class should have a constructor exists in account class 

        Account account = new Account (
            accountDto.getId(),
            accountDto.getAccountHolderName(),
            accountDto.getBalance()
        );
        return account;
    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
            account.getId(),
            account.getAccountHolderName(),
            account.getBalance()
        );
        return accountDto;
    }
}
