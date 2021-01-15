package com.project.demoproject.controller;

import com.project.demoproject.entities.DictionaryCity;
import com.project.demoproject.entities.DictionaryConferenceCategory;
import com.project.demoproject.entities.DictionaryParticipantStatus;
import com.project.demoproject.service.ParticipantStatusService;
import com.project.demoproject.service.SpeakerService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/participantstatus")
public class ParticipantStatusController {
    private final ParticipantStatusService participantStatusService;

    public ParticipantStatusController(ParticipantStatusService participantStatusService) {
        this.participantStatusService = participantStatusService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DictionaryParticipantStatus>> getAllParticipantStatuses() {

        List<DictionaryParticipantStatus> participantStatuses = participantStatusService.getAllParticipantStatuses();

        if (participantStatuses.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.of());
        else return ResponseEntity.ok().body(participantStatuses);
    }

    @PostMapping("/save")
    public ResponseEntity<DictionaryParticipantStatus> addParticipantStatus(@RequestBody DictionaryParticipantStatus status)    {
        DictionaryParticipantStatus bool = participantStatusService.addParticipantStatus(status);
        if (bool != null)
            return ResponseEntity.ok().body(bool);
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
