package com.mindyourlovedone.healthcare.model;

import java.io.Serializable;

/**
 * Created by welcome on 9/22/2017.
 */

public class Pet implements Serializable {
    int userId;
    int id;
    String name = "";
    String color = "";
    String breed = "";
    String bdate = "";
    String notes = "";
    String veterian = "";
    String chip = "";
    String guard = "";

    public String getVeterian_add() {
        return veterian_add;
    }

    public void setVeterian_add(String veterian_add) {
        this.veterian_add = veterian_add;
    }

    public String getVeterian_ph() {
        return veterian_ph;
    }

    public void setVeterian_ph(String veterian_ph) {
        this.veterian_ph = veterian_ph;
    }

    public String getCare_add() {
        return care_add;
    }

    public void setCare_add(String care_add) {
        this.care_add = care_add;
    }

    public String getCare_ph() {
        return care_ph;
    }

    public void setCare_ph(String care_ph) {
        this.care_ph = care_ph;
    }

    String veterian_add="";
    String veterian_ph="";
    String care_add="";
    String care_ph="";

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

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getVeterian() {
        return veterian;
    }

    public void setVeterian(String veterian) {
        this.veterian = veterian;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getGuard() {
        return guard;
    }

    public void setGuard(String guard) {
        this.guard = guard;
    }
}
