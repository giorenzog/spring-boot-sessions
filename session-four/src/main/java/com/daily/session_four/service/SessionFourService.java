package com.daily.session_four.service;

import com.daily.session_four.dto.PersonRequest;
import com.daily.session_four.dto.PersonResponse;
import com.daily.session_four.entity.Person;
import com.daily.session_four.repository.SessionFourRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionFourService {

    private final SessionFourRepository sessionFourRepository;

    public SessionFourService(SessionFourRepository sessionFourRepository) {
        this.sessionFourRepository = sessionFourRepository;
    }

    public List<PersonResponse> batchInsertPerson(List<PersonRequest> personRequestList){

        List<Person> personList = personRequestList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());

        List<Person> savedPersonList = sessionFourRepository.saveAll(personList);

        return savedPersonList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<PersonResponse> findAllPersons(){
        return sessionFourRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }


    private Person toEntity(PersonRequest personRequest){
        return new Person(personRequest.getName(), personRequest.getAge(),
                personRequest.getBirthDate(), personRequest.getHeight());
    }

    private PersonResponse toDto(Person person){
        return new PersonResponse(person.getId(), person.getName(), person.getAge(),
                person.getBirthDate(), person.getHeight());
    }
}
