package com.finalProject.repository;

import com.finalProject.model.Account;
import com.finalProject.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {


    List<Card> findCardByCardHolderContainsIgnoreCase(String cardHolder);

    List<Card> findCardByExpDate(Date expDate);

    Card findCardByCardNumber(String cardNumber);



    List<Card> findByAccountIdOrCardHolder(Account id, Card cardHolder);



    void deleteById(Long id);
}
