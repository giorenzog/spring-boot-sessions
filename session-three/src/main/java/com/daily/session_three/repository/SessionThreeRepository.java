package com.daily.session_three.repository;

import com.daily.session_three.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionThreeRepository extends JpaRepository<Person, Long> {
}
