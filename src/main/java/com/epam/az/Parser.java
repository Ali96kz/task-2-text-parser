package com.epam.az;

import com.epam.az.entity.Paragraph;
import com.epam.az.entity.Sentence;
import com.epam.az.entity.Text;
import com.epam.az.entity.Word;


public class Parser {

    public Text parseText(String source){
        Text result = new Text();
        String[] strings =  source.split("(?<=\\n)");
        for (String string : strings) {
            Paragraph paragraph = parseParagraph(string);
            result.addParagraph(paragraph);
        }
        return  result;
    }

    public Paragraph parseParagraph(String source){
        Paragraph result = new Paragraph();
        String[] strings = source.split("(?<=[.!?]\\s)");
        for (String string : strings) {
            Sentence sentence = parseSentence(string);
            result.add(sentence);
        }

        return result;
    }

    public Sentence parseSentence(String source){
        Sentence result = new Sentence();
        String [] strings = source.split("(?<=\\s)");
        for (String string : strings) {
            Word word = parseWord(string);
            result.add(word);
        }
        return result;
    }

    public Word parseWord(String source){
        Word result = new Word();


        return result;
    }

}
