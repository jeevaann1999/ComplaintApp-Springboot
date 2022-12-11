package com.nest.complaintappbackend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "complaints")
public class Complaints {

    @Id
    @GeneratedValue
    private int id;
    private int userID;
    private String complaints;

    public Complaints() {
    }

    public Complaints(int id, int userID, String complaints) {
        this.id = id;
        this.userID = userID;
        this.complaints = complaints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }
}
