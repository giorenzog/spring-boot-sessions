package com.daily.session_two.service;

import com.daily.session_two.dto.InsertPersonRequest;
import com.daily.session_two.dto.PersonResponse;
import com.daily.session_two.entity.Person;
import com.daily.session_two.repository.SessionTwoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionTwoService {

    private final SessionTwoRepository sessionTwoRepository;

    public SessionTwoService(SessionTwoRepository sessionTwoRepository){
        this.sessionTwoRepository = sessionTwoRepository;
    }

    public int[] batchInsertPerson(List<InsertPersonRequest> insertPersonRequests){

        List<Person> personList = insertPersonRequests.stream()
            .map(this::toEntity)
            .toList();

        return sessionTwoRepository.batchInsert(personList);
    }

    public List<PersonResponse> findAllPersons(){
        List<Person> personList = sessionTwoRepository.findAllPerson();

        return personList.stream()
            .map(this::toDTO)
            .toList();
    }

    private Person toEntity(InsertPersonRequest insertPersonRequest){
        Person person = new Person();
        person.setName(insertPersonRequest.getName());
        person.setAge(insertPersonRequest.getAge());
        return person;
    }

    private PersonResponse toDTO(Person person){
        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(person.getId());
        personResponse.setName(person.getName());
        personResponse.setAge(person.getAge());
        return personResponse;
    }

}
