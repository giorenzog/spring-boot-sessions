package com.daily.session_six.service;

import com.daily.session_six.dto.PersonRequest;
import com.daily.session_six.dto.PersonResponse;
import com.daily.session_six.entity.Person;
import com.daily.session_six.exception.PersonNotFoundException;
import com.daily.session_six.repository.SessionSixRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class SessionSixService {

    private final SessionSixRepository sessionSixRepository;

    public SessionSixService(SessionSixRepository sessionSixRepository) {
        this.sessionSixRepository = sessionSixRepository;
    }

    @Transactional
    public List<PersonResponse> batchCreatePerson(List<PersonRequest> personRequests){
        List<Person> personList = personRequests.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());

        List<Person> savedPersonList = sessionSixRepository.saveAll(personList);

        return savedPersonList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public PersonResponse createPerson(PersonRequest personRequest){
        Person person = sessionSixRepository.save(toEntity(personRequest));

        return toDto(person);
    }

    @Transactional
    public void deletePerson(Long id){
        Person person = sessionSixRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

        sessionSixRepository.delete(person);
    }

    @Transactional
    public PersonResponse updatePerson(Long id, PersonRequest personRequest){
        Person person = sessionSixRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

        person.setName(personRequest.getName());
        person.setAddress(personRequest.getAddress());
        person.setHeight(personRequest.getHeight());
        person.setWeight(personRequest.getWeight());
        person.setBirthDate(personRequest.getBirthDate());

        return toDto(person);
    }

    public PersonResponse findById(Long id){
        return toDto(sessionSixRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id)));
    }

    public List<PersonResponse> findAll(){
        List<Person> personList = sessionSixRepository.findAll();

        return personList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private Person toEntity(PersonRequest personRequest){
        return new Person(personRequest.getName(), personRequest.getHeight(),
                personRequest.getBirthDate(), personRequest.getWeight(), personRequest.getAddress());
    }

    private PersonResponse toDto(Person person){
        return new PersonResponse(person.getId(), person.getName(), person.getHeight(),
                person.getBirthDate(), person.getWeight(), person.getAddress());
    }
}
