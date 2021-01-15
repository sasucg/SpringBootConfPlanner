package com.project.demoproject.repository;

import com.project.demoproject.DTOs.LocationModel;
import com.project.demoproject.entities.DictionaryCity;
import com.project.demoproject.entities.DictionaryDistrict;
import com.project.demoproject.entities.Location;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LocationRepository {
    private final JdbcTemplate jdbcTemplate;
    private final CityRepository cityRepository;
    private final DistrictRepository districtRepository;
    public LocationRepository(JdbcTemplate jdbcTemplate, CityRepository cityRepository, DistrictRepository districtRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.cityRepository = cityRepository;
        this.districtRepository = districtRepository;
    }

    public List<LocationModel> getAllLocations() {
        String sqlCommand = "SELECT * FROM location;";
        return jdbcTemplate.query(sqlCommand, new RowMapper<LocationModel>(){
            @Override
            public LocationModel mapRow(ResultSet rs, int rownumber) throws SQLException {
                LocationModel d = new LocationModel();
                d.setLocationId(rs.getInt(1));
                DictionaryCity c = cityRepository.getCityById(rs.getInt(2));
                d.setCityName(c.getDictionaryCityName());
                d.setLocationAddress(rs.getString(3));
                return d;
            }
        });
    }

    public LocationModel getLocationById(int id) {
        String sqlCommand = "SELECT * FROM location WHERE LocationId = ?";
        LocationModel location = jdbcTemplate.queryForObject(sqlCommand, new RowMapper<LocationModel>() {
            @Override
            public LocationModel mapRow(ResultSet rs, int i) throws SQLException {
                LocationModel d = new LocationModel();
                d.setLocationId(rs.getInt(1));
                DictionaryCity c = cityRepository.getCityById(rs.getInt(2));
                d.setCityName(c.getDictionaryCityName());
                d.setLocationAddress(rs.getString(3));
                DictionaryDistrict district = districtRepository.getDistrictById(c.getDictionaryDistrictId());
                d.setDistrictName(district.getDictionaryDistrictName());
                return d;
            }
        }, id);
        return location;
    }

    public void addLocation(Location location)   {
        String sql = "INSERT INTO location VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, location.getDictionaryCityId(), location.getLocationAddress());
    }

    public void updateLocation(Location location) {
        String sqlCommand = "UPDATE location SET " +
                "DictionaryCityId = ?, " +
                "LocationAddress = ? " +
                "WHERE LocationId = ?";
        jdbcTemplate.update(sqlCommand, location.getDictionaryCityId(), location.getLocationAddress(), location.getLocationId());
    }
}
