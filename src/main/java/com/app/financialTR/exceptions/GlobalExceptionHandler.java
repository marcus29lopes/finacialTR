package com.app.financialTR.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateNameException.class)
    public ResponseEntity<ExceptionResponse> duplicateNameException(DuplicateNameException e) {
        String message = e.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFoundException(ResourceNotFoundException e) {
        String message = e.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
