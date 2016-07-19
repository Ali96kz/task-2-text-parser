package com.epam.az.entity;

import java.util.ArrayList;
import java.util.List;

public class Word {
   List<WordChar> wordChars = new ArrayList<WordChar>();

    public List<WordChar> getWordChars() {
        return wordChars;
    }

    public void setWordChars(List<WordChar> wordChars) {
        this.wordChars = wordChars;
    }
}
