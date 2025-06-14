package com.n1etzsch3.exceptiondemo1;

public class IllegalAgeRuntimeException extends RuntimeException{
    public IllegalAgeRuntimeException(){}
    public IllegalAgeRuntimeException(String message){
        super(message);
    }
}
