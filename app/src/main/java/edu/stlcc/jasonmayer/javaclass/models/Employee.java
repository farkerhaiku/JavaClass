package edu.stlcc.jasonmayer.javaclass.models;

import java.util.Locale;

public class Employee extends Person {
    private String social;

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    @Override
    public String getDisplayText() {
        return String.format(Locale.getDefault(), toString() + "\nSocial security number: %s", social);
    }
}
