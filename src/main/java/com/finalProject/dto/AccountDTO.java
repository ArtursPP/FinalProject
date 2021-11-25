package com.finalProject.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountDTO {


    private Long id;

    @JsonProperty(value = "account_number")
    private String accountNumber;


    private String currency;


    private Double ballance;


    private String status;


}
