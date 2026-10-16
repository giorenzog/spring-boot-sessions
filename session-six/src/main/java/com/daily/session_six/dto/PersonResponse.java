package com.daily.session_six.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PersonResponse {

    private Long id;
    private String name;
    private BigDecimal height;
    private LocalDate birthDate;
    private BigDecimal weight;
    private String address;

    public PersonResponse() {

    }

    public PersonResponse(Long id, String name, BigDecimal height, LocalDate birthDate, BigDecimal weight, String address) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.birthDate = birthDate;
        this.weight = weight;
        this.address = address;
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

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
