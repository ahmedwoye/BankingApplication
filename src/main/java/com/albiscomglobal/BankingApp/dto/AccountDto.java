package com.albiscomglobal.BankingApp.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AccountDto {

    private Long id;
    private String accountHolderName;
    private double balance;
}
