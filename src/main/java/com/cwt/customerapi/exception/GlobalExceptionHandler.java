package com.cwt.customerapi.exception;

import com.cwt.customerapi.entity.Customer;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> customerNotFoundHandler(CustomerNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> sqlExceptionHandler(SQLException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<String> dataIntegrityViolationExceptionHandler(DataIntegrityViolationException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

}
