package com.project.demoproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.demoproject.entities.DictionaryCity;
import com.project.demoproject.exception.NotFoundCityException;
import com.project.demoproject.service.CityService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CityController.class)
public class CityControllerTest {
    @MockBean
    private CityService cityService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Get a city with an existing id")
    public void testGetCityById() throws Exception {
        int id = 2;
        DictionaryCity city = new DictionaryCity(id, 2, "Sector 4");

        when(cityService.getCityById(id)).thenReturn(city);

        mockMvc.perform(get("/city/" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dictionaryCityName").value(city.getDictionaryCityName()))
                .andExpect(jsonPath("$.dictionaryDistrictId").value(city.getDictionaryDistrictId()));
    }

    @Test
    @DisplayName("Get cities by districtId")
    public void testGetAllCities() throws Exception {
        int districtId = 2;
        List<DictionaryCity> cities = List.of(
                new DictionaryCity(2, 2, "Sector 3"),
                new DictionaryCity(3, 2, "Sector 4"),
                new DictionaryCity(4, 2, "Sector 5"));

        when(cityService.getCitiesByDistrictId(districtId)).thenReturn(cities);

        mockMvc.perform(get("/city/bydistrictid/{id}", districtId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dictionaryCityName").value(cities.get(0).getDictionaryCityName()))
                .andExpect(jsonPath("$[1].dictionaryCityName").value(cities.get(1).getDictionaryCityName()))
                .andExpect(jsonPath("$[2].dictionaryCityName").value(cities.get(2).getDictionaryCityName()));
    }

    @Test
    @DisplayName("Add a city")
    public void testAddCity() throws Exception {
        DictionaryCity city = new DictionaryCity(10, 2, "Testing");


        when(cityService.addCity(any())).thenReturn(city);

        mockMvc.perform(post("/city/save")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(city)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dictionaryCityName").value(city.getDictionaryCityName()))
                .andExpect(jsonPath("$.dictionaryCityId").value(city.getDictionaryCityId()));
    }
}
