package com.epam.az;

import com.epam.az.entity.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
        String [] strings = source.split("(?<=\\w)");
        for (String string : strings) {
            Pattern pattern = Pattern.compile("\\w");
            Matcher matcher = pattern.matcher(string);
            if(matcher.matches() == true){
                Symbol wordChar = new WordChar();
                wordChar.setValue(string.charAt(0));
                result.addSymbol(wordChar);
            }
            else {
                Symbol punctuationChar = new PunctuationChar();
                punctuationChar.setValue(string.charAt(0));
                result.addSymbol(punctuationChar);
            }
        }
        return result;
    }

}
