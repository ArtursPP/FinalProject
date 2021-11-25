package com.finalProject.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @Column(name = "ACCOUNT_ID", insertable = false, updatable = false)
    private Long accountId;

    @Column(name = "STATUS")
    private Integer status;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}


