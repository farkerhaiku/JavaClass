package edu.stlcc.jasonmayer.javaclass.models;

import java.util.Locale;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String emailAddress;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Name: %s %s\nEmail: %s", firstName,
                lastName, emailAddress);
    }

    public abstract String getDisplayText();
}
