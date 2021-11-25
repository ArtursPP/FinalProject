package com.finalProject.controller;


import com.finalProject.dto.AccountDTO;
import com.finalProject.mapper.AccountMapper;
import com.finalProject.model.Account;
import com.finalProject.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/rest/Account.svc")
public class AccountController {


    private AccountService accountService;
    private AccountMapper accountMapper;


    @GetMapping(value = "/accounts")
    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccount();
        return accounts.stream().map(t -> accountMapper.toDTO(t)).collect(Collectors.toList());

    }

    public AccountController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping(value = "/account({id})")
    public AccountDTO getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        return accountMapper.toDTO(account);
    }

    @GetMapping(value = "/account/{accountNumber}")
    public AccountDTO getAccountByNumber(@PathVariable String accountNumber) {
        Account account = accountService.getAccountByNumber(accountNumber);
        return accountMapper.toDTO(account);
    }

    @GetMapping(value = "/account/currency/{currency}")
    public List<AccountDTO> getAccountsByCurrency(@PathVariable String currency) {
        List<Account> accounts = accountService.getAccountsByCurrency(currency);
        return accounts.stream().map(t -> accountMapper.toDTO(t)).collect(Collectors.toList());
    }

    @GetMapping(value = "/account/currency/{currency}/status/{status}")
    public List<AccountDTO> getAccountsByCurrencyAndStatus(@PathVariable String currency, @PathVariable String status) {
        List<Account> accounts = accountService.getAccountsByCurrencyAndStatus(currency, status);
        return accounts.stream().map(t -> accountMapper.toDTO(t)).collect(Collectors.toList());
    }


    @GetMapping(value = "/account/number/Like/{number}")
    public List<AccountDTO> getAccountByNumberLike(@PathVariable String number) {
        List<Account> accounts = accountService.getAccountByNumberLike(number);
        return accounts.stream().map(t -> accountMapper.toDTO(t)).collect(Collectors.toList());
    }


    @PostMapping(value = "/account/filter")
    public List<AccountDTO> getAccountByExample(@RequestBody AccountDTO accountDTO) {
        Account account = accountMapper.fromDTO(accountDTO);
        List<Account> accounts = accountService.getAccountByExample(account);
        return accounts.stream().map(t -> accountMapper.toDTO(t)).collect(Collectors.toList());

    }

    @PostMapping (value="/account")
    public AccountDTO saveNewAccount (@RequestBody AccountDTO accountDTO){
        Account account = accountMapper.fromDTO(accountDTO);
        Account savedAccount = accountService.saveNewAccount(account);

        return accountMapper.toDTO(savedAccount);

    }
    @PutMapping (value="/account")
    public void updateAccount(@RequestBody AccountDTO accountDTO){
        Account account = accountMapper.fromDTO(accountDTO);
        accountService.updateAccount(account);
    }

}
