package com.finalProject.mapper;


import com.finalProject.dto.CardDTO;

import com.finalProject.model.Card;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public Card fromCardDTO(CardDTO cardDTO) {
        Card card = new Card();
        card.setId(card.getId());
        card.setCardHolder(card.getCardHolder());
        card.setCardNumber(card.getCardNumber());
        card.setExpDate(card.getExpDate());
        card.setAccountId(card.getAccountId());
        if ("ACTIVE".equals(cardDTO.getStatus())) {
            card.setStatus(1);
        } else {
            card.setStatus(0);
        }

        return card;
    }

    public CardDTO toCardDTO(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(card.getId());
        cardDTO.setCardHolder(card.getCardHolder());
        cardDTO.setCardNumber(card.getCardNumber());
        cardDTO.setExpDate(card.getExpDate());
        cardDTO.setAccountId(card.getAccountId());
        if (card.getStatus() == 1) {
            cardDTO.setStatus("ACTIVE");
        } else {
            cardDTO.setStatus("CLOSE");
        }
        return cardDTO;
    }

}
