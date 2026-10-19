package com.daily.session_seven.repository;

import com.daily.session_seven.entity.Person;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public final class PersonSpecifications {

    private PersonSpecifications() {
    }

    public static Specification<Person> nameContains(String name){
        if(name == null || name.isBlank()) return null;

        return ((root, query, cb) ->
                cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
    }

    public static Specification<Person> ageAtLeast(Integer minAge, LocalDate today){
        if(minAge == null) return null;

        return (root, query, cb) ->
                cb.lessThanOrEqualTo(root.get("birthDate"), today.minusYears(minAge));
    }

    public static Specification<Person> ageAtMost(Integer maxAge, LocalDate today){
        if(maxAge == null) return null;

        return (root, query, cb) ->
                cb.greaterThan(root.get("birthDate"), today.minusYears(maxAge + 1));
    }
}
