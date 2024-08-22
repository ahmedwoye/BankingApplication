package com.albiscomglobal.BankingApp.mapper;

import com.albiscomglobal.BankingApp.Entity.Account;
import com.albiscomglobal.BankingApp.dto.AccountDto;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){

        Account account = new Account(

                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );

        return account;
    }

    public static AccountDto mapToAccountDto (Account account){
        AccountDto accountDto = new AccountDto(

                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );

        return accountDto;
    }
}
