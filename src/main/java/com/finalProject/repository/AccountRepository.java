package com.finalProject.repository;

import com.finalProject.model.Account;
import com.finalProject.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findAccountByAccountNumber(String accountNumber);

    List<Account> findAccountsByCurrencyIgnoreCase(String currency);

    List<Account> findAccountsByAccountNumberContainsIgnoreCase(String accountNumber);

    List<Account> findAccountsByCurrencyIgnoreCaseAndStatus(String currency, int status);


}
