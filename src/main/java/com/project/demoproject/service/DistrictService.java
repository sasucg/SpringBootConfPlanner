package com.project.demoproject.service;

import com.project.demoproject.entities.DictionaryDistrict;
import com.project.demoproject.repository.DistrictRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {
    private final DistrictRepository districtRepository;

    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public List<DictionaryDistrict> getAllDistricts() {
        return districtRepository.getAllDistricts();
    }

    @Transactional
    public void addDistrict(DictionaryDistrict districts) {
        districtRepository.addDistrict(districts);
    }

    public DictionaryDistrict getDistrictById(int id) {
        return districtRepository.getDistrictById(id);
    }

    public void updateDistrict(DictionaryDistrict district) {
        districtRepository.updateDistrict(district);
    }

    public void deleteDistrict(DictionaryDistrict district) {
        districtRepository.deleteDistrict(district);
    }
}
