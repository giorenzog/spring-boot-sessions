package com.daily.session_three.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PersonRequest {

    @NotBlank @Size(max = 255)
    private String name;

    @NotNull @PositiveOrZero @Max(150)
    private int age;

    @Past
    private LocalDate birthDate;

    @Digits(integer = 2, fraction = 2, message = "height must have at most 2 digits before and 2 digits after the decimal point")
    private BigDecimal height;

    public PersonRequest(String name, int age, LocalDate birthDate, BigDecimal height) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.height = height;
    }

    public PersonRequest() {

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
