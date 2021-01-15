package com.project.demoproject.DTOs;

import java.util.Date;

public class ConferenceModel {

    public ConferenceModel() {
    }

    public ConferenceModel(int conferenceId, String conferenceName, String organiserEmail, String speaker, String location, String category, String city, String district) {
        ConferenceId = conferenceId;
        ConferenceName = conferenceName;
        OrganiserEmail = organiserEmail;
        Speaker = speaker;
        Location = location;
        Category = category;
        City = city;
        District = district;
    }

    private int ConferenceId;
    private String ConferenceName;
    private Date StartDate;
    private Date EndDate;
    private String OrganiserEmail;
    private String Speaker;
    private String Location;
    private String Category;

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    private String City;
    private String District;

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

    public String getSpeaker() {
        return Speaker;
    }

    public void setSpeaker(String speaker) {
        Speaker = speaker;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

}
