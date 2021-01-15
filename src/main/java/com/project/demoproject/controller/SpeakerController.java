package com.project.demoproject.controller;
import com.project.demoproject.entities.DictionarySpeaker;
import com.project.demoproject.service.SpeakerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/speaker")
public class SpeakerController {
    private final SpeakerService speakerService;

    public SpeakerController(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DictionarySpeaker>> getAllSpeakers() {

        List<DictionarySpeaker> speakers = speakerService.getAllSpeakers();

        if (speakers.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.of());
        else return ResponseEntity
                .ok()
                .body(speakers);
    }

    @PostMapping("/save")
    public void addSpeaker(@RequestBody List<DictionarySpeaker> speakers)    {
        speakerService.addSpeaker(speakers);
    }

    @GetMapping("/{id}")
    public Optional<DictionarySpeaker> getSpeakerById(@PathVariable int id) {
        return speakerService.getSpeakerById(id);
    }

    @GetMapping("/conference/{id}")
    public DictionarySpeaker getSpeakerByConferenceId(@PathVariable int id) {
        return speakerService.getSpeakerByConferenceId(id);
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<List<DictionarySpeaker>> getSpeakerByName(@PathVariable("name") String name) {
        List<DictionarySpeaker> speakers = speakerService.getSpeakerByName(name);;

        if (speakers.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.of());
        else return ResponseEntity
                .ok()
                .body(speakers);
    }

    @PutMapping("/save")
    public void updateSpeaker(@RequestBody DictionarySpeaker speaker) {
        speakerService.updateSpeaker(speaker);
    }

    @DeleteMapping("/delete")
    public void deleteSpeaker(@RequestBody DictionarySpeaker speaker) {
        speakerService.deleteSpeaker(speaker);
    }
}
