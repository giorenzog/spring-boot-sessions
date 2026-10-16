package com.daily.session_five.controller;

import com.daily.session_five.dto.PersonRequest;
import com.daily.session_five.dto.PersonResponse;
import com.daily.session_five.service.SessionFiveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/v1/persons")
@Validated
public class SessionFiveController {

    private final SessionFiveService sessionFiveService;

    public SessionFiveController(SessionFiveService sessionFiveService) {
        this.sessionFiveService = sessionFiveService;
    }

    @PostMapping("/batch")
    public ResponseEntity<?> batchCreatePerson(@RequestBody List<PersonRequest> personRequests){
        List<PersonResponse> result = sessionFiveService.batchCreatePerson(personRequests);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping
    public ResponseEntity<?> createPerson(@Valid @RequestBody PersonRequest personRequest){
        PersonResponse personResponse = sessionFiveService.createPerson(personRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(personResponse);
    }

    @GetMapping
    public ResponseEntity<?> findAllPersons(){
        List<PersonResponse> result = sessionFiveService.findAllPersons();

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findPersonById(@PathVariable Long id){
        PersonResponse result = sessionFiveService.findPersonById(id);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
