package com.finalProject.service.validator;

import com.finalProject.model.Account;
import com.finalProject.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class AccountValidatorUnitTest {


    private AccountRepository accountRepository = mock(AccountRepository.class) ;


    private AccountValidator accountValidator = new AccountValidator(accountRepository);

    @Test
    void checkNumberUniq() {
        when (accountRepository.findAccountByAccountNumber("123")).thenReturn(new Account());
        try {
            accountValidator.checkNumberUniq("12345");
        } catch (Exception e){
            fail();
        }
        try {
            accountValidator.checkNumberUniq("123");
            fail();
        } catch (Exception e){
            assertEquals("Account already exist: 123", e.getMessage());
        }
    }

}