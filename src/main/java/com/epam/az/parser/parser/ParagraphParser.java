package com.epam.az.parser.parser;

import com.epam.az.parser.entity.BaseEntity;
import com.epam.az.parser.entity.Paragraph;
import com.epam.az.parser.entity.Sentence;

import java.util.ArrayList;
import java.util.List;

public class ParagraphParser {

    public void parse(String string, Paragraph paragraph){
        List<Sentence> sentences = new ArrayList<Sentence>();
        SentenceParser sentenceParser = new SentenceParser();
        for (int i = 0; i < string.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            Sentence sentence = new Sentence();

            if(string.charAt(i) == '.') {
                for (int j = i-1; j >= 0; j--) {
                    stringBuilder.append(string.charAt(j));
                    if(string.charAt(j) == '.' || j == 0){
                        sentence.setValue(stringBuilder.toString());
                        sentences.add(sentence);

                        sentenceParser.parse(sentence.getValue(), sentence);
                        break;
                    }
                }
            }
        }
        paragraph.setSentences(sentences);
    }
}
