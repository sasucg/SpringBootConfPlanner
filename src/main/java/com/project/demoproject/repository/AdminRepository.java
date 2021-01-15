package com.project.demoproject.repository;

import com.project.demoproject.entities.Admin;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class AdminRepository {
    private final JdbcTemplate jdbcTemplate;

    public AdminRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Admin> getAllAdmins() {
        String sqlCommand = "SELECT * FROM admin;";
        return jdbcTemplate.query(sqlCommand, new RowMapper<Admin>(){
            @Override
            public Admin mapRow(ResultSet rs, int rownumber) throws  SQLException    {
                Admin a = new Admin();
                a.setAdminId(rs.getInt(1));
                a.setAdminEmail(rs.getString(2));
                return a;
            }
        });
    }

    public void addAdmin(Admin admin)   {
        String sql = "INSERT INTO admin VALUES (NULL, ?)";
        jdbcTemplate.update(sql, admin.getAdminEmail());
    }
}

