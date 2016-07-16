package com.epam.az.parser.parser;

import com.epam.az.parser.entity.Symbol;

import java.util.ArrayList;
import java.util.List;

public class WordParser {

    public List<Symbol> parse(char word[]) {
        List<Symbol> symbols = new ArrayList<Symbol>();

        Symbol symbol = new Symbol();
        for (int i = 0; i < word.length; i++) {
            if(word[i] != ' ') {
                for (int j = i ; j < word.length; j++) {
                    if (word[i] == word[j] ) {
                        symbol.setValue(word[j]);
                        symbol.addCount();
                        word[j] = ' ';
                    }
                }
            }

            if(symbol.getCount() != 0)
                symbols.add(symbol);
        }

        return symbols;
    }
}
