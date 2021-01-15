package com.project.demoproject.entities;

public class DictionaryParticipantStatus {

    public DictionaryParticipantStatus(int dictionaryParticipantStatusId, String dictionaryParticipantStatusName) {
        DictionaryParticipantStatusId = dictionaryParticipantStatusId;
        DictionaryParticipantStatusName = dictionaryParticipantStatusName;
    }

    private int DictionaryParticipantStatusId;
    private String DictionaryParticipantStatusName;

    public int getDictionaryParticipantStatusId() {
        return DictionaryParticipantStatusId;
    }

    public void setDictionaryParticipantStatusId(int dictionaryParticipantStatusId) {
        DictionaryParticipantStatusId = dictionaryParticipantStatusId;
    }

    public DictionaryParticipantStatus() {
    }

    public String getDictionaryParticipantStatusName() {
        return DictionaryParticipantStatusName;
    }

    public void setDictionaryParticipantStatusName(String dictionaryParticipantStatusName) {
        DictionaryParticipantStatusName = dictionaryParticipantStatusName;
    }
}
