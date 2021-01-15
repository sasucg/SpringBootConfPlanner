package com.project.demoproject.service;

import com.project.demoproject.entities.DictionarySpeaker;
import com.project.demoproject.repository.SpeakerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SpeakerService {
    private final SpeakerRepository speakerRepository;

    public SpeakerService(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    public List<DictionarySpeaker> getAllSpeakers() {
        return speakerRepository.getAllSpeakers();
    }

    @Transactional
    public void addSpeaker(List<DictionarySpeaker> speakers) {
        speakers.forEach(speaker -> speakerRepository.addSpeaker(speaker));
    }

    public Optional<DictionarySpeaker> getSpeakerById(int id) {
        return speakerRepository.getSpeakerById(id);
    }

    public void updateSpeaker(DictionarySpeaker speaker) {
        speakerRepository.updateSpeaker(speaker);
    }

    public void deleteSpeaker(DictionarySpeaker speaker) {
        speakerRepository.deleteSpeaker(speaker);
    }

    public List<DictionarySpeaker> getSpeakerByName(String name) {
        return speakerRepository.getSpeakerByName(name);
    }

    public DictionarySpeaker getSpeakerByConferenceId(int id) {
        return speakerRepository.getSpeakerByConferenceId(id);
    }
}
