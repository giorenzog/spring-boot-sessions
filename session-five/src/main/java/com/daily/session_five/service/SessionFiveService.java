package com.daily.session_five.service;

import com.daily.session_five.dto.PersonRequest;
import com.daily.session_five.dto.PersonResponse;
import com.daily.session_five.entity.Person;
import com.daily.session_five.exception.PersonNotFoundException;
import com.daily.session_five.repository.SessionFiveRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class SessionFiveService {

    private final SessionFiveRepository sessionFiveRepository;

    public SessionFiveService(SessionFiveRepository sessionFiveRepository) {
        this.sessionFiveRepository = sessionFiveRepository;
    }


    @Transactional
    public List<PersonResponse> batchCreatePerson(List<PersonRequest> personRequests){
        List<Person> personList = personRequests.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());

        List<Person> savedPersons = sessionFiveRepository.saveAll(personList);

        return savedPersons.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public PersonResponse createPerson(PersonRequest personRequest){
        Person person = sessionFiveRepository.save(this.toEntity(personRequest));

        return this.toDto(person);
    }

    public List<PersonResponse> findAllPersons(){
        return sessionFiveRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public PersonResponse findPersonById(Long id){
        Person person = sessionFiveRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
        return toDto(person);

    }

    private Person toEntity(PersonRequest personRequest){
        return new Person(personRequest.getName(), personRequest.getBirthDate(),
                personRequest.getHeight(), personRequest.getAddress());
    }

    private PersonResponse toDto(Person person){
        return new PersonResponse(person.getId(), person.getName(),person.getBirthDate(),
                person.getHeight(), person.getAddress());
    }
}
