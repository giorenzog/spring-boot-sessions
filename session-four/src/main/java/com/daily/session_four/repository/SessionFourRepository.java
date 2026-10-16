package com.daily.session_four.repository;

import com.daily.session_four.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionFourRepository extends JpaRepository<Person, Long> {
}
