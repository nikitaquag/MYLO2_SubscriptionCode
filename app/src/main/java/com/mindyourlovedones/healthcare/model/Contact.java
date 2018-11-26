package com.mindyourlovedones.healthcare.model;

/**
 * Created by varsha on 8/28/2017.
 */

public class Contact {
    String HomePhone = "";
    String address = "";
    String workPhone = "";
    String name = "";
    String id = "";
    String email = "";
    byte[] image;
    String phone = "";

    public Contact(String name, String email, String phone, byte[] image, String address, String homePhone, String workPhone) {
        this.name = name;
        this.image = image;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.HomePhone = homePhone;
        this.workPhone = workPhone;
    }

    public Contact() {

    }

    public String getHomePhone() {
        return HomePhone;
    }

    public void setHomePhone(String homePhone) {
        HomePhone = homePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
