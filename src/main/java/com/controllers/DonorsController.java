package com.controllers;

import com.database.DonorsDatabase;
import com.models.Donor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class DonorsController {

    private DonorsDatabase donorsDatabase;

    @Autowired
    public DonorsController(DonorsDatabase donorsDatabase) {
        this.donorsDatabase = donorsDatabase;
    }

    @PostMapping("/donors/new")
    public ResponseEntity<String> addDonor(@RequestBody Donor donor) {
            donorsDatabase.addDonor(donor);
            return new ResponseEntity<>("Donor Added", HttpStatus.OK);
    }

    @GetMapping("/donors/")
    public ResponseEntity<List<Donor>> getDonors() {
        List<Donor> donors = donorsDatabase.getDonors();
        return new ResponseEntity<>(donors, HttpStatus.OK);
    }

    @GetMapping("/donors/{donorID}")
    public ResponseEntity<Donor> getDonorByID(@PathVariable("donorID") String donorID) {
        Donor donor = donorsDatabase.getDonorByID(donorID);
        return new ResponseEntity<>(donor, HttpStatus.OK);
    }

    @DeleteMapping("/donors/{donorID}")
    public ResponseEntity<String> deleteDonorByID(@PathVariable("donorID") String donorID) {
        donorsDatabase.deleteDonorByID(donorID);
        return new ResponseEntity<>("Donor Deleted", HttpStatus.OK);
    }

    @PutMapping("/donors/{donorID}")
    public ResponseEntity<String> updateDonorByID(@RequestBody Donor donor, @PathVariable("donorID") String donorID) {
        donorsDatabase.updateDonor(donor, donorID);
        return new ResponseEntity<>("Donor Updated", HttpStatus.OK);
    }
}
