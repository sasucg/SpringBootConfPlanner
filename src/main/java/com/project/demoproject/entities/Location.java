package com.project.demoproject.entities;

public class Location {
    public int getLocationId() {
        return LocationId;
    }

    public void setLocationId(int locationId) {
        LocationId = locationId;
    }

    public int getDictionaryCityId() {
        return DictionaryCityId;
    }

    public void setDictionaryCityId(int dictionaryCityId) {
        DictionaryCityId = dictionaryCityId;
    }

    public String getLocationAddress() {
        return LocationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        LocationAddress = locationAddress;
    }

    private int LocationId;
    private int DictionaryCityId;
    private String LocationAddress;
}
