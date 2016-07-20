package com.epam.az.entity;

import java.util.ArrayList;
import java.util.List;

public class Word {
    List<Symbol> wordChars = new ArrayList<Symbol>();

    public List<Symbol> getWordChars() {
        return wordChars;
    }
    public void setWordChars(List<Symbol> wordChars) {
        this.wordChars = wordChars;
    }

    public void addSymbol(Symbol symbol){
        wordChars.add(symbol);
    }
}
