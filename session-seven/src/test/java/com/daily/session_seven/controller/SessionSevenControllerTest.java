package com.daily.session_seven.controller;

import com.daily.session_seven.dto.PersonResponse;
import com.daily.session_seven.exception.PersonNotFoundException;
import com.daily.session_seven.security.SecurityConfig;
import com.daily.session_seven.service.SessionSevenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.hamcrest.Matchers.endsWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SessionSevenController.class)
@Import(SecurityConfig.class)
class SessionSevenControllerTest {

    private static final String BASE = "/v1/session-seven/persons";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SessionSevenService sessionSevenService;

    @Test
    void createPerson_validRequest_returns201WithLocation() throws Exception {
        given(sessionSevenService.createPerson(any()))
                .willReturn(new PersonResponse(1L, "Ana",
                        LocalDate.of(1990,5,1), new BigDecimal("1.65"),60));

        mockMvc.perform(post(BASE)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Ana\",\"birthDate\":\"1990-05-01\"" +
                        ",\"height\":1.65,\"weight\":60}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", endsWith(BASE + "/1")))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void createPerson_blankName_returns400WithFieldError() throws Exception {
        mockMvc.perform(post(BASE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"\",\"birthDate\":\"1990-05-01\"" +
                                ",\"height\":1.65,\"weight\":60}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.name").value("must not be blank"));

        verifyNoInteractions(sessionSevenService);
    }

    @Test
    void findById_missing_returns404() throws Exception {
        given(sessionSevenService.findById(99L)).willThrow(new PersonNotFoundException(99L));

        mockMvc.perform(get(BASE + "/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Person not found: 99"));
    }

    @Test
    void replaceById_missingBirthDate_returns400WithFieldError() throws Exception {
        mockMvc.perform(put(BASE + "/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Ana\", \"height\":1.65,\"weight\":60}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.birthDate").value("must not be null"));

        verifyNoInteractions(sessionSevenService);

    }

    @Test
    void patchById_blankName_returns400WithFieldError() throws Exception {
        mockMvc.perform(patch(BASE + "/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.name").value("must not be blank"));

        verifyNoInteractions(sessionSevenService);
    }

    @Test
    void deleteById_validRequest_returns204() throws Exception {
        mockMvc.perform(delete(BASE + "/1"))
                .andExpect(status().isNoContent())
                .andExpect(content().string(""));

        verify(sessionSevenService).deleteById(1L);
    }
}
