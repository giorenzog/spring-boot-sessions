package com.daily.session_seven.service;

import com.daily.session_seven.dto.PersonPatchRequest;
import com.daily.session_seven.dto.PersonResponse;
import com.daily.session_seven.entity.Person;
import com.daily.session_seven.repository.SessionSevenRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class SessionSevenServiceTest {

    @Mock
    private SessionSevenRepository sessionSevenRepository;

    @InjectMocks
    private SessionSevenService sessionSevenService;

    @Test
    void patchById_onlyWeight_leavesOtherFieldsUnchanged(){
        Person existing = new Person(1L, "Ana", LocalDate.of(1990,5,1), new BigDecimal("1.65"), 60);

        given(sessionSevenRepository.findById(1L)).willReturn(Optional.of(existing));

        PersonResponse result = sessionSevenService.patchById(1L, new PersonPatchRequest(null, null, null, 70));

        assertEquals(70, result.getWeight());
        assertEquals("Ana", result.getName());
    }



}
