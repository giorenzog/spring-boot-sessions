package com.daily.session_six.exception;

public class PersonNotFoundException extends RuntimeException {

    private final Long id;

    public PersonNotFoundException(Long id) {
        super("Person not found: " + id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
