package com.project.demoproject.service;

import com.project.demoproject.entities.DictionaryParticipantStatus;
import com.project.demoproject.repository.ParticipantStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParticipantStatusService {
    private final ParticipantStatusRepository participantStatusRepository;

    public ParticipantStatusService(ParticipantStatusRepository participantStatusRepository) {
        this.participantStatusRepository = participantStatusRepository;
    }

    public List<DictionaryParticipantStatus> getAllParticipantStatuses() {
        return participantStatusRepository.getAllParticipantStatuses();
    }

    public DictionaryParticipantStatus addParticipantStatus(DictionaryParticipantStatus status) {
        boolean bool = participantStatusRepository.addParticipantStatus(status);
        if (bool == true) {
            return status;}
            else return null;
    }
}
