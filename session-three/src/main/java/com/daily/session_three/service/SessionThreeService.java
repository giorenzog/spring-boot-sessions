package com.daily.session_three.service;

import com.daily.session_three.dto.PersonRequest;
import com.daily.session_three.dto.PersonResponse;
import com.daily.session_three.entity.Person;
import com.daily.session_three.repository.SessionThreeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionThreeService {
    private final SessionThreeRepository sessionThreeRepository;

    public SessionThreeService(SessionThreeRepository sessionThreeRepository){
        this.sessionThreeRepository = sessionThreeRepository;
    }

    public List<PersonResponse> batchInsertPerson(List<PersonRequest> personRequestList){
        List<Person> personList = personRequestList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());

        List<Person> savedPersonList = sessionThreeRepository.saveAll(personList);

        return savedPersonList.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

    }

    public List<PersonResponse> findAllPersons(){
       List<Person> resultPersonList = sessionThreeRepository.findAll();

       return resultPersonList.stream()
               .map(this::toResponse)
               .collect(Collectors.toList());
    }

    private Person toEntity(PersonRequest personRequest){
        return new Person(personRequest.getName(), personRequest.getAge(),
                personRequest.getBirthDate(), personRequest.getHeight());
    }

    private PersonResponse toResponse(Person person){
        return new PersonResponse(person.getId(), person.getName(), person.getAge(),
                person.getBirthDate(), person.getHeight());
    }
}
