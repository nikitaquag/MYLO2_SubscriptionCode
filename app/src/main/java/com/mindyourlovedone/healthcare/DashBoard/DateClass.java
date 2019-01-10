package com.mindyourlovedone.healthcare.DashBoard;

import java.io.Serializable;

/**
 * Created by welcome on 10/28/2017.
 */

public class DateClass implements Serializable {
    int unique;
    int preid;
    int id;
    int userid;
    String Date = "";

    public int getUnique() {
        return unique;
    }

    public void setUnique(int unique) {
        this.unique = unique;
    }

    public int getPreid() {
        return preid;
    }

    public void setPreid(int preid) {
        this.preid = preid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
