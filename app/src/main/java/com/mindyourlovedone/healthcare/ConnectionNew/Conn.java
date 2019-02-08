package com.mindyourlovedone.healthcare.ConnectionNew;

public class Conn {
    int SelfProfile, SelfProfFolder;
    String SelfName = "";

    public int getSelfProfile() {
        return SelfProfile;
    }

    public void setSelfProfile(int selfProfile) {
        SelfProfile = selfProfile;
    }

    public int getSelfProfFolder() {
        return SelfProfFolder;
    }

    public void setSelfProfFolder(int selfProfFolder) {
        SelfProfFolder = selfProfFolder;
    }

    public String getSelfName() {
        return SelfName;
    }

    public void setSelfName(String selfName) {
        SelfName = selfName;
    }

    public String getSelf() {
        return Self;
    }

    public void setSelf(String self) {
        Self = self;
    }

    String Self = "";
}
