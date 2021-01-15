package com.project.demoproject.service;

import com.project.demoproject.entities.DictionaryCity;
import com.project.demoproject.exception.NotFoundCityException;
import com.project.demoproject.repository.CityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<DictionaryCity> getAllCities() {
        return cityRepository.getAllCities();
    }

    @Transactional
    public DictionaryCity addCity(DictionaryCity city) {
        return cityRepository.addCity(city);
    }

    public DictionaryCity getCityById(int id) {

        DictionaryCity city = cityRepository.getCityById(id);
        if (city != null) {
            return city;
        } else {
            throw new NotFoundCityException("There is no city with the requested id!");
        }
    }

    public void updateCity(DictionaryCity city) {
        cityRepository.updateCity(city);
    }

    public void deleteCity(DictionaryCity city) {
        cityRepository.deleteCity(city);
    }

    public List<DictionaryCity> getCitiesByDistrictId(int id) {
        List<DictionaryCity> cities = cityRepository.getCitiesByDistrictId(id);
        if (!cities.isEmpty()) {
            return cities;
        }
        else {
            throw new NotFoundCityException("There are no cities with provided district id!");
        }
    }
}

