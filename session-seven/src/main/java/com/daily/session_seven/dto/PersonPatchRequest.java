package com.daily.session_seven.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PersonPatchRequest {

    @Size(max = 100)
    @Pattern(regexp = ".*\\S.*", message = "must not be blank")
    private String name;
    @Past
    private LocalDate birthDate;
    @Positive
    @Digits(integer = 2, fraction = 2)
    private BigDecimal height;
    @Positive
    @Digits(integer = 3, fraction = 0)
    @Max(500)
    private Integer weight;

    public PersonPatchRequest() {
    }

    public PersonPatchRequest(String name, LocalDate birthDate, BigDecimal height, Integer weight) {
        this.name = name;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
