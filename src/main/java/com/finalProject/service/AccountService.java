package com.finalProject.service;


import com.finalProject.model.Account;
import com.finalProject.repository.AccountRepository;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class AccountService {


    private AccountRepository accountRepository;
    private ExampleMatcher matcher;

    @PostConstruct
    private void init() {
        matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();
    }

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Account getAccountById(Long id) {
        return accountRepository.getById(id);
    }


    public Account getAccountByNumber(String accountNumber) {

        return accountRepository.findAccountByAccountNumber(accountNumber);
    }


    public List<Account> getAccountsByCurrency(String currency) {
        return accountRepository.findAccountsByCurrencyIgnoreCase(currency);
    }

    public List<Account> getAccountsByCurrencyAndStatus(String currency, String status) {
        int accountStatus = 0;
        if ("ACTIVE".equals(status)) {
            accountStatus = 1;
        }

        return accountRepository.findAccountsByCurrencyIgnoreCaseAndStatus(currency, accountStatus);
    }

    public List<Account> getAccountByNumberLike(String number) {

        return accountRepository.findAccountsByAccountNumberContainsIgnoreCase(number);
    }


    public List<Account> getAccountByExample(Account account) {
        Example<Account> accountExample = Example.of(account, matcher);
        return accountRepository.findAll(accountExample);
    }

    public Account saveNewAccount(Account account) {
        return accountRepository.save(account);


    }

    public void updateAccount(Account account){
        accountRepository.save(account);
    }
}
