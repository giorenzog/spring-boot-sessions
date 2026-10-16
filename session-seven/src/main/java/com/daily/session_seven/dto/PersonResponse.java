package com.daily.session_seven.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PersonResponse {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private BigDecimal height;
    private int weight;

    public PersonResponse() {
    }

    public PersonResponse(Long id, String name, LocalDate birthDate, BigDecimal height, int weight) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
