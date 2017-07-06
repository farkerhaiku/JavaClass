package edu.stlcc.jasonmayer.javaclass.chapterThree;

import java.util.List;

public interface Conversion {
    String getValue();
    String getResult();
    boolean isValid();
    List<String> getProcessLog();

    void setInput(String input);
}
