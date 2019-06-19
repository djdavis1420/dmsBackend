package com.database;

import com.models.Donor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DonorsDatabase {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DonorsDatabase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String ADD_DONOR = "INSERT INTO donors (firstName, lastName, email) VALUES (?, ?, ?);";
    private static final String GET_DONORS = "SELECT * FROM donors;";
    private static final String GET_DONOR = "SELECT * FROM donors WHERE donorID = ?;";
    private static final String DELETE_DONOR = "DELETE FROM donors WHERE donorID = ?;";
    private static final String UPDATE_DONOR = "UPDATE donors SET firstName = ?, lastName = ?, email = ? WHERE donorID = ?;";

    public void addDonor(Donor donor) {
        Object[] params = {donor.getFirstName(), donor.getLastName(), donor.getEmail()};
        jdbcTemplate.update(ADD_DONOR, params);
    }

    public List<Donor> getDonors() {
        return jdbcTemplate.query(GET_DONORS, new BeanPropertyRowMapper<>(Donor.class));
    }

    public Donor getDonorByID(String donorID) {
        return jdbcTemplate.queryForObject(GET_DONOR, new Object[]{donorID}, new BeanPropertyRowMapper<>(Donor.class));
    }

    public void deleteDonorByID(String donorID) {
        jdbcTemplate.update(DELETE_DONOR, donorID);
    }

    public void updateDonor(Donor donor, String donorID) {
        Object[] params = {donor.getFirstName(), donor.getLastName(), donor.getEmail(), donorID};
        jdbcTemplate.update(UPDATE_DONOR, params);
    }

}
