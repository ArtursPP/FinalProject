package com.finalProject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "CARD")
public class Card {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CARD_HOLDER")
    private String cardHolder;

    @Column(name = "CARD_NUMBER")
    private String cardNumber;

    @Column(name = "EXP_DATE")
    private Date expDate;



    @Column(name = "STATUS")
    private Integer status;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;


}


