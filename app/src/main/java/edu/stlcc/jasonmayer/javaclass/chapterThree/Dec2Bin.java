
package edu.stlcc.jasonmayer.javaclass.chapterThree;

import java.util.ArrayList;
import java.util.List;

public class Dec2Bin implements Conversion {
    private final String value;
    private String result;
    private ArrayList<String> resultsteps;
    private String emsg;

    public Dec2Bin(String value) {
        this.value = value;

        emsg = "";
        try {
            long n = Long.parseLong(value);
            if (n < 0) {
                emsg = "Bad decimal value: must be positive.";
            } else {
                resultsteps = new ArrayList<>();
                this.result = "";
                convertByRecur(n);
            }
        } catch (NumberFormatException e) {
            emsg = "Illegal value: not a decimal integer";
        }
    }

    private void convertByRecur(long n) {
        int r = 0;

        r = (int) (n % 2);
        long newval = n / 2;
        resultsteps.add(n + " divided by 2 = " + newval + " w/remainder of: " + r);

        if (newval > 0) {
            convertByRecur(newval);
        }
        this.result += String.valueOf(r);
    }

    @Override
    public String getValue() {
        return value;
    }

    public String getResult() {
        return this.result;
    }

    @Override
    public boolean isValid() {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public List<String> getProcessLog() {
        return this.resultsteps;
    }
}
