package com.daily.session_seven.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, precision = 4, scale = 2)
    @Positive
    private BigDecimal height;

    @Column(nullable = false)
    @Positive
    @Max(500)
    private int weight;

    public Person() {
    }

    public Person(Long id, String name, LocalDate birthDate, BigDecimal height, int weight) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
    }

    public Person(String name, LocalDate birthDate, BigDecimal height, int weight) {
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
