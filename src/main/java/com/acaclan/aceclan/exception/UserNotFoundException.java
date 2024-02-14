package com.acaclan.aceclan.exception;

import com.acaclan.aceclan.data.model.Clan;

public class UserNotFoundException extends ClanException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
