package com.finalProject.service.validator;


import com.finalProject.exceptions.AccountAlreadyExistException;
import com.finalProject.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component

@AllArgsConstructor
public class AccountValidator {

    private final AccountRepository accountRepository;


    public void checkNumberUniq(String accountNumber) {
        if (accountRepository.findAccountByAccountNumber(accountNumber) != null ){
            throw new AccountAlreadyExistException("Account already exist: " + accountNumber);
        }
    }

}
