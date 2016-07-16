package com.epam.az.parser.entity;

import java.util.ArrayList;
import java.util.List;

public class Word {
    String value;
    private List<Symbol> symbols = new ArrayList<Symbol>();

    public Word() {
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }
}
