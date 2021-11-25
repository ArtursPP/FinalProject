package com.finalProject.repository;

import com.finalProject.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {



    List<Card> findCardByCardHolderIgnoreCase(String cardHolder);

    List<Card> findCardByExpDate(Date expDate);

    Card findCardByCardNumber(String cardNumber);

//    List<Card> findCardByCardHolder(String cardHolder);
}
