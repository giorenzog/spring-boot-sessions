package com.daily.session_two.controller;

import com.daily.session_two.dto.BatchInsertResponse;
import com.daily.session_two.dto.InsertPersonRequest;
import com.daily.session_two.dto.PersonResponse;
import com.daily.session_two.entity.Person;
import com.daily.session_two.service.SessionTwoService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/v1/session-two")
public class SessionTwoController {

    private final SessionTwoService sessionTwoService;

    public SessionTwoController(SessionTwoService sessionTwoService){
        this.sessionTwoService = sessionTwoService;
    }

    @PostMapping("/batch-insert-person")
    public ResponseEntity<BatchInsertResponse> batchInsertPerson(@RequestBody List<InsertPersonRequest> insertPersonRequests){
        try {
            int[] result = sessionTwoService.batchInsertPerson(insertPersonRequests);

            BatchInsertResponse response = new BatchInsertResponse();
            response.setTotalInserted(result.length);
            response.setTotalRequested(insertPersonRequests.size());

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Batch insert failed: " + e.getMessage());
        }
    }

    @GetMapping("/find-all-persons")
    public ResponseEntity<?> findAllPersons(){
        List<PersonResponse> personResponses = sessionTwoService.findAllPersons();


        return ResponseEntity.status(HttpStatus.OK).body(personResponses);
    }
}
