package com.mindyourlovedone.healthcare.model;

import java.io.Serializable;

/**
 * Created by varsha on 8/28/2017.
 */

public class Insurance implements Serializable {

    String name = "";
    String phone = "";
    int image;
    int id;
    int userid;
    String fax = "";
    String photoCard;
    String agent = "";
    public String getHas_card() {
        return has_card;
    }

    public void setHas_card(String has_card) {
        this.has_card = has_card;
    }

    String has_card="";
    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }

    String agentPhone = "";

    public String getAgent_email() {
        return agent_email;
    }

    public void setAgent_email(String agent_email) {
        this.agent_email = agent_email;
    }

    String agent_email = "";
    String OtherInsurance = "";
    String note = "";
    String email = "";
    String website = "";
    String subscriber = "";
    String photo;
    String Type = "";
    String member = "";
    String group = "";

    public String getPhotoCard() {
        return photoCard;
    }

    public void setPhotoCard(String photoCard) {
        this.photoCard = photoCard;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getOtherInsurance() {
        return OtherInsurance;
    }

    public void setOtherInsurance(String otherInsurance) {
        OtherInsurance = otherInsurance;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
