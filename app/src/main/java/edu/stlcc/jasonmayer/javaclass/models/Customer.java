package edu.stlcc.jasonmayer.javaclass.models;

import java.util.Locale;

public class Customer extends Person {

    private String customerNumber;

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public String getDisplayText() {
        return String.format(Locale.getDefault(), toString() + "\nCustomer number: %s", customerNumber);
    }
}
