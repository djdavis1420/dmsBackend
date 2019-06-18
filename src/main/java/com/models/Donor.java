package com.models;

import java.util.UUID;

public class Donor {

    private UUID donorID;
    private String firstName;
    private String lastName;
    private String email;

    public Donor() {}

    public Donor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UUID getDonorID() {
        return donorID;
    }

    public void setDonorID(UUID donorID) {
        this.donorID = donorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
