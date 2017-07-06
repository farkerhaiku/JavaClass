package edu.stlcc.jasonmayer.javaclass.chapterThree;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Bin2DecTest {

    Bin2Dec testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new Bin2Dec("1101");
    }

    @Test
    public void testIsValidWhenInputIsValid() throws Exception {
        assertTrue(testObject.isValid());
    }

    @Test
    public void testIsValidReturnsFalseWhenInputIsNotValid() throws Exception {
        testObject = new Bin2Dec("1121");
        assertFalse(testObject.isValid());
    }

    @Test
    public void testGetResult() throws Exception {
        String result = testObject.getResult();
        assertEquals("13", result);
    }

    @Test
    public void testGetProcessLogOmitsZeros() throws Exception {
        List<String> processLog = testObject.getProcessLog();
        assertEquals(3, processLog.size());
    }

    @Test
    public void testGetProcessLog() throws Exception {
        List<String> processLog = testObject.getProcessLog();
        assertEquals("There is a(n) 1 in the number (2^0)", processLog.get(0));
        assertEquals("There is a(n) 4 in the number (2^2)", processLog.get(1));
        assertEquals("There is a(n) 8 in the number (2^3)", processLog.get(2));
    }
}