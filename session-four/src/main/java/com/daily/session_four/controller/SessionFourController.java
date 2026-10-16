package com.daily.session_four.controller;

import com.daily.session_four.dto.PersonRequest;
import com.daily.session_four.dto.PersonResponse;
import com.daily.session_four.entity.Person;
import com.daily.session_four.service.SessionFourService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/session-four")
@Validated
public class SessionFourController {

    private final SessionFourService sessionFourService;

    public SessionFourController(SessionFourService sessionFourService) {
        this.sessionFourService = sessionFourService;
    }

    @PostMapping("/batch-insert-person")
    public ResponseEntity<?> batchInsertPerson(@Valid @RequestBody List<PersonRequest> personRequests){

        List<PersonResponse> personResponseList = sessionFourService.batchInsertPerson(personRequests);

        return ResponseEntity.status(HttpStatus.CREATED).body(personResponseList);
    }

    @GetMapping("/find-all-persons")
    public ResponseEntity<?> findAllPersons(){
        List<PersonResponse> personResponseList = sessionFourService.findAllPersons();

        return ResponseEntity.status(HttpStatus.OK).body(personResponseList);
    }


}
