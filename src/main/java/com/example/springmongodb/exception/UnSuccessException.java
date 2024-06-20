package com.example.springmongodb.exception;

public class UnSuccessException extends RuntimeException{
    public UnSuccessException(String message){
        super(message);
    }
}
