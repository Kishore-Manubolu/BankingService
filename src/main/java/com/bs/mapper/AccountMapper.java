package com.bs.mapper;

import com.bs.dto.AccountDto;
import com.bs.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        Account account=new Account(
                accountDto.getAccountNo(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance(),
                accountDto.getMobile()
        );
        return account;
    }
    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto=new AccountDto(
                account.getAccountNo(),
                account.getAccountHolderName(),
                account.getBalance(),
                account.getMobile()
        );
        return accountDto;
    }
}
