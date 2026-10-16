package com.daily.session_one.controller;

import com.daily.session_one.PersonCreationDTO;
import com.daily.session_one.service.SessionOneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/session-one")
public class SessionOneController {

    private final SessionOneService sessionOneService;

    public SessionOneController(SessionOneService sessionOneService){
        this.sessionOneService = sessionOneService;
    }

    @PostMapping("/batch-insert")
    public ResponseEntity<?> batchInsert(@RequestBody List<PersonCreationDTO> personCreationDTOList){

        List<PersonCreationDTO> createdPersonDTOList = sessionOneService.batchInsertPerson(personCreationDTOList);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdPersonDTOList);
    }

}
