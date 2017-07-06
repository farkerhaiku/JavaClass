package edu.stlcc.jasonmayer.javaclass.chapterThree;

import java.util.ArrayList;
import java.util.List;

public class Bin2Num implements Conversion {
    private String result;
    private ArrayList<String> resultsteps;
    private String emsg;
    private String input;

    public void setResult(String result) {
        this.result = result;
    }

    public ArrayList<String> getResultsteps() {
        return resultsteps;
    }

    public void setResultsteps(ArrayList<String> resultsteps) {
        this.resultsteps = resultsteps;
    }

    public String getEmsg() {
        return emsg;
    }

    public void setEmsg(String emsg) {
        this.emsg = emsg;
    }

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
        return null;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public List<String> getProcessLog() {
        return null;
    }
}
