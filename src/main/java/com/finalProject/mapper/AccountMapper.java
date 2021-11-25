package com.finalProject.mapper;


import com.finalProject.dto.AccountDTO;
import com.finalProject.model.Account;
import org.springframework.stereotype.Component;


@Component
public class AccountMapper {



    public Account fromDTO(AccountDTO accountDTO){
        Account account = new Account();
        account.setId(accountDTO.getId());
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setBallance(accountDTO.getBallance());
        account.setCurrency(accountDTO.getCurrency());

        if ( "ACTIVE".equals(accountDTO.getStatus())){
            account.setStatus(1);
        } else {
            account.setStatus(0);
        }

        return account;
    }

    public AccountDTO toDTO (Account account){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setBallance(account.getBallance());
        accountDTO.setCurrency(account.getCurrency());

        if(account.getStatus() == 1 ){
            accountDTO.setStatus("ACTIVE");
        } else {
            accountDTO.setStatus("CLOSE");
        }
        return accountDTO;
    }



}
