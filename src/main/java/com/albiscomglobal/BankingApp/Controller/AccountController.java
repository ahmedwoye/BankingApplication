package com.albiscomglobal.BankingApp.Controller;


import com.albiscomglobal.BankingApp.Service.AccountService;
import com.albiscomglobal.BankingApp.dto.AccountDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    //Add Account REST API

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<AccountDto>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

@GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return  ResponseEntity.ok(accountDto);
    }


    //Deposit Rest API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> Deposit(@PathVariable Long id, @RequestBody  Map<String,Double> request){

        Double amount = request.get("amount");
       AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    //Withdraw REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody  Map<String,Double> request){

        Double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }


    //Get All Account

    @GetMapping
    public ResponseEntity<List<AccountDto>> getllAccount(){
        return new ResponseEntity<List<AccountDto>>(accountService.getAllAccount(), HttpStatus.OK);
    }

    //Delete Account REST API

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable  Long id){
        accountService.deleteSingleAccount(id);
        return ResponseEntity.ok("Account is deleted successfully!");
    }
}
