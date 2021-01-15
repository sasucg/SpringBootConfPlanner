package com.project.demoproject.service;

import com.project.demoproject.DTOs.LocationModel;
import com.project.demoproject.entities.DictionaryDistrict;
import com.project.demoproject.entities.Location;
import com.project.demoproject.repository.DistrictRepository;
import com.project.demoproject.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationModel> getAllLocations() {
        return locationRepository.getAllLocations();
    }

    public LocationModel getLocationById(int id) {
        return locationRepository.getLocationById(id);
    }

    public void addLocation(Location location) {
        locationRepository.addLocation(location);
    }

    public void updateLocation(Location location) {
        locationRepository.updateLocation(location);
    }
}
