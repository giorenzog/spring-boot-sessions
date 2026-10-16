package com.daily.session_five.repository;

import com.daily.session_five.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionFiveRepository extends JpaRepository<Person, Long> {
}
