package com.albiscomglobal.BankingApp.Repository;

import com.albiscomglobal.BankingApp.Entity.Account;
import com.albiscomglobal.BankingApp.dto.AccountDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AccountRepositoryTest {


@Autowired
    private  AccountRepository accountRepository;




@Test
    public void saveAccount(){

        Account account = Account.builder()
                .accountHolderName("Morenike")
                .balance(20000)


                .build();
    accountRepository.save(account);


}
}