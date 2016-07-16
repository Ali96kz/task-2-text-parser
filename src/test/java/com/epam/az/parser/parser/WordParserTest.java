package com.epam.az.parser.parser;

import com.epam.az.parser.entity.Symbol;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WordParserTest {

    WordParser wordParser = new WordParser();

    @Test
    public void basicTest(){
        List<Symbol> symbols = wordParser.parse("ssaassggss".toCharArray());
        for (Symbol symbol : symbols) {
            if(symbol.getValue() == 's')
                assertEquals("Incorrect symbol count", 6, symbol.getCount());

            else if (symbol.getValue() == 'a')
                assertEquals("Incorrect symbol count", 2, symbol.getCount());

            else if (symbol.getValue() == 'g')
                assertEquals("Incorrect symbol count", 2, symbol.getCount());
        }
    }

    @Test
    public void testListSize(){
        char[] c = "thisaqret".toCharArray();

        List<Symbol> symbols =  wordParser.parse(c);
        assertEquals("Incorrect list size",symbols.size(), 8);
    }
    @Test
    public void oneChar(){
        char[] c  = "ssssss".toCharArray();

        List<Symbol> symbols =  wordParser.parse(c);
        for (Symbol symbol : symbols) {
            assertEquals("Parse is not right", 6, symbol.getCount());
        }

    }
    @Test
    public void emptyArray(){
        List<Symbol> symbols =  wordParser.parse("".toCharArray());
        assertEquals("Incorrect list size", 0, symbols.size());
    }
}