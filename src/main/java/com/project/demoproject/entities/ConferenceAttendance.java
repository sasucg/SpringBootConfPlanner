package com.project.demoproject.entities;

public class ConferenceAttendance {
    public int getConferenceId() {
        return ConferenceId;
    }

    public void setConferenceId(int conferenceId) {
        ConferenceId = conferenceId;
    }

    public String getParticipantEmailAddress() {
        return ParticipantEmailAddress;
    }

    public void setParticipantEmailAddress(String participantEmailAddress) {
        ParticipantEmailAddress = participantEmailAddress;
    }

    public int getDictionaryParticipantStatusId() {
        return DictionaryParticipantStatusId;
    }

    public void setDictionaryParticipantStatusId(int dictionaryParticipantStatusId) {
        DictionaryParticipantStatusId = dictionaryParticipantStatusId;
    }

    public String getParticipationCode() {
        return ParticipationCode;
    }

    public void setParticipationCode(String participationCode) {
        ParticipationCode = participationCode;
    }

    private int ConferenceId;
    private String ParticipantEmailAddress;
    private int DictionaryParticipantStatusId;
    private String ParticipationCode;
}
