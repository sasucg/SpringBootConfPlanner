package com.project.demoproject.controller;

import com.project.demoproject.entities.ConferenceAttendance;
import com.project.demoproject.entities.DictionaryCity;
import com.project.demoproject.service.ConferenceAttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conferenceattendance")
public class ConferenceAttendanceController {
    private final ConferenceAttendanceService conferenceAttendanceService;

    public ConferenceAttendanceController(ConferenceAttendanceService conferenceAttendanceService) {
        this.conferenceAttendanceService = conferenceAttendanceService;
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<List<ConferenceAttendance>> getAllAttendances(@PathVariable int id) {

        List<ConferenceAttendance> attendances = conferenceAttendanceService.getAllConferenceAttendancesByConferenceId(id);

        if (attendances.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.of());
        else return ResponseEntity
                .ok()
                .body(attendances);
    }

    @PostMapping("/save")
    public void addAttendance(@RequestBody ConferenceAttendance attendance)    {
        conferenceAttendanceService.addConferenceAttendance(attendance);
    }

    @PutMapping("/save")
    public void updateAttendance(@RequestBody ConferenceAttendance attendance) {
        conferenceAttendanceService.updateConferenceAttendance(attendance);
    }

}
