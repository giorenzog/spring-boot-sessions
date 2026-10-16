package com.daily.session_one.service;

import com.daily.session_one.PersonCreationDTO;
import com.daily.session_one.entity.Person;
import com.daily.session_one.repository.SessionOneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionOneService {

    private final SessionOneRepository sessionOneRepository;

    public SessionOneService(SessionOneRepository sessionOneRepository){
        this.sessionOneRepository = sessionOneRepository;
    }

    public List<PersonCreationDTO> batchInsertPerson(List<PersonCreationDTO> personCreationDTOList){

        List<Person> personList = personCreationDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());

        List<Person> savedPersonList = sessionOneRepository.saveAll(personList);

        return savedPersonList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private Person toEntity(PersonCreationDTO personCreationDTO){
        Person person = new Person();
        person.setName(personCreationDTO.getName());
        return person;
    }

    private PersonCreationDTO toDTO(Person person){
        PersonCreationDTO personCreationDTO = new PersonCreationDTO();
        personCreationDTO.setName(person.getName());
        personCreationDTO.setPersonId(person.getPersonId());
        return personCreationDTO;
    }

}
