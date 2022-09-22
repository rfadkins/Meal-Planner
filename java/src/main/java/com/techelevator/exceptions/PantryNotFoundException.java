package com.techelevator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PantryNotFoundException extends Exception {

    public PantryNotFoundException() {
        super("Pantry not found");
    }
}
