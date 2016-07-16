package com.epam.az.parser.parser;

import com.epam.az.parser.entity.Symbol;
import com.epam.az.parser.entity.Word;

import java.util.ArrayList;
import java.util.List;

public class WordParser {

    public void parse(Word word) {
        List<Symbol> symbols = new ArrayList<Symbol>();
        char[] item = word.getValue().toCharArray();

        for (int i = 0; i < item.length; i++) {
            Symbol symbol = new Symbol();
            if(item[i] != ' ') {
                symbol.setValue(item[i]);
                symbol.addCount();

                for (int j = i+1 ; j < item.length; j++) {
                    if (item[i] == item[j] ) {
                        symbol.addCount();
                        item[j] = ' ';
                    }
                }
                symbols.add(symbol);
            }
        }
        word.setSymbols(symbols);
    }
}
