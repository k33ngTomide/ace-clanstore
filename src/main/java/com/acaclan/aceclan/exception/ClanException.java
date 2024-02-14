package com.acaclan.aceclan.exception;

public class ClanException  extends RuntimeException{

    public ClanException(String message) {
        super(message);
    }

    public ClanException(String message, Throwable cause) {
        super(message, cause);
    }
}
