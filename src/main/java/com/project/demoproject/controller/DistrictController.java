package com.project.demoproject.controller;

import com.project.demoproject.entities.DictionaryDistrict;
import com.project.demoproject.service.DistrictService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demoproject.entities.DictionaryDistrict;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/district")
public class DistrictController {

    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DictionaryDistrict>> getAllDistricts() {

        List<DictionaryDistrict> districts = districtService.getAllDistricts();

        if (districts.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.of());
        else return ResponseEntity
                .ok()
                .body(districts);
    }

    @PostMapping("/save")
    public void addDistrict(@RequestBody DictionaryDistrict district)    {
        districtService.addDistrict(district);
    }

    @GetMapping("/{id}")
    public DictionaryDistrict getDistrictById(@PathVariable int id) {
        return districtService.getDistrictById(id);
    }

    @PutMapping("/save")
    public void updateDistrict(@RequestBody DictionaryDistrict district) {
        districtService.updateDistrict(district);
    }

    @DeleteMapping("/delete")
    public void deleteDistrict(@RequestBody DictionaryDistrict district) {
        districtService.deleteDistrict(district);
    }
}
