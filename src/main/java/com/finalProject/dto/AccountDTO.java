package com.finalProject.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class AccountDTO {


    private Long id;

    @JsonProperty(value = "account_number")
    @Size(min = 21, max = 21, message = "Incorrect account number length")
    private String accountNumber;


    private String currency;

    @Min(value = 2000, message = "Balance too low")
    private Double ballance;


    private String status;

    private List<CardDTO> cardDTOs;


}
