package com.nimko.shppmentorpracktic6.excepion;

public class MyValidatorException extends Exception{
    private final String MESSAGE = "Input person not valid!";

    @Override
    public String getMessage() {
        return MESSAGE;
    }

    @Override
    public String toString() {
        return "MyValidatorException{" +
                "MESSAGE='" + MESSAGE + '\'' +
                '}';
    }
}
