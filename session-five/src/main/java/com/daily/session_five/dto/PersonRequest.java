package com.daily.session_five.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PersonRequest {

    @NotBlank
    private String name;

    @NotNull
    private LocalDate birthDate;

    @Digits(fraction = 2, integer = 2)
    private BigDecimal height;

    @NotBlank
    private String address;

    public PersonRequest() {
    }

    public PersonRequest(String name, LocalDate birthDate, BigDecimal height, String address) {
        this.name = name;
        this.birthDate = birthDate;
        this.height = height;
        this.address = address;
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
