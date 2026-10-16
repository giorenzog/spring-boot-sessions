package com.daily.session_seven.repository;

import com.daily.session_seven.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionSevenRepository extends JpaRepository<Person, Long> {

}
