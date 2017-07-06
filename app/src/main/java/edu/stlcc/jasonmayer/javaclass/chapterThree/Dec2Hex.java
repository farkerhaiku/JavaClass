package edu.stlcc.jasonmayer.javaclass.chapterThree;

import android.support.annotation.NonNull;

import java.util.List;

public class Dec2Hex extends Dec2Num {

    public Dec2Hex(String input) {
        super(input);
    }

    @Override
    protected int getPower() {
        return 16;
    }

    @NonNull
    protected String getStringOutput(int r) {
        return String.valueOf(Integer.toHexString(r)).toUpperCase();
    }
}
