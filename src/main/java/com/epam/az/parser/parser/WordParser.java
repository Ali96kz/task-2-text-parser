package com.epam.az.parser.parser;

import com.epam.az.parser.entity.BaseEntity;
import com.epam.az.parser.entity.Symbol;

import java.util.ArrayList;
import java.util.List;

public class WordParser {

    public List<Symbol> parse(char word[]) {
        List<Symbol> symbols = new ArrayList<Symbol>();

        for (int i = 0; i < word.length; i++) {
            Symbol symbol = new Symbol();
            if(word[i] != ' ') {
                symbol.setValue(word[i]);
                symbol.addCount();
                for (int j = i+1 ; j < word.length; j++) {
                    if (word[i] == word[j] ) {
                        symbol.addCount();
                        word[j] = ' ';
                    }
                }
                symbols.add(symbol);
            }
        }

        return symbols;
    }

    public List<BaseEntity> parse(List list) {
        return null;
    }
}
