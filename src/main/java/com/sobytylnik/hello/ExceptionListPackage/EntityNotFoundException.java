package com.sobytylnik.hello.ExceptionListPackage;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message){
        super(message);
    }
}
