package com.database;

import com.Application;
import com.models.Donor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DonorsDatabaseIT {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private DonorsDatabase donorsDatabase;
    private Donor donor;

    @Before
     public void setup() {
        donor = new Donor("John", "Smith", "jsmith@example.com");
        donorsDatabase = new DonorsDatabase(jdbcTemplate);
    }

    @Test
    public void getDonors_ShouldReturnListOfAllDonors() {
        donorsDatabase.addDonor(donor);
        List<Donor> donors = donorsDatabase.getDonors();
        Donor actual = donors.stream().filter(x -> x.getLastName().equals("Smith")).findFirst().get();
        assertEquals(actual.getLastName(), "Smith");
    }

    @After
    public void deleteDonors_ShouldDeleteAllDonors() {
        jdbcTemplate.update("DELETE FROM donors;");
    }

}
