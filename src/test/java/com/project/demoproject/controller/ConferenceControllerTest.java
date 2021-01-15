package com.project.demoproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.demoproject.DTOs.ConferenceModel;
import com.project.demoproject.entities.Conference;
import com.project.demoproject.entities.DictionaryCity;
import com.project.demoproject.exception.NotFoundConferenceException;
import com.project.demoproject.service.CityService;
import com.project.demoproject.service.ConferenceService;
import javassist.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ConferenceController.class)
public class ConferenceControllerTest {
    @MockBean
    private ConferenceService conferenceService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Get a conference by organiser email")
    public void testGetConferenceByOrganiserEmail() throws Exception {
        String email = "catalin";
        List<ConferenceModel> conferences = List.of(new ConferenceModel(2, "IT Talks", "catalin.unibuc@gmail.com", "Stefan", "Str Cazasului Nr 5-5 Bis", "IT", "Braila Mica", "Braila"));
        when(conferenceService.getConferenceByOrganiserEmail(email)).thenReturn(conferences);

        mockMvc.perform(get("/conference/host/" + email)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].conferenceId").value(conferences.get(0).getConferenceId()))
                .andExpect(jsonPath("$[0].conferenceName").value(conferences.get(0).getConferenceName()));
    }

    @Test
    @DisplayName("Get a conference with non-existent organiser email")
    public void testGetConferenceByOrganiserEmailBadFlow() throws Exception {
        String email = "catalin123";
        when(conferenceService.getConferenceByOrganiserEmail(email)).thenThrow(new NotFoundConferenceException("No conference with provided organiser email!"));

        mockMvc.perform(get("/conference/host/" + email)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
