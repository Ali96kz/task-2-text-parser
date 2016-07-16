package com.epam.az.parser.parser;

import com.epam.az.parser.entity.BaseEntity;
import com.epam.az.parser.entity.Paragraph;
import com.epam.az.parser.entity.Word;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser {
    public List<Word> parse(String sentence){
        List<Word> words = new ArrayList<Word>();
        Word word = new Word();
        for (int i = 0; i < sentence.length(); i++) {
            if(sentence.charAt(i) == ' ' || sentence.charAt(i) == '.') {
                for (int j = i; j < sentence.length(); j++) {
                   if (sentence.charAt(j) != ' ') {
                       word.addSymbol(sentence.charAt(j));
                   }
                }
                words.add(word);
            }
        }

        return words;
    }

    public List<BaseEntity> parse(List list) {
        return null;
    }
}
