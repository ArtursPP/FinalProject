package com.finalProject.controller;


import com.finalProject.dto.AccountDTO;
import com.finalProject.dto.CardDTO;
import com.finalProject.mapper.AccountMapper;
import com.finalProject.mapper.CardMapper;
import com.finalProject.model.Account;
import com.finalProject.model.Card;
import com.finalProject.service.AccountService;
import com.finalProject.service.CardService;
import com.finalProject.service.validator.AccountValidator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/rest/Account.svc")
@CrossOrigin(origins = "*")
public class AccountController {


    private AccountService accountService;
    private AccountMapper accountMapper;
    private CardMapper cardMapper;
    private AccountValidator accountValidator;
    private CardService cardService;


    @GetMapping(value = "/accounts")
    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccount();
        return accounts.stream().map(t -> accountMapper.toDTO(t)).collect(Collectors.toList());

    }



    @GetMapping(value = "/account({id})")
    public AccountDTO getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);

        AccountDTO accountDTO = accountMapper.toDTO(account);
        List<Card> cards = account.getCards();
        List<CardDTO> cardDTOs = cards.stream().map(t -> cardMapper.toCardDTO(t)).collect(Collectors.toList());
        accountDTO.setCardDTOs(cardDTOs);
        return accountDTO;
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

    @PostMapping(value = "/account")
    public AccountDTO saveNewAccount(@RequestBody @Valid AccountDTO accountDTO) {
        accountValidator.checkNumberUniq(accountDTO.getAccountNumber());
        Account account = accountMapper.fromDTO(accountDTO);
        Account savedAccount = accountService.saveNewAccount(account);

        return accountMapper.toDTO(savedAccount);

    }

    @PutMapping(value = "/account")
    public void updateAccount(@RequestBody @Valid AccountDTO accountDTO) {

        Account account = accountMapper.fromDTO(accountDTO);
        accountService.updateAccount(account);
    }
    @PutMapping(value="/remove({id})")
    public void removeCardFromAccount(@PathVariable Long id){
        cardService.removeCardFromAccount(id);
    }

}
