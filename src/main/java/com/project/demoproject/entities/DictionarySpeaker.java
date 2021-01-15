package com.project.demoproject.entities;

public class DictionarySpeaker {
    public int getDictionarySpeakerId() {
        return DictionarySpeakerId;
    }

    public void setDictionarySpeakerId(int dictionarySpeakerId) {
        DictionarySpeakerId = dictionarySpeakerId;
    }

    public String getDictionarySpeakerName() {
        return DictionarySpeakerName;
    }

    public void setDictionarySpeakerName(String dictionarySpeakerName) {
        DictionarySpeakerName = dictionarySpeakerName;
    }

    public int getDictionarySpeakerRating() {
        return DictionarySpeakerRating;
    }

    public void setDictionarySpeakerRating(int dictionarySpeakerRating) {
        DictionarySpeakerRating = dictionarySpeakerRating;
    }

    public String getDictionarySpeakerImage() {
        return DictionarySpeakerImage;
    }

    public void setDictionarySpeakerImage(String dictionarySpeakerImage) {
        DictionarySpeakerImage = dictionarySpeakerImage;
    }

    public DictionarySpeaker() {
    }

    private int DictionarySpeakerId;
    private String DictionarySpeakerName;
    private int DictionarySpeakerRating;
    private String DictionarySpeakerImage;
}
