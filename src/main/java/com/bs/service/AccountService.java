package com.bs.service;

import com.bs.dto.AccountDto;
import com.bs.entity.Account;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccount(Long accountNo);
    AccountDto deposit(Long accountNo,double amount);
    AccountDto withDraw(Long accountNo,double amount);
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long accountNo);
}
