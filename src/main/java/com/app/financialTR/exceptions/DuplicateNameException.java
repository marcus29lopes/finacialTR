package com.app.financialTR.exceptions;

public class DuplicateNameException extends RuntimeException {

    public DuplicateNameException(String fieldName) {
        super( fieldName + " already exists");
    }
}
