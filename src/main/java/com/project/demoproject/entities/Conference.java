package com.project.demoproject.entities;

import java.util.Date;

public class Conference {
    public int getConferenceId() {
        return ConferenceId;
    }

    public void setConferenceId(int conferenceId) {
        ConferenceId = conferenceId;
    }

    public String getConferenceName() {
        return ConferenceName;
    }

    public void setConferenceName(String conferenceName) {
        ConferenceName = conferenceName;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public String getOrganiserEmail() {
        return OrganiserEmail;
    }

    public void setOrganiserEmail(String organiserEmail) {
        OrganiserEmail = organiserEmail;
    }

    public int getLocationId() {
        return LocationId;
    }

    public void setLocationId(int locationId) {
        LocationId = locationId;
    }

    public int getDictionaryConferenceCategoryId() {
        return DictionaryConferenceCategoryId;
    }

    public void setDictionaryConferenceCategoryId(int dictionaryConferenceCategoryId) {
        DictionaryConferenceCategoryId = dictionaryConferenceCategoryId;
    }
    public int getSpeakerId() {
        return SpeakerId;
    }

    public void setSpeakerId(int speakerId) {
        SpeakerId = speakerId;
    }

    private int ConferenceId;
    private String ConferenceName;
    private Date StartDate;
    private Date EndDate;
    private String OrganiserEmail;
    private int LocationId;
    private int DictionaryConferenceCategoryId;
    private int SpeakerId;



}
