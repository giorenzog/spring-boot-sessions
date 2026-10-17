package com.daily.session_seven.service;

import com.daily.session_seven.config.PaginationProperties;
import com.daily.session_seven.dto.PersonPatchRequest;
import com.daily.session_seven.dto.PersonRequest;
import com.daily.session_seven.dto.PersonResponse;
import com.daily.session_seven.entity.Person;
import com.daily.session_seven.exception.PersonNotFoundException;
import com.daily.session_seven.repository.SessionSevenRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class SessionSevenService {

    private final SessionSevenRepository sessionSevenRepository;
    private final PaginationProperties paginationProperties;

    public SessionSevenService(SessionSevenRepository sessionSevenRepository, PaginationProperties paginationProperties) {
        this.sessionSevenRepository = sessionSevenRepository;
        this.paginationProperties = paginationProperties;
    }

    @Transactional
    public PersonResponse createPerson(PersonRequest personRequest){
        Person person = sessionSevenRepository.save(toEntity(personRequest));

        return toResponse(person);
    }

    public PersonResponse findById(Long id){
        return toResponse(sessionSevenRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id)));
    }

    public Page<PersonResponse> findAll(Pageable pageable){
        int size = Math.min(pageable.getPageSize(), paginationProperties.getMaxSize());
        Pageable capped = PageRequest.of(pageable.getPageNumber(), size, pageable.getSort());

        return sessionSevenRepository.findAll(capped).map(this::toResponse);
    }

    @Transactional
    public PersonResponse replaceById(Long id, PersonRequest personRequest){
        Person person = sessionSevenRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

        person.setName(personRequest.getName());
        person.setBirthDate(personRequest.getBirthDate());
        person.setHeight(personRequest.getHeight());
        person.setWeight(personRequest.getWeight());

        return toResponse(person);
    }

    @Transactional
    public PersonResponse patchById(Long id, PersonPatchRequest personPatchRequest){
        Person person = sessionSevenRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

        if(personPatchRequest.getName() != null){ person.setName(personPatchRequest.getName()); }
        if(personPatchRequest.getBirthDate() != null){ person.setBirthDate(personPatchRequest.getBirthDate()); }
        if(personPatchRequest.getHeight() != null){ person.setHeight(personPatchRequest.getHeight()); }
        if(personPatchRequest.getWeight() != null){ person.setWeight(personPatchRequest.getWeight()); }

        return toResponse(person);
    }

    @Transactional
    public void deleteById(Long id){
        Person person = sessionSevenRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

        sessionSevenRepository.delete(person);
    }

    private Person toEntity(PersonRequest personRequest){
        return new Person(personRequest.getName(), personRequest.getBirthDate(),
                personRequest.getHeight(), personRequest.getWeight());
    }

    private PersonResponse toResponse(Person person){
        return new PersonResponse(person.getId(), person.getName(), person.getBirthDate(),
                person.getHeight(), person.getWeight());
    }
}
