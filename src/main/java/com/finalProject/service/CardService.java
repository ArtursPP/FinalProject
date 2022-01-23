package com.finalProject.service;

import com.finalProject.model.Account;
import com.finalProject.model.Card;
import com.finalProject.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Component
public class CardService {

    private CardRepository cardRepository;
    private ExampleMatcher cardMatcher;

    @PostConstruct
    private void init(){
        cardMatcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();
    }

    public List<Card> getAlCards() {
        return cardRepository.findAll();
    }


    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card getCardById(Long id) {
        return cardRepository.getById(id);
    }

    public List<Card> getCardByCardHolder(String cardHolder) {
        return cardRepository.findCardByCardHolderContainsIgnoreCase(cardHolder);
    }

    public Card getCardByCardNumber(String cardNumber){
        return cardRepository.findCardByCardNumber(cardNumber);
    }


    public List<Card> getAccountIdOrCardHolder(Account id, Card cardHolder){

        return cardRepository.findByAccountIdOrCardHolder(id,  cardHolder);
    }

    public List<Card> getCardByExpDate ( Date expDate){
        return cardRepository.findCardByExpDate(expDate);
    }

    public List<Card> getCardByCardHolderlike(String cardHolder) {
        return cardRepository.findCardByCardHolderContainsIgnoreCase(cardHolder);
    }

    public void removeCardFromAccount(Long id){
        cardRepository.deleteById(id);
    }
}
