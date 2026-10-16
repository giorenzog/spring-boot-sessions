package com.daily.session_four.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PersonResponse {

    private Long id;
    private String name;
    private int age;
    private LocalDate birthdate;
    private BigDecimal height;

    public PersonResponse() {
    }

    public PersonResponse(Long id, String name, int age, LocalDate birthdate, BigDecimal height) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }
}
