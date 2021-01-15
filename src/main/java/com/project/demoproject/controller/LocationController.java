package com.project.demoproject.controller;

import com.project.demoproject.DTOs.LocationModel;
import com.project.demoproject.entities.DictionaryCity;
import com.project.demoproject.entities.DictionaryDistrict;
import com.project.demoproject.entities.Location;
import com.project.demoproject.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<LocationModel>> getAllDistricts() {

        List<LocationModel> locations = locationService.getAllLocations();

        if (locations.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.of());
        else return ResponseEntity
                .ok()
                .body(locations);
    }

    @GetMapping("/{id}")
    public LocationModel getLocationById(@PathVariable int id) {
        return locationService.getLocationById(id);
    }

    @PostMapping("/save")
    public void addLocation(@RequestBody Location location)    {
        locationService.addLocation(location);
    }
    @PutMapping("/save")
    public void updateLocation(@RequestBody Location location)    {
        locationService.updateLocation(location);
    }

}
