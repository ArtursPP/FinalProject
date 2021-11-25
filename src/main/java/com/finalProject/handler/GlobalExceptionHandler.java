package com.finalProject.handler;

import com.finalProject.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    //Handle rest exception
    @ExceptionHandler(value
            = {Exception.class})
    public ResponseEntity<ErrorDTO> handleValidationException(Exception ex, WebRequest request) {
        ErrorDTO errorDTO = handleException((ServletWebRequest) request, ex.getMessage());
        return ResponseEntity.ok(errorDTO);
    }

    private ErrorDTO handleException(ServletWebRequest request, String message) {
        return new ErrorDTO(message, new Date(),
                request.getRequest().getRequestURI()
                ,true);
    }

}