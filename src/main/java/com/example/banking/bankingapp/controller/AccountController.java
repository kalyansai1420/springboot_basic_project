package com.example.banking.bankingapp.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking.bankingapp.service.AccountService;
import com.example.banking.bankingapp.dto.AccountDto;

@RestController // make this class as spring mvc rest controller
@CrossOrigin("*")
@RequestMapping("/api/accounts") // base url for this controller
public class AccountController {

    // inject the dependency of account service
    private AccountService accountService;

    // constructor based dependency injection
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) { // requestbody will map the request body to this java object
        // this request body will automatically convert that json into this java object
        AccountDto savedAccount = accountService.createAccount(accountDto);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

    // Get Account By Id REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    // Deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String,Double> request){

        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }



    
}
