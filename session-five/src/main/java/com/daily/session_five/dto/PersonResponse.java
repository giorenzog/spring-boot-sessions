package com.daily.session_five.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PersonResponse {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private BigDecimal height;
    private String address;

    public PersonResponse() {
    }

    public PersonResponse(Long id, String name, LocalDate birthDate, BigDecimal height, String address) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.height = height;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
