package com.finalProject.controller;


import com.finalProject.dto.CardDTO;
import com.finalProject.mapper.CardMapper;
import com.finalProject.model.Account;
import com.finalProject.model.Card;
import com.finalProject.service.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/rest/Card.svc")
public class CardController {

    private CardService cardService;
    private CardMapper cardMapper;


    public CardController(CardService cardService, CardMapper cardMapper) {
        this.cardService = cardService;
        this.cardMapper = cardMapper;
    }

    @GetMapping(value = "/cards")
    public List<CardDTO> getAllCards() {
        List<Card> cards = cardService.getAlCards();
        return cards.stream().map(t -> cardMapper.toCardDTO(t)).collect(Collectors.toList());
    }

    @GetMapping(value = "/cards({id})")
    public CardDTO getCardById(@PathVariable Long id){
        Card card = cardService.getCardById(id);
        return cardMapper.toCardDTO(card);
    }

    @GetMapping(value = "/cards{cardNumber}")
    public CardDTO getCardByCardNumber(@PathVariable String cardNumber){
        Card card =  cardService.getCardByCardNumber(cardNumber);
        return  cardMapper.toCardDTO(card);
    }
    @GetMapping(value = "/cards/{cardHolder}")
    public List<CardDTO> getCardByCardHolder(@PathVariable String cardHolder){
       List<Card>  card = cardService.getCardByCardHolder(cardHolder);
        return card.stream().map(t -> cardMapper.toCardDTO(t)).collect(Collectors.toList());
    }

    @GetMapping(value = "/cards/{id}/card/{cardHolder}")
    public List<CardDTO> getAccountIdOrCardHolder(@PathVariable Account id, @PathVariable Card cardHolder){
        List<Card> cards = cardService.getAccountIdOrCardHolder(id,cardHolder);
        return cards.stream().map(t -> cardMapper.toCardDTO(t)).collect(Collectors.toList());
    }
    @GetMapping(value = "/cards/cardHolder/Like/{cardHolder}")
    public List<CardDTO> getCardByCardHolderLike (@PathVariable String cardHolder){
        List<Card> cards = cardService.getCardByCardHolderlike(cardHolder);
        return cards.stream().map(t -> cardMapper.toCardDTO(t)).collect(Collectors.toList());
    }
}
