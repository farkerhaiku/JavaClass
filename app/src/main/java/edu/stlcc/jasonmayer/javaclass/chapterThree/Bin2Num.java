package edu.stlcc.jasonmayer.javaclass.chapterThree;

import java.util.ArrayList;
import java.util.List;

public class Bin2Num implements Conversion {
    private String result;
    private List<String> resultsteps = new ArrayList<>();
    private String emsg;
    private String input;


    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    protected void convert(String v) {
        int r = 0;
        String reverse = new StringBuilder(v).reverse().toString();
        resultsteps = new ArrayList<>();
        for (int i = 0; i < reverse.length(); i++) {
            if (reverse.charAt(i) == '1') {
                int p = (int) Math.pow(getPower(), i);
                r += p;
                resultsteps.add("There is a(n) " + p + " in the number (" + getPower() + "^" + i + ")");
            }
        }
        this.result = String.valueOf(r);
    }

    protected int getPower() {
        return 2;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public String getResult() {
        return String.valueOf(Integer.parseInt(getInput(), getPower()));
    }

    @Override
    public boolean isValid() {
        try {
            Integer.parseInt(getInput(), getPower());

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
