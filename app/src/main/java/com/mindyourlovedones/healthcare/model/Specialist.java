package com.mindyourlovedones.healthcare.model;

import java.io.Serializable;

/**
 * Created by varsha on 8/28/2017.
 */

public class Specialist implements Serializable {
    String lastseen = "";
    String locator = "";
    String website = "";
    String photoCard;
    String officePhone = "";
    String hourPhone = "";
    String otherPhone = "";
    int isPhysician;
    String Fax;
    String network = "";
    String HospAffiliation = "";
    String note = "";
    String practiceName;
    String photo;
    int id;
    String email = "";
    String name = "";
    String otherType = "";
    String type = "";
    String address = "";
    int unique;
    int image;

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public String getPhotoCard() {
        return photoCard;
    }

    public void setPhotoCard(String photoCard) {
        this.photoCard = photoCard;
    }

    public String getLastseen() {
        return lastseen;
    }

    public void setLastseen(String lastseen) {
        this.lastseen = lastseen;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getHourPhone() {
        return hourPhone;
    }

    public void setHourPhone(String hourPhone) {
        this.hourPhone = hourPhone;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    public int getIsPhysician() {
        return isPhysician;
    }

    public void setIsPhysician(int isPhysician) {
        this.isPhysician = isPhysician;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getHospAffiliation() {
        return HospAffiliation;
    }

    public void setHospAffiliation(String hospAffiliation) {
        HospAffiliation = hospAffiliation;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPracticeName() {
        return practiceName;
    }

    public void setPracticeName(String practiceName) {
        this.practiceName = practiceName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtherType() {
        return otherType;
    }

    public void setOtherType(String otherType) {
        this.otherType = otherType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getUnique() {
        return unique;
    }

    public void setUnique(int unique) {
        this.unique = unique;
    }


}
