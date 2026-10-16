package com.daily.session_two.repository;

import com.daily.session_two.SessionTwoApplication;
import com.daily.session_two.entity.Person;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SessionTwoRepository {

    private final JdbcTemplate jdbcTemplate;

    public SessionTwoRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String BATCH_INSERT_SQL = "INSERT INTO person (name, age) VALUES (?, ?)";

    private static final String SELECT_ALL_PERSON_SQL = "SELECT id, name, age FROM person";


    public int[] batchInsert(List<Person> personList){

        return jdbcTemplate.batchUpdate(BATCH_INSERT_SQL, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Person person = personList.get(i);
                ps.setString(1, person.getName());
                ps.setInt(2, person.getAge());
            }

            @Override
            public int getBatchSize() {
                return personList.size();
            }
        });
    }

    public List<Person> findAllPerson(){
        return jdbcTemplate.query(SELECT_ALL_PERSON_SQL,
                (rs, rowNum) -> new Person(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("age")
                ));
    }


}
