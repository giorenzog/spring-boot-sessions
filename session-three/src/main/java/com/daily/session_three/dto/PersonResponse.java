package com.daily.session_three.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PersonResponse {

    private Long id;

    private String name;

    private int age;

    private LocalDate birthDate;

    private BigDecimal height;

    public PersonResponse(Long id, String name, int age, LocalDate birthDate, BigDecimal height) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.height = height;
    }

    public PersonResponse() {

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }
}
