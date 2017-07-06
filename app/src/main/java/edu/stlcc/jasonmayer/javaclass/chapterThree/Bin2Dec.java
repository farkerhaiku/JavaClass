
package edu.stlcc.jasonmayer.javaclass.chapterThree;

public class Bin2Dec extends Bin2Num {
    public static final String VALUE_DESC = "Binary";
    public static final String RESULT_DESC = "Decimal";
    public static final String emsg = "Illegal value binary: must be only zeros and ones";

    public Bin2Dec(String value) {
        super(value);
        convert(value);
    }
}
