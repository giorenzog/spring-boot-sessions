package com.daily.session_three.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "age",  nullable = false)
    private int age;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "height", nullable = false)
    private BigDecimal height;

    public Person(String name, int age, LocalDate birthDate, BigDecimal height) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.height = height;
    }

    public Person() {

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
