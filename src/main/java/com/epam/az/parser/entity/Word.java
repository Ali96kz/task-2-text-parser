package com.epam.az.parser.entity;

import java.util.ArrayList;
import java.util.List;

public class Word {
    StringBuilder value = new StringBuilder();
    private List<Symbol> symbols = new ArrayList<Symbol>();

    public Word() {
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }
    public void addSymbol(char s){
        value.append(s);
    }
}
