package com.daily.session_six.controller;

import com.daily.session_six.dto.PersonRequest;
import com.daily.session_six.dto.PersonResponse;
import com.daily.session_six.service.SessionSixService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/session-six/persons")
@Validated
public class SessionSixController {

    private final SessionSixService sessionSixService;

    public SessionSixController(SessionSixService sessionSixService) {
        this.sessionSixService = sessionSixService;
    }

    @PostMapping("/batch")
    public ResponseEntity<List<PersonResponse>> batchCreatePerson(@Valid @RequestBody List<PersonRequest> personRequests){
        List<PersonResponse> responseList = sessionSixService.batchCreatePerson(personRequests);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseList);
    }

    @PostMapping
    public ResponseEntity<PersonResponse> createPerson(@Valid @RequestBody PersonRequest personRequest){
        PersonResponse response = sessionSixService.createPerson(personRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PersonResponse>> findAll(){
        List<PersonResponse> responseList = sessionSixService.findAll();

        return ResponseEntity.ok(responseList);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<PersonResponse> findById(@PathVariable Long id){
        PersonResponse response = sessionSixService.findById(id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        sessionSixService.deletePerson(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonResponse> updatePerson(@PathVariable Long id, @Valid @RequestBody PersonRequest personRequest){
        PersonResponse personResponse = sessionSixService.updatePerson(id, personRequest);

        return ResponseEntity.ok(personResponse);
    }

}
