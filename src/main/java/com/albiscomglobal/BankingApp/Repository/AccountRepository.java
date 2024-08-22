package com.albiscomglobal.BankingApp.Repository;

import com.albiscomglobal.BankingApp.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
