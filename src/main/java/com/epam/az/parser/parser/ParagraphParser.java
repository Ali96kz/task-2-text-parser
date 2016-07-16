package com.epam.az.parser.parser;

import com.epam.az.parser.entity.BaseEntity;
import com.epam.az.parser.entity.Sentence;

import java.util.ArrayList;
import java.util.List;

public class ParagraphParser {
    public List<Sentence> parse(String string){
        List<Sentence> sentences = new ArrayList<Sentence>();

        for (int i = 0; i < string.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            Sentence sentence = new Sentence();

            if(string.charAt(i) == '.') {
                for (int j = i-1; j >= 0; j--) {
                    stringBuilder.append(string.charAt(j));
                    if(string.charAt(j) == '.' || j == 0){
                        sentence.setValue(stringBuilder.toString());
                        sentences.add(sentence);
                        break;
                    }

                }
            }

        }

        return sentences;
    }
}
