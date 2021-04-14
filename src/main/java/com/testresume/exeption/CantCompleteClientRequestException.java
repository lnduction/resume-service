package com.testresume.exeption;

public class CantCompleteClientRequestException extends RuntimeException {

    public CantCompleteClientRequestException(String message) { super(message); }

    public CantCompleteClientRequestException(Throwable cause) { super(cause); }

    public CantCompleteClientRequestException(String message, Throwable cause) { super(message, cause); }
}
