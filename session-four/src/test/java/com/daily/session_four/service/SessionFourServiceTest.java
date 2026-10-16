package com.daily.session_four.service;

import com.daily.session_four.dto.PersonRequest;
import com.daily.session_four.dto.PersonResponse;
import com.daily.session_four.entity.Person;
import com.daily.session_four.repository.SessionFourRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SessionFourServiceTest {
    @Mock
    SessionFourRepository sessionFourRepository;

    SessionFourService sessionFourService;

    @BeforeEach
    void setUp(){
        sessionFourService = new SessionFourService(sessionFourRepository);
    }

    @Test
    void batchInsertPerson_mapsRequestToResponse(){
        PersonRequest request = new PersonRequest("G", 36,
                LocalDate.of(1990, 9, 17), new BigDecimal("1.60"));

        Person saved = new Person("G", 36,
                LocalDate.of(1990, 9, 17), new BigDecimal("1.60"));

        saved.setId(6L);

        when(sessionFourRepository.saveAll(anyList())).thenReturn(List.of(saved));

        List<PersonResponse> result = sessionFourService.batchInsertPerson(List.of(request));

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("G");
        assertThat(result.get(0).getId()).isEqualTo(6L);
    }

    @Test
    void findAllPersons_mapEntitiesToResponses(){
        Person saved = new Person("F", 34,
                LocalDate.of(1992, 9, 17), new BigDecimal("1.75"));

        saved.setId(5L);

        when(sessionFourRepository.findAll()).thenReturn(List.of(saved));

        List<PersonResponse> result = sessionFourService.findAllPersons();

        assertThat(result).extracting(PersonResponse::getId).containsExactly(5L);
        verify(sessionFourRepository).findAll();
    }
}
