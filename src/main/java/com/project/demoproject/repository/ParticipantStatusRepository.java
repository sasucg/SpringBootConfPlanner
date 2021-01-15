package com.project.demoproject.repository;

import com.project.demoproject.entities.DictionaryParticipantStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class ParticipantStatusRepository {
    private final JdbcTemplate jdbcTemplate;

    public ParticipantStatusRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<DictionaryParticipantStatus> getAllParticipantStatuses() {
        String sqlCommand = "SELECT * FROM dictionaryparticipantstatus;";
        return jdbcTemplate.query(sqlCommand, new RowMapper<DictionaryParticipantStatus>(){
            @Override
            public DictionaryParticipantStatus mapRow(ResultSet rs, int rownumber) throws SQLException {
                DictionaryParticipantStatus d = new DictionaryParticipantStatus();
                d.setDictionaryParticipantStatusId(rs.getInt(1));
                d.setDictionaryParticipantStatusName(rs.getString(2));
                return d;
            }
        });
    }

    public boolean addParticipantStatus(DictionaryParticipantStatus status) {
        try {
            String sql = "INSERT INTO dictionaryparticipantstatus VALUES (?, ?)";
            jdbcTemplate.update(sql, status.getDictionaryParticipantStatusId(), status.getDictionaryParticipantStatusName());
            return true;
        }
        catch (Exception e) {
                return false;
        }
    }
}
