package edu.stlcc.jasonmayer.javaclass.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
    Customer testObject = new Customer();

    @Test
    public void getDisplayText() throws Exception {
        testObject.setCustomerNumber("ABC123");
        testObject.setFirstName("Joe");
        testObject.setLastName("Smith");
        testObject.setEmailAddress("joe.smith@example.com");

        String expected = "Name: Joe Smith\n" +
                "Email: joe.smith@example.com\n" +
                "Customer number: ABC123";
        assertEquals(expected, testObject.getDisplayText());
    }
}