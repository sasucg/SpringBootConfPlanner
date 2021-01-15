package com.project.demoproject.repository;

import com.project.demoproject.entities.ConferenceAttendance;
import com.project.demoproject.entities.DictionaryCity;
import com.project.demoproject.entities.DictionaryDistrict;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConferenceAttendanceRepository {
    private final JdbcTemplate jdbcTemplate;

    public ConferenceAttendanceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ConferenceAttendance> getAllConferenceAttendancesByConferenceId(int id) {
        String sqlCommand = "SELECT * FROM conferenceattendance WHERE ConferenceId = ?";
        return jdbcTemplate.query(sqlCommand, new RowMapper<ConferenceAttendance>(){
            @Override
            public ConferenceAttendance mapRow(ResultSet rs, int rownumber) throws SQLException {
                ConferenceAttendance c = new ConferenceAttendance();
                c.setConferenceId(rs.getInt(1));
                c.setParticipantEmailAddress(rs.getString(2));
                c.setDictionaryParticipantStatusId(rs.getInt(3));
                c.setParticipationCode(rs.getString(4));
                return c;
            }
        }, id);
    }

    public void addConferenceAttendance(ConferenceAttendance attendance) {
        String sql = "INSERT INTO conferenceattendance VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, attendance.getConferenceId(), attendance.getParticipantEmailAddress(), attendance.getDictionaryParticipantStatusId(), attendance.getParticipationCode());
    }

    public void updateConferenceAttendance(ConferenceAttendance attendance) {
        String sqlCommand = "UPDATE conferenceattendance SET " +
                "ParticipantEmailAddress = ?, " +
                "DictionaryParticipantStatusId = ? " +
                "ParticipationCode = ? " +
                "WHERE ConferenceId = ?";
        jdbcTemplate.update(sqlCommand, attendance.getParticipantEmailAddress(), attendance.getDictionaryParticipantStatusId(), attendance.getParticipationCode(), attendance.getConferenceId());
    }
}
