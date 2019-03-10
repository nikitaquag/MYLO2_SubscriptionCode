package com.mindyourlovedone.healthcare.model;

import java.io.Serializable;

/**
 * Created by welcome on 9/22/2017.
 */

public class History implements Serializable {
    String Other = "--";
    int userId;
    int id;
    String name = "--";
    String date = "--";
    String doctor = "--";
    String done = "--";

    public String getOther() {
        if(Other.isEmpty()){
            return "--";
        }
        return Other;
    }

    public void setOther(String other) {
        Other = other;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        if(name.isEmpty()){
            return "--";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        if(date.isEmpty()){
            return "--";
        }
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDoctor() {
        if(doctor.isEmpty()){
            return "--";
        }
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDone() {
        if(done.isEmpty()){
            return "--";
        }
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }
}
