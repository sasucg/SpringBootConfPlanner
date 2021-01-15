package com.project.demoproject.repository;

import com.project.demoproject.entities.DictionaryDistrict;
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
public class DistrictRepository {
    private final JdbcTemplate jdbcTemplate;

    public DistrictRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DictionaryDistrict> getAllDistricts() {
        String sqlCommand = "SELECT * FROM dictionarydistrict;";
        return jdbcTemplate.query(sqlCommand, new RowMapper<DictionaryDistrict>(){
            @Override
            public DictionaryDistrict mapRow(ResultSet rs, int rownumber) throws SQLException {
                DictionaryDistrict d = new DictionaryDistrict();
                d.setDictionaryDistrictId(rs.getInt(1));
                d.setDictionaryDistrictName(rs.getString(2));
                d.setDictionaryDistrictCode(rs.getString(3));
                return d;
            }
        });
    }

    public void addDistrict(DictionaryDistrict district)   {
        String sql = "INSERT INTO dictionarydistrict VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, district.getDictionaryDistrictName(), district.getDictionaryDistrictCode());
    }

    public DictionaryDistrict getDistrictById(int id) {
        String sqlCommand = "SELECT * FROM dictionarydistrict WHERE DictionaryDistrictId = ?";
        DictionaryDistrict district = jdbcTemplate.queryForObject(sqlCommand, new RowMapper<DictionaryDistrict>() {
            @Override
            public DictionaryDistrict mapRow(ResultSet rs, int i) throws SQLException {
                DictionaryDistrict d = new DictionaryDistrict();
                d.setDictionaryDistrictId(rs.getInt(1));
                d.setDictionaryDistrictName(rs.getString(2));
                d.setDictionaryDistrictCode(rs.getString(3));
                return d;
            }
        }, id);
        return (district);
    }

    public void updateDistrict(DictionaryDistrict district)   {
        String sqlCommand = "UPDATE dictionarydistrict SET " +
                "DictionaryDistrictName = ?, " +
                "DictionaryDistrictCode = ? " +
                "WHERE DictionaryDistrictId = ?";
        jdbcTemplate.update(sqlCommand, district.getDictionaryDistrictName(), district.getDictionaryDistrictCode(), district.getDictionaryDistrictId());
    }

    public void deleteDistrict(DictionaryDistrict district) {
        String sqlCommand = "DELETE FROM dictionarydistrict " +
                "WHERE DictionaryDistrictId = ?";
        jdbcTemplate.update(sqlCommand, district.getDictionaryDistrictId());
    }
}