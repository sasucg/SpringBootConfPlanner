package com.project.demoproject.service;

import com.project.demoproject.DTOs.ConferenceModel;
import com.project.demoproject.entities.Conference;
import com.project.demoproject.exception.NotFoundConferenceException;
import com.project.demoproject.repository.ConferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService {
    private final ConferenceRepository conferenceRepository;

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public List<ConferenceModel> getAllConferences() {
        return conferenceRepository.getAllConferences();
    }

    public void addConference(Conference conference) {
        conferenceRepository.addConference(conference);

    }

    public void updateConference(Conference conference) {
        conferenceRepository.updateConference(conference);
    }

    public void deleteConference(Conference conference) {
        conferenceRepository.deleteConference(conference);
    }

    public List<ConferenceModel> getConferenceByOrganiserEmail(String email) {
        List<ConferenceModel> conferences = conferenceRepository.getConferenceByOrganiserEmail(email);
        if (conferences.isEmpty()) {
            throw new NotFoundConferenceException("No conference with provided organiser email!");
        }
        return conferences;
    }
}
