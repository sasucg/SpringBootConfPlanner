package com.project.demoproject.DTOs;

public class LocationModel {
    public int getLocationId() {
        return LocationId;
    }

    public void setLocationId(int location) {
        LocationId = location;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getLocationAddress() {
        return LocationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        LocationAddress = locationAddress;
    }
    public String getDistrictName() {
        return DistrictName;
    }

    public void setDistrictName(String districtName) {
        DistrictName = districtName;
    }
    private int LocationId;
    private String CityName;
    private String LocationAddress;
    private String DistrictName;
}
