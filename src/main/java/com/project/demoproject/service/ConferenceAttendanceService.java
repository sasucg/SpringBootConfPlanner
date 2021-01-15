package com.project.demoproject.service;

import com.project.demoproject.entities.ConferenceAttendance;
import com.project.demoproject.repository.ConferenceAttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceAttendanceService {
    private final ConferenceAttendanceRepository conferenceAttendanceRepository;

    public ConferenceAttendanceService(ConferenceAttendanceRepository conferenceAttendanceRepository) {
        this.conferenceAttendanceRepository = conferenceAttendanceRepository;
    }

    public List<ConferenceAttendance> getAllConferenceAttendancesByConferenceId(int id) {
        return conferenceAttendanceRepository.getAllConferenceAttendancesByConferenceId(id);
    }

    public void addConferenceAttendance(ConferenceAttendance attendance) {
        conferenceAttendanceRepository.addConferenceAttendance(attendance);
    }

    public void updateConferenceAttendance(ConferenceAttendance attendance) {
        conferenceAttendanceRepository.updateConferenceAttendance(attendance);
    }
}
