package com.epam.az.parser.parser;

import com.epam.az.parser.entity.BaseEntity;
import com.epam.az.parser.entity.Sentence;
import com.epam.az.parser.entity.Word;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser {
    public void parse(String value, Sentence sentence){
        List<Word> words = new ArrayList<Word>();

        WordParser wordParser = new WordParser();

        for (int i = 0; i < value.length(); i++) {
            if(value.charAt(i) == ' ' || value.charAt(i) == '.') {
                Word word = new Word();
                for (int j = i; j < value.length(); j++) {
                   if (value.charAt(j) != ' ') {
                       word.addSymbol(value.charAt(j));

                   }
                }
                wordParser.parse(word);
                words.add(word);
            }
        }

        sentence.setWords(words);
    }

    public List<BaseEntity> parse(List list) {
        return null;
    }
}
