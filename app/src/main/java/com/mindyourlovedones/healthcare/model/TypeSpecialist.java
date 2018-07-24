package com.mindyourlovedones.healthcare.model;

/**
 * Created by Niki on 23-07-2018.
 */

public class TypeSpecialist {

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getDiff() {
        return Diff;
    }

    public void setDiff(int diff) {
        Diff = diff;
    }

    String Type="";
    int Diff=0;

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    String hint="";

}
