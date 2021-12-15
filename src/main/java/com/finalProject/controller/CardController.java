package com.finalProject.controller;


import com.finalProject.dto.AccountDTO;
import com.finalProject.dto.CardDTO;
import com.finalProject.mapper.AccountMapper;
import com.finalProject.mapper.CardMapper;
import com.finalProject.model.Account;
import com.finalProject.model.Card;
import com.finalProject.service.AccountService;
import com.finalProject.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(value = "/api/rest/Card.svc")

public class CardController {

    private CardService cardService;
    private CardMapper cardMapper;
    private AccountService accountService;
    private AccountMapper accountMapper;

    @Autowired
    public CardController(CardService cardService, CardMapper cardMapper, AccountMapper accountMapper) {
        this.cardService = cardService;
        this.cardMapper = cardMapper;
        this.accountMapper = accountMapper;
    }

    @GetMapping(value = "/cards")
    public List<CardDTO> getAllCards() {
        List<Card> cards = cardService.getAlCards();
        return cards.stream().map(t -> cardMapper.toCardDTO(t)).collect(Collectors.toList());
    }

    @GetMapping(value = "/cards({id})")
    public CardDTO getCardById(@PathVariable Long id) {
        Card card = cardService.getCardById(id);
        return cardMapper.toCardDTO(card);
    }

    @GetMapping(value = "/cards{cardNumber}")
    public CardDTO getCardByCardNumber(@PathVariable String cardNumber) {
        Card card = cardService.getCardByCardNumber(cardNumber);
        CardDTO cardDTO = cardMapper.toCardDTO(card);
        Account account = card.getAccount();
        AccountDTO accountDTO = accountMapper.toDTO(account);
        cardDTO.setAccountDTO(accountDTO);
        return cardDTO;
    }


    @GetMapping(value = "/cards/{cardHolder}")
    public List<CardDTO> getCardByCardHolder(@PathVariable String cardHolder) {
        List<Card> card = cardService.getCardByCardHolder(cardHolder);
        return card.stream().map(t -> cardMapper.toCardDTO(t)).collect(Collectors.toList());
    }

    @GetMapping(value = "/cards/{id}/card/{cardHolder}")
    public List<CardDTO> getAccountIdOrCardHolder(@PathVariable Account id, @PathVariable Card cardHolder) {

        List<Card> cards = cardService.getAccountIdOrCardHolder(id, cardHolder);
        return cards.stream().map(t -> cardMapper.toCardDTO(t)).collect(Collectors.toList());
    }

    @GetMapping(value = "/cards/cardHolder/Like/{cardHolder}")
    public List<CardDTO> getCardByCardHolderLike(@PathVariable String cardHolder) {
        List<Card> cards = cardService.getCardByCardHolderlike(cardHolder);
        return cards.stream().map(t -> cardMapper.toCardDTO(t)).collect(Collectors.toList());
    }

    @PutMapping(value = "/remove({id})")
    public void removeCardFromAccount(@PathVariable Long id) {
        cardService.removeCardFromAccount(id);
    }
}
