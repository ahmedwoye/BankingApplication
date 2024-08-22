package com.albiscomglobal.BankingApp.Entity;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Accounts")
@Entity
@Builder
public class Account {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    private Long id;

    @Column(name="account_holder_name")
    private String accountHolderName;
    private double balance;
}
