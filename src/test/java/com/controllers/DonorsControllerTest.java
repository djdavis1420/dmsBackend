package com.controllers;

import com.database.DonorsDatabase;
import com.models.Donor;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.mockito.Mockito.*;

public class DonorsControllerTest {

    private Donor donor;
    private DonorsController donorsController;
    private DonorsDatabase donorsDatabase;

    @Before
    public void setup() {
        donor = new Donor("John", "Smith", "jsmith@example.com");
        donorsDatabase = mock(DonorsDatabase.class);
        donorsController = new DonorsController(donorsDatabase);
    }

    @Test
    public void addDonor_ShouldCallDatabaseMethodToAddDonor() {
        donorsController.addDonor(donor);
        verify(donorsDatabase, times(1)).addDonor(donor);
    }

    @Test
    public void getDonors_ShouldCallDatabaseMethodToGetDonors() {
        donorsController.getDonors();
        verify(donorsDatabase, times(1)).getDonors();
    }

    @Test
    public void getDonorByID_ShouldCallDatabaseMethodToGetDonorByID() {
        String donorID = UUID.randomUUID().toString();
        donorsController.getDonorByID(donorID);
        verify(donorsDatabase, times(1)).getDonorByID(donorID);
    }

    @Test
    public void deleteDonorByID_ShouldCallDatabaseMethodToDeleteDonorByID() {
        String donorID = UUID.randomUUID().toString();
        donorsController.deleteDonorByID(donorID);
        verify(donorsDatabase, times(1)).deleteDonorByID(donorID);
    }

    @Test
    public void updateDonorByID_ShouldCallDatabaseMethodToUpdateDonorByID() {
        String donorID = UUID.randomUUID().toString();
        donorsController.updateDonorByID(donor, donorID);
        verify(donorsDatabase, times(1)).updateDonor(donor, donorID);
    }

}
