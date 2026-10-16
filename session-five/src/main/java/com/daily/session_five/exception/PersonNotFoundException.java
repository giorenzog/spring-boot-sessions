package com.daily.session_five.exception;

public class PersonNotFoundException extends RuntimeException{

    private final Long id;

    public PersonNotFoundException(Long id) {
        super("Person not found: " + id);
        this.id = id;
    }
}
