package com.project.demoproject.repository;


import com.project.demoproject.entities.Admin;
import com.project.demoproject.entities.DictionaryCity;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Repository
public class CityRepository {
    private final JdbcTemplate jdbcTemplate;

    public CityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DictionaryCity> getAllCities() {
        String sqlCommand = "SELECT * FROM dictionarycity;";
        return jdbcTemplate.query(sqlCommand, new RowMapper<DictionaryCity>(){
            @Override
            public DictionaryCity mapRow(ResultSet rs, int rownumber) throws SQLException {
                DictionaryCity c = new DictionaryCity();
                c.setDictionaryCityId(rs.getInt(1));
                c.setDictionaryCityName(rs.getString(2));
                c.setDictionaryDistrictId(rs.getInt(3));
                return c;
            }
        });
    }

    public DictionaryCity addCity(DictionaryCity city)   {
        String sql = "INSERT INTO dictionarycity VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, city.getDictionaryCityName(), city.getDictionaryDistrictId());
        return city;
    }

    public DictionaryCity getCityById(int id) {
        String sqlCommand = "SELECT * FROM dictionarycity WHERE DictionaryCityId = ?";
        try {

        DictionaryCity city = jdbcTemplate.queryForObject(sqlCommand, new RowMapper<DictionaryCity>() {
            @Override
            public DictionaryCity mapRow(ResultSet rs, int i) throws SQLException {
                DictionaryCity c = new DictionaryCity();
                c.setDictionaryCityId(rs.getInt(1));
                c.setDictionaryCityName(rs.getString(2));
                c.setDictionaryDistrictId(rs.getInt(3));
                return c;
            }
        }, id);
        return city;
        }
        catch (Exception e) {
            return null;
        }
    }

    public void updateCity(DictionaryCity city)   {
        String sqlCommand = "UPDATE dictionarycity SET " +
                                "DictionaryCityName = ?, " +
                                "DictionaryDistrictId = ? " +
                        "WHERE DictionaryCityId = ?";
        jdbcTemplate.update(sqlCommand, city.getDictionaryCityName(), city.getDictionaryDistrictId(), city.getDictionaryCityId());
    }

    public void deleteCity(DictionaryCity city) {
        String sqlCommand = "DELETE FROM dictionarycity " +
                "WHERE DictionaryCityId = ?";
        jdbcTemplate.update(sqlCommand, city.getDictionaryCityId());
    }

    public List<DictionaryCity> getCitiesByDistrictId(int id) {
        String sqlCommand = "SELECT * FROM dictionarycity WHERE DictionaryDistrictId = ?;";
        return jdbcTemplate.query(sqlCommand, new RowMapper<DictionaryCity>(){
            @Override
            public DictionaryCity mapRow(ResultSet rs, int rownumber) throws SQLException {
                DictionaryCity c = new DictionaryCity();
                c.setDictionaryCityId(rs.getInt(1));
                c.setDictionaryCityName(rs.getString(2));
                c.setDictionaryDistrictId(rs.getInt(3));
                return c;
            }
        }, id);
    }
}