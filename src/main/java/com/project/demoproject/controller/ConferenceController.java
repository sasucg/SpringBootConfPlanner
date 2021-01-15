package com.project.demoproject.controller;

import com.project.demoproject.DTOs.ConferenceModel;
import com.project.demoproject.entities.Conference;
import com.project.demoproject.entities.DictionaryCity;
import com.project.demoproject.entities.DictionaryDistrict;
import com.project.demoproject.entities.DictionarySpeaker;
import com.project.demoproject.service.CityService;
import com.project.demoproject.service.ConferenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conference")
public class ConferenceController {
    private final ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ConferenceModel>> getAllConferences() {

        List<ConferenceModel> conferences = conferenceService.getAllConferences();

        if (conferences.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.of());
        else return ResponseEntity
                .ok()
                .body(conferences);
    }

    @PostMapping("/save")
    public void addConference(@RequestBody Conference conference)    {
        conferenceService.addConference(conference);
    }

    @PutMapping("/save")
    public void updateConference(@RequestBody Conference conference)    {
        conferenceService.updateConference(conference);
    }

    @DeleteMapping("/delete")
    public void deleteCity(@RequestBody Conference conference) {
        conferenceService.deleteConference(conference);
    }

    @GetMapping("/host/{email}")
    public ResponseEntity<List<ConferenceModel>> getConferenceByOrganiserEmail(@PathVariable("email") String email) {
        List<ConferenceModel> conferences = conferenceService.getConferenceByOrganiserEmail(email);;

        if (conferences.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.of());
        else return ResponseEntity
                .ok()
                .body(conferences);
    }
}
