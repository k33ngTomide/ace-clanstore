package com.acaclan.aceclan.exception;

public class IncorrectPasswordException extends ClanException{
    public IncorrectPasswordException(String message) {
        super(message);
    }

    public IncorrectPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
