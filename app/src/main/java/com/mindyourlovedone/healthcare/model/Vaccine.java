package com.mindyourlovedone.healthcare.model;

import java.io.Serializable;

/**
 * Created by welcome on 9/22/2017.
 */

public class Vaccine implements Serializable {
    String Other = "";
    int userId;
    int id;
    String name = "";
    String date = "";

    public String getOther() {
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}