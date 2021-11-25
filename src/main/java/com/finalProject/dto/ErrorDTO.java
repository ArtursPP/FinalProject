package com.finalProject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorDTO {

    private String message;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date date;

    private String path;

    private boolean isError;



}
