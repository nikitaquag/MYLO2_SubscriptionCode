package com.mindyourlovedones.healthcare.model;

import java.io.Serializable;

/**
 * Created by welcome on 9/18/2017.
 */

public class Note implements Serializable {
    int id;
    int userid;
    String txtNote = "";
    String txtDate = "";
    String txttime = "";

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

    public String getTxtNote() {
        return txtNote;
    }

    public void setTxtNote(String txtNote) {
        this.txtNote = txtNote;
    }

    public String getTxtDate() {
        return txtDate;
    }

    public void setTxtDate(String txtDate) {
        this.txtDate = txtDate;
    }

    public String getTxttime() {
        return txttime;
    }

    public void setTxttime(String txttime) {
        this.txttime = txttime;
    }
}
