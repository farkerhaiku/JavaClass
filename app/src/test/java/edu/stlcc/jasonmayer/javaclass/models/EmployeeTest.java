package edu.stlcc.jasonmayer.javaclass.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    Employee testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new Employee();
    }

    @Test
    public void getDisplayText() throws Exception {
        String expected = "Name: Anne Prince\n" +
                "Email: anne@murach.com\n" +
                "Social security number: 111-11-1111";

        testObject.setEmailAddress("anne@murach.com");
        testObject.setFirstName("Anne");
        testObject.setLastName("Prince");
        testObject.setSocial("111-11-1111");
        assertEquals(expected, testObject.getDisplayText());
    }
}