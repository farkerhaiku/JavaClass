package edu.stlcc.jasonmayer.javaclass.chapterThree;

import java.util.List;

public class Dec2Hex extends Dec2Num {

    public Dec2Hex(String input) {
        super(input);
    }

    @Override
    protected int getPower() {
        return 16;
    }
}
