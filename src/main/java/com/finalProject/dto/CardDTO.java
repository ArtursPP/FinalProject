package com.finalProject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.finalProject.model.Account;
import lombok.Data;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class CardDTO {

    private Long id;

    @JsonProperty(value = "card_holder")
    private String cardHolder;

    @JsonProperty(value = "card_number")
    private String cardNumber;

    @JsonProperty(value = "exp_date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date expDate;

    private String status;

    private AccountDTO accountDTO;


}
