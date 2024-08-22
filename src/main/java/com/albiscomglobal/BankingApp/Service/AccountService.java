package com.albiscomglobal.BankingApp.Service;

import com.albiscomglobal.BankingApp.Entity.Account;
import com.albiscomglobal.BankingApp.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount (AccountDto accountDto);

    AccountDto getAccountById (Long id);

    AccountDto deposit (Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccount();


    void deleteSingleAccount ( Long id);
}
