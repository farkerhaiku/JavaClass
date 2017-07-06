package edu.stlcc.jasonmayer.javaclass.chapterThree;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Dec2HexTest {
    private Dec2Hex testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new Dec2Hex("13");
    }

    @Test
    public void testIsValidWhenValid() throws Exception {
        assertTrue(testObject.isValid());
    }

    @Test
    public void testIsNotValidWhenAlphaNumericEntered() throws Exception {
        testObject = new Dec2Hex("asdb");
        assertFalse(testObject.isValid());
    }

    @Test
    public void testDecToBinResult() throws Exception {
        String result = testObject.getResult();

        assertEquals("D", result);
    }

    @Test
    public void testDecToBinProcessLogReturnsRightNumberOfElements() throws Exception {
        List<String> processLog = testObject.getProcessLog();

        assertEquals(1, processLog.size());
    }

    @Test
    public void testDecToBinProcessLogValues() throws Exception {
        List<String> processLog = testObject.getProcessLog();

        assertEquals("13 divided by 16 = 0 w/remainder of: 13", processLog.get(0));
    }
}