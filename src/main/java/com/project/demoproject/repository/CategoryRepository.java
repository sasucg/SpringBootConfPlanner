package com.project.demoproject.repository;

import com.project.demoproject.entities.DictionaryCity;
import com.project.demoproject.entities.DictionaryConferenceCategory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public CategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DictionaryConferenceCategory> getAllCategories() {
        String sqlCommand = "SELECT * FROM dictionaryconferencecategory;";
        return jdbcTemplate.query(sqlCommand, new RowMapper<DictionaryConferenceCategory>(){
            @Override
            public DictionaryConferenceCategory mapRow(ResultSet rs, int rownumber) throws SQLException {
                DictionaryConferenceCategory c = new DictionaryConferenceCategory();
                c.setDictionaryConferenceCategoryId(rs.getInt(1));
                c.setDictionaryConferenceCategoryName(rs.getString(2));
                return c;
            }
        });
    }

    public void addCategory(DictionaryConferenceCategory category) {
        String sql = "INSERT INTO dictionaryconferencecategory VALUES (NULL, ?)";
        jdbcTemplate.update(sql, category.getDictionaryConferenceCategoryName());
    }

    public void updateCategory(DictionaryConferenceCategory category) {
        String sqlCommand = "UPDATE dictionaryconferencecategory SET " +
                "DictionaryConferenceCategoryName = ?" +
                "WHERE DictionaryConferenceCategoryId = ?";
        jdbcTemplate.update(sqlCommand, category.getDictionaryConferenceCategoryName(), category.getDictionaryConferenceCategoryId());
    }

    public void deleteCategory(DictionaryConferenceCategory category) {
        String sqlCommand = "DELETE FROM dictionaryconferencecategory " +
                "WHERE DictionaryConferenceCategoryId = ?";
        jdbcTemplate.update(sqlCommand, category.getDictionaryConferenceCategoryId());
    }

    public DictionaryConferenceCategory getCategoryById(int id) {
        String sqlCommand = "SELECT * FROM dictionaryconferencecategory WHERE DictionaryConferenceCategoryId = ?";
        DictionaryConferenceCategory category = jdbcTemplate.queryForObject(sqlCommand, new RowMapper<DictionaryConferenceCategory>() {
            @Override
            public DictionaryConferenceCategory mapRow(ResultSet rs, int rownumber) throws SQLException {
                DictionaryConferenceCategory c = new DictionaryConferenceCategory();
                c.setDictionaryConferenceCategoryId(rs.getInt(1));
                c.setDictionaryConferenceCategoryName(rs.getString(2));
                return c;
            }
        }, id);
        return category;
    }
}
