package com.daily.session_three.controller;

import com.daily.session_three.dto.PersonRequest;
import com.daily.session_three.dto.PersonResponse;
import com.daily.session_three.service.SessionThreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/session-three")
@Validated
public class SessionThreeController {

    private final SessionThreeService sessionThreeService;

    public SessionThreeController(SessionThreeService sessionThreeService){
        this.sessionThreeService = sessionThreeService;
    }

    @PostMapping("/batch-insert-person")
    public ResponseEntity<?> batchInsertPerson(@Valid @RequestBody List<PersonRequest> personRequestList){

        List<PersonResponse> result = sessionThreeService.batchInsertPerson(personRequestList);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/find-all-persons")
    public ResponseEntity<?> findAllPersons(){
        List<PersonResponse> result = sessionThreeService.findAllPersons();

        return ResponseEntity.ok(result);
    }
}
