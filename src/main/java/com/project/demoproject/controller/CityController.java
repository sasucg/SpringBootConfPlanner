package com.project.demoproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demoproject.entities.DictionaryCity;
import com.project.demoproject.service.CityService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DictionaryCity>> getAllCities() {

        List<DictionaryCity> cities = cityService.getAllCities();

        if (cities.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.of());
        else return ResponseEntity
                .ok()
                .body(cities);
    }

    @PostMapping("/save")
    public DictionaryCity addCity(@RequestBody DictionaryCity city)    {
        return cityService.addCity(city);
    }

    @PutMapping("/save")
    public void updateCity(@RequestBody DictionaryCity city) {
        cityService.updateCity(city);
    }

    @GetMapping("/{id}")
    public DictionaryCity getCityById(@PathVariable int id) {
        return cityService.getCityById(id);
    }

    @GetMapping("/bydistrictid/{id}")
    public ResponseEntity<List<DictionaryCity>> getCitiesByDistrictId(@PathVariable int id) {

        List<DictionaryCity> cities = cityService.getCitiesByDistrictId(id);

        if (cities.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.of());
        else return ResponseEntity
                .ok()
                .body(cities);
    }

    @DeleteMapping("/delete")
    public void deleteCity(@RequestBody DictionaryCity city) {
        cityService.deleteCity(city);
    }
}
