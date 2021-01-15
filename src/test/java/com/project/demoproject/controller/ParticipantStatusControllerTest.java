package com.project.demoproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.demoproject.entities.DictionaryParticipantStatus;
import com.project.demoproject.service.ParticipantStatusService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ParticipantStatusController.class)
public class ParticipantStatusControllerTest {
    @MockBean
    private ParticipantStatusService participantStatusService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Add a participant status")
    public void testAddStatus() throws Exception {
        DictionaryParticipantStatus status = new DictionaryParticipantStatus(2, "Testing");

        when(participantStatusService.addParticipantStatus(any())).thenReturn(status);

        mockMvc.perform(post("/participantstatus/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(status)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dictionaryParticipantStatusId").value(status.getDictionaryParticipantStatusId()))
                .andExpect(jsonPath("$.dictionaryParticipantStatusName").value(status.getDictionaryParticipantStatusName()));
    }
}