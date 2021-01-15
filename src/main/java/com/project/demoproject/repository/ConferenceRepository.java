package com.project.demoproject.repository;

import com.project.demoproject.DTOs.ConferenceModel;
import com.project.demoproject.DTOs.LocationModel;
import com.project.demoproject.entities.Conference;
import com.project.demoproject.entities.DictionaryConferenceCategory;
import com.project.demoproject.entities.DictionarySpeaker;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConferenceRepository {
    private final JdbcTemplate jdbcTemplate;
    private final CategoryRepository categoryRepository;
    private final LocationRepository locationRepository;
    private final SpeakerRepository speakerRepository;

    public ConferenceRepository(JdbcTemplate jdbcTemplate, CategoryRepository categoryRepository, LocationRepository locationRepository, SpeakerRepository speakerRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.categoryRepository = categoryRepository;
        this.locationRepository = locationRepository;
        this.speakerRepository = speakerRepository;
    }

    public List<ConferenceModel> getAllConferences() {
        String sqlCommand = "SELECT * FROM conference;";
        return jdbcTemplate.query(sqlCommand, new RowMapper<ConferenceModel>(){
            @Override
            public ConferenceModel mapRow(ResultSet rs, int rownumber) throws SQLException {
                ConferenceModel c = new ConferenceModel();
                c.setConferenceId(rs.getInt(1));
                c.setConferenceName(rs.getString(2));
                c.setStartDate(rs.getDate(3));
                c.setEndDate(rs.getDate(4));
                c.setOrganiserEmail(rs.getString(5));

                LocationModel location = locationRepository.getLocationById(rs.getInt(6));
                c.setLocation(location.getLocationAddress());
                c.setCity(location.getCityName());
                c.setDistrict(location.getDistrictName());

                DictionaryConferenceCategory category = categoryRepository.getCategoryById(rs.getInt(7));
                c.setCategory(category.getDictionaryConferenceCategoryName());

                DictionarySpeaker speaker = speakerRepository.getSpeakerByConferenceId(rs.getInt(1));
                c.setSpeaker(speaker.getDictionarySpeakerName());
                return c;
            }
        });
    }

    public void addConference(Conference conference) {
        String sql = "INSERT INTO conference VALUES (NULL, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, conference.getConferenceName(), conference.getStartDate(), conference.getEndDate(), conference.getOrganiserEmail(), conference.getLocationId(), conference.getDictionaryConferenceCategoryId());
        speakerRepository.addConferenceXSpeaker(conference);
    }

    public void updateConference(Conference conference) {
        String sqlCommand = "UPDATE conference SET " +
                "ConferenceName = ?, " +
                "StartDate = ?, " +
                "EndDate = ?, " +
                "OrganiserEmail = ?, " +
                "LocationId = ?, " +
                "DictionaryConferenceCategoryId = ? " +
                "WHERE ConferenceId = ?";
        jdbcTemplate.update(sqlCommand, conference.getConferenceName(),
                conference.getStartDate(),
                conference.getEndDate(),
                conference.getOrganiserEmail(),
                conference.getLocationId(),
                conference.getDictionaryConferenceCategoryId(),
                conference.getDictionaryConferenceCategoryId());
    }

    public void deleteConference(Conference conference) {
        String sqlCommand = "DELETE FROM conference where ConferenceId = ?";
        jdbcTemplate.update(sqlCommand, conference.getConferenceId());
        deleteConferenceXSpeaker(conference);
    }

    private void deleteConferenceXSpeaker(Conference conference) {
        String sqlCommand = "DELETE FROM conferencexspeaker where ConferenceId = ?";
        jdbcTemplate.update(sqlCommand, conference.getConferenceId());
    }

    public List<ConferenceModel> getConferenceByOrganiserEmail(String email) {
        String sqlCommand = "SELECT * FROM conference WHERE OrganiserEmail LIKE '" + email + "%'";
        return jdbcTemplate.query(sqlCommand, new RowMapper<ConferenceModel>() {
            @Override
            public ConferenceModel mapRow(ResultSet rs, int i) throws SQLException {
                ConferenceModel d = new ConferenceModel();
                d.setConferenceId(rs.getInt(1));
                d.setConferenceName(rs.getString(2));
                d.setStartDate(rs.getDate(3));
                d.setEndDate(rs.getDate(4));
                d.setOrganiserEmail(rs.getString(5));

                LocationModel location = locationRepository.getLocationById(rs.getInt(6));
                d.setLocation(location.getLocationAddress());
                d.setCity(location.getCityName());
                d.setDistrict(location.getDistrictName());


                DictionaryConferenceCategory category = categoryRepository.getCategoryById(rs.getInt(7));
                d.setCategory(category.getDictionaryConferenceCategoryName());

                DictionarySpeaker speaker = speakerRepository.getSpeakerByConferenceId(rs.getInt(1));
                d.setSpeaker(speaker.getDictionarySpeakerName());
                return d;
            }
        });
    }
}
