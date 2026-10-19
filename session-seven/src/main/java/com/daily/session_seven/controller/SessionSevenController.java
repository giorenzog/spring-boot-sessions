package com.daily.session_seven.controller;

import com.daily.session_seven.dto.PersonPatchRequest;
import com.daily.session_seven.dto.PersonRequest;
import com.daily.session_seven.dto.PersonResponse;
import com.daily.session_seven.dto.PersonSearchCriteria;
import com.daily.session_seven.service.SessionSevenService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/v1/session-seven/persons")
@Validated
public class SessionSevenController {

    private final SessionSevenService sessionSevenService;

    public SessionSevenController(SessionSevenService sessionSevenService) {
        this.sessionSevenService = sessionSevenService;
    }

    @PostMapping
    public ResponseEntity<PersonResponse> createPerson(@Valid @RequestBody PersonRequest personRequest){
        PersonResponse personResponse = sessionSevenService.createPerson(personRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(personResponse.getId())
                .toUri();

        return ResponseEntity.created(location).body(personResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> findById(@PathVariable Long id){
        PersonResponse personResponse = sessionSevenService.findById(id);

        return ResponseEntity.ok(personResponse);
    }

    @GetMapping
    public ResponseEntity<Page<PersonResponse>> findAll(@Valid PersonSearchCriteria criteria, Pageable pageable){
        return ResponseEntity.ok(sessionSevenService.search(criteria, pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonResponse> replaceById(@PathVariable Long id, @Valid @RequestBody PersonRequest personRequest){
        PersonResponse personResponse = sessionSevenService.replaceById(id, personRequest);

        return ResponseEntity.ok(personResponse);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<PersonResponse> patchById(@PathVariable Long id, @Valid @RequestBody PersonPatchRequest personPatchRequest){
        PersonResponse personResponse = sessionSevenService.patchById(id, personPatchRequest);

        return ResponseEntity.ok(personResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        sessionSevenService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
