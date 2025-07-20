package com.app.financialTR.exceptions;

public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(String resourceName, Long fieldId){
        super(resourceName + " with id: " + fieldId + " not found");
    }
}
