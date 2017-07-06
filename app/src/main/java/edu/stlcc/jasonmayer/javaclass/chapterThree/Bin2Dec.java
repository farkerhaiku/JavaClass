
package edu.stlcc.jasonmayer.javaclass.chapterThree;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Bin2Dec extends Bin2Num {
    public static final String VALUE_DESC = "Binary";
    public static final String RESULT_DESC = "Decimal";
    public static final String emsg = "Illegal value binary: must be only zeros and ones";

    public Bin2Dec() {

    }

    public Bin2Dec(String value) {
        setInput(value);
        convert(value);
    }

    private boolean isValid(String v) {
        try {
            int i = Integer.parseInt(v, 2);
            Log.e("TAG", "isValid: " + i + "|" + v);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
