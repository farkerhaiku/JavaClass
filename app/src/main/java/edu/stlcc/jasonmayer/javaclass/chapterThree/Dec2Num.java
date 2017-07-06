package edu.stlcc.jasonmayer.javaclass.chapterThree;

import java.util.ArrayList;
import java.util.List;

public class Dec2Num implements Conversion {
    private String emsg;
    private List<String> resultsteps = new ArrayList<>();
    private String result = "";
    private String value;

    public Dec2Num(String input) {
        this.value = input;

        emsg = "";
        try {
            long n = Long.parseLong(value);
            if (n < 0) {
                emsg = "Bad decimal value: must be positive.";
            } else {
                convertByRecur(n);
            }
        } catch (NumberFormatException e) {
            emsg = "Illegal value: not a decimal integer";
        }
    }

    protected int getPower() {
        return 1;
    }

    protected void convertByRecur(long n) {
        int r = 0;

        r = (int) (n % getPower());
        long newval = n / getPower();
        resultsteps.add(n + " divided by "+ getPower() + " = " + newval + " w/remainder of: " + r);

        if (newval > 0) {
            convertByRecur(newval);
        }
        this.result += String.valueOf(r);
    }


    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public boolean isValid() {
        try {
            Integer.parseInt(getValue());
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public List<String> getProcessLog() {
        return resultsteps;
    }
}
