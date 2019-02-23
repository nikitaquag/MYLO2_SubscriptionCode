package com.mindyourlovedone.healthcare.model;

import java.io.Serializable;

/**
 * Created by varsha on 9/8/2017.
 */

public class Phone implements Serializable {
    String type = "";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    String phone = "";

}
