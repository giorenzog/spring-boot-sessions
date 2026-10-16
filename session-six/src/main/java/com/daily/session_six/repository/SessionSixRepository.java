package com.daily.session_six.repository;

import com.daily.session_six.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionSixRepository extends JpaRepository<Person, Long> {
}
