package com.daily.session_one.repository;

import com.daily.session_one.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionOneRepository extends JpaRepository<Person, Long> {
}
