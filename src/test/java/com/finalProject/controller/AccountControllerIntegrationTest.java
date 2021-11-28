package com.finalProject.controller;

import com.finalProject.dto.AccountDTO;
import com.finalProject.model.Account;
import com.finalProject.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class AccountControllerIntegrationTest {

    @LocalServerPort
    private int port;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Test
    void getAccountById() {
        Account account = new Account();
        account.setCurrency("EUR");
        account.setAccountNumber("123456789012345678921");
        account.setStatus(1);
        account.setBallance(2554.00);
        Long savedAccountId = accountRepository.save(account).getId();
        AccountDTO accountDTO = this.restTemplate.getForObject("http://localhost:" + port + "/api/rest/Account.svc/account(" + savedAccountId + " )", AccountDTO.class);
        assertEquals("123456789012345678921", accountDTO.getAccountNumber());
        assertEquals("EUR", accountDTO.getCurrency());
        assertEquals("ACTIVE", accountDTO.getStatus());
        assertEquals(2554.00, accountDTO.getBallance());
        accountRepository.delete(account);

    }

    @Test
    void saveNewAccount() {
    }
}