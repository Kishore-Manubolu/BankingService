package com.bs.service.implementation;

import com.bs.dto.AccountDto;
import com.bs.entity.Account;
import com.bs.mapper.AccountMapper;
import com.bs.repository.AccountRepository;
import com.bs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
       Account account= AccountMapper.mapToAccount(accountDto);
         Account saveAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto getAccount(Long accountNo) {

       Account account= accountRepository
               .findById(accountNo)
               .orElseThrow(()->new RuntimeException("account does not exist,please check account no once"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long accountNo, double amount) {
        Account account=accountRepository
                .findById(accountNo)
                .orElseThrow(()->new RuntimeException("not able to trace account with provided account no"));
       double balance=account.getBalance()+amount;
       account.setBalance(balance);
       Account savedAcc=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAcc);
    }

    @Override
    public AccountDto withDraw(Long accountNo, double amount) {
       Account account= accountRepository
                .findById(accountNo)
                .orElseThrow(()->new RuntimeException("not able to trace account with provided account no"));
        double remainingBalance=account.getBalance()-amount;
        account.setBalance(remainingBalance);
         Account savedAcc=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAcc);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts=accountRepository.findAll();
        return accounts.stream().map((account)-> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long accountNo) {
        Account account= accountRepository
                .findById(accountNo)
                .orElseThrow(()->new RuntimeException("not able to trace account with provided account no"));
        accountRepository.deleteById(accountNo);

    }
}
