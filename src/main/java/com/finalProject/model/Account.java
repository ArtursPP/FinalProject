package com.finalProject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")

public class Account {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "BALLANCE")
    private Double ballance;

    @Column(name = "STATUS")
    private Integer status;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Card> card;

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBallance() {
        return ballance;
    }

    public void setBallance(Double ballance) {
        this.ballance = ballance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
