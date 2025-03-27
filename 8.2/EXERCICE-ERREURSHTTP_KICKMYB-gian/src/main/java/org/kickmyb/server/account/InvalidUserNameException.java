package org.kickmyb.server.account;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InvalidUserNameException extends RuntimeException {
    public InvalidUserNameException(String ErrorMessage) {
        super(ErrorMessage);
    }
}
