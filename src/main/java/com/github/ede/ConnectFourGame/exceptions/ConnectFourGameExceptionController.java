package com.github.ede.ConnectFourGame.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConnectFourGameExceptionController {
    @ExceptionHandler(value = TransactionSystemException.class)
    public ResponseEntity<Object> transactionSystemException(TransactionSystemException e){
        return new ResponseEntity<>("Number is out of bounds, please use a number 1-6 for your input", HttpStatus.I_AM_A_TEAPOT);
    }
}
