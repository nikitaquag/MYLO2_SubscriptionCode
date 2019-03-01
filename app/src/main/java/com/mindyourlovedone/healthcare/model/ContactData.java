package com.mindyourlovedone.healthcare.model;

/**
 * Created by varsha on 8/28/2017.
 */

public class ContactData {
   int id;
   int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIdFromTable() {
        return idFromTable;
    }

    public void setIdFromTable(int idFromTable) {
        this.idFromTable = idFromTable;
    }

    public String getFromtable() {
        return fromtable;
    }

    public void setFromtable(String fromtable) {
        this.fromtable = fromtable;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    int idFromTable;
    String fromtable="";
    String contactType="";
    String value="";
    String userEmail="";


}
