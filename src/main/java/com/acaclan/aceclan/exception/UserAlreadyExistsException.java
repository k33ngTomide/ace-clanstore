package com.acaclan.aceclan.exception;

public class UserAlreadyExistsException  extends ClanException{


    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public UserAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
