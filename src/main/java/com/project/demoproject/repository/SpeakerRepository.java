package com.project.demoproject.repository;

import com.project.demoproject.DTOs.ConferenceModel;
import com.project.demoproject.entities.Conference;
import com.project.demoproject.entities.DictionarySpeaker;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class SpeakerRepository {
    private final JdbcTemplate jdbcTemplate;

    public SpeakerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<DictionarySpeaker> getAllSpeakers() {
        String sqlCommand = "SELECT * FROM dictionaryspeaker;";
        return jdbcTemplate.query(sqlCommand, new RowMapper<DictionarySpeaker>(){
            @Override
            public DictionarySpeaker mapRow(ResultSet rs, int rownumber) throws SQLException {
                DictionarySpeaker d = new DictionarySpeaker();
                d.setDictionarySpeakerId(rs.getInt(1));
                d.setDictionarySpeakerName(rs.getString(2));
                d.setDictionarySpeakerRating(rs.getInt(3));
                d.setDictionarySpeakerImage(rs.getString(4));
                return d;
            }
        });
    }

    public void addSpeaker(DictionarySpeaker speaker)   {
        String sql = "INSERT INTO dictionaryspeaker VALUES (NULL, ?, ?, ?)";
        jdbcTemplate.update(sql, speaker.getDictionarySpeakerName(), speaker.getDictionarySpeakerRating(), speaker.getDictionarySpeakerImage());
    }

    public void addConferenceXSpeaker(Conference conference) {
        String sql = "INSERT INTO conferencexspeaker VALUES (?, ?)";
        jdbcTemplate.update(sql, conference.getConferenceId(), conference.getSpeakerId());
    }

    public Optional<DictionarySpeaker> getSpeakerById(int id) {
        String sqlCommand = "SELECT * FROM dictionaryspeaker WHERE DictionarySpeakerId = ?";
        try {
            DictionarySpeaker speaker = jdbcTemplate.queryForObject(sqlCommand, new RowMapper<DictionarySpeaker>() {
                @Override
                public DictionarySpeaker mapRow(ResultSet rs, int i) throws SQLException {
                    DictionarySpeaker d = new DictionarySpeaker();
                    d.setDictionarySpeakerId(rs.getInt(1));
                    d.setDictionarySpeakerName(rs.getString(2));
                    d.setDictionarySpeakerRating(rs.getInt(3));
                    d.setDictionarySpeakerImage(rs.getString(4));
                    return d;
                }
            }, id);
            return Optional.of(speaker);

        }   catch (EmptyResultDataAccessException e)    {
            return Optional.empty();
        }
    }

    public void updateSpeaker(DictionarySpeaker speaker)   {
        String sqlCommand = "UPDATE dictionaryspeaker SET " +
                "DictionarySpeakerName = ?, " +
                "DictionarySpeakerRating = ?, " +
                "DictionarySpeakerImage = ? " +
                "WHERE DictionarySpeakerId = ?";
        jdbcTemplate.update(sqlCommand, speaker.getDictionarySpeakerName(), speaker.getDictionarySpeakerRating(), speaker.getDictionarySpeakerImage(), speaker.getDictionarySpeakerId());
    }

    public void deleteSpeaker(DictionarySpeaker speaker) {
        String sqlCommand = "DELETE FROM dictionaryspeaker " +
                "WHERE DictionarySpeakerId = ?";
        jdbcTemplate.update(sqlCommand, speaker.getDictionarySpeakerId());
    }

    public List<DictionarySpeaker> getSpeakerByName(String name) {
        String sqlCommand = "SELECT * FROM dictionaryspeaker WHERE DictionarySpeakerName LIKE '" + name + "%'";
        return jdbcTemplate.query(sqlCommand, new RowMapper<DictionarySpeaker>() {
            @Override
            public DictionarySpeaker mapRow(ResultSet rs, int i) throws SQLException {
                DictionarySpeaker d = new DictionarySpeaker();
                d.setDictionarySpeakerId(rs.getInt(1));
                d.setDictionarySpeakerName(rs.getString(2));
                d.setDictionarySpeakerRating(rs.getInt(3));
                d.setDictionarySpeakerImage(rs.getString(4));
                return d;
            }
        });
    }

    public DictionarySpeaker getSpeakerByConferenceId(int id) {
        String sqlCommandId = "SELECT DictionarySpeakerId FROM conferencexspeaker WHERE ConferenceId = ?";
        int speakerId = jdbcTemplate.queryForObject(sqlCommandId, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt(1);
                return id;
            }
        }, id);
        String sqlCommand = "SELECT * FROM dictionaryspeaker WHERE DictionarySpeakerId = ?";
        DictionarySpeaker speaker = jdbcTemplate.queryForObject(sqlCommand, new RowMapper<DictionarySpeaker>() {
            @Override
            public DictionarySpeaker mapRow(ResultSet rs, int i) throws SQLException {
                DictionarySpeaker d = new DictionarySpeaker();
                d.setDictionarySpeakerId(rs.getInt(1));
                d.setDictionarySpeakerName(rs.getString(2));
                d.setDictionarySpeakerRating(rs.getInt(3));
                d.setDictionarySpeakerImage(rs.getString(4));
                return d;
            }
        }, speakerId);
        return speaker;
    }
}
