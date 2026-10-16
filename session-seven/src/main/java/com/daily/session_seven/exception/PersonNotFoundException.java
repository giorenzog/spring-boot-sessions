package com.daily.session_seven.exception;

public class PersonNotFoundException extends RuntimeException {

    private Long id;

    public PersonNotFoundException(Long id) {
        super("Person not found: " + id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
