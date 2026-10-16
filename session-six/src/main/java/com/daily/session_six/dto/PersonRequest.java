package com.daily.session_six.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PersonRequest {

    @NotBlank
    private String name;

    @NotNull
    @Digits(integer = 3, fraction = 2)
    private BigDecimal height;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    @Digits(integer = 3, fraction = 2)
    private BigDecimal weight;

    @NotBlank
    private String address;

    public PersonRequest() {

    }

    public PersonRequest(String name, BigDecimal height, LocalDate birthDate, BigDecimal weight, String address) {
        this.name = name;
        this.height = height;
        this.birthDate = birthDate;
        this.weight = weight;
        this.address = address;
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
