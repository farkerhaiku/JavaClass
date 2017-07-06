package edu.stlcc.jasonmayer.javaclass.chapterThree;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Dec2BinTest {
    private Dec2Bin testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new Dec2Bin("13");
    }

    @Test
    public void testIsValidWhenValid() throws Exception {
        assertTrue(testObject.isValid());
    }

    @Test
    public void testIsNotValidWhenAlphaNumericEntered() throws Exception {
        testObject = new Dec2Bin("asdb");
        assertFalse(testObject.isValid());
    }

    @Test
    public void testDecToBinResult() throws Exception {
        String result = testObject.getResult();

        assertEquals("1101", result);
    }

    @Test
    public void testDecToBinProcessLogReturnsRightNumberOfElements() throws Exception {
        List<String> processLog = testObject.getProcessLog();

        assertEquals(4, processLog.size());
    }

    @Test
    public void testDecToBinProcessLogValues() throws Exception {
        List<String> processLog = testObject.getProcessLog();

        assertEquals("13 divided by 2 = 6 w/remainder of: 1", processLog.get(0));
        assertEquals("6 divided by 2 = 3 w/remainder of: 0", processLog.get(1));
        assertEquals("3 divided by 2 = 1 w/remainder of: 1", processLog.get(2));
        assertEquals("1 divided by 2 = 0 w/remainder of: 1", processLog.get(3));
    }
}