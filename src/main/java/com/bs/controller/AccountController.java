package com.bs.controller;

import com.bs.dto.AccountDto;
import com.bs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bankService/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    //ADD ACCOUNT REST API IMPLEMENTATION
    @PostMapping
    public  ResponseEntity<AccountDto> toAddAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //GET ACCOUNT REST API IMPLEMENTATION
    @GetMapping("/{accountNo}")
    public ResponseEntity<AccountDto> getAccountDetails(@PathVariable Long accountNo){
        AccountDto accountDto=accountService.getAccount(accountNo);
        return ResponseEntity.ok(accountDto);
    }

    //DEPOSIT REST API IMPLEMENTATION
    @PutMapping("/{accountNo}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long accountNo,@RequestBody Map<String,Double> request){
        AccountDto accountDto=accountService.deposit(accountNo,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    //WITHDRAW REST API IMPLEMENTATION
    @PutMapping("/{accountNo}/withdraw")
    public ResponseEntity<AccountDto> withDraw(@PathVariable Long accountNo,@RequestBody Map<String,Double> request){
        AccountDto accountDto=accountService.withDraw(accountNo,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    //GET ALL ACCOUNTS REST API IMPLEMENTATION
    @GetMapping
    public ResponseEntity<List<AccountDto>> listOfAllAccounts(){
        List<AccountDto> accounts=accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    //DELETE ACCOUNT BY ACCOUNT NO
    @DeleteMapping("/{accountNo}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountNo){
        accountService.deleteAccount(accountNo);
        return ResponseEntity.ok("Account deleted Successfully....");
    }

}
