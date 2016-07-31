package com.epam.az.text.parser.parser;

import com.epam.az.text.parser.entity.*;

public class SimpleRegExParser implements Parser {
    public Text parseText(String source) {
        Text result = new Text();
        String[] strings = source.split("(?<=\\n)");
        for (String string : strings) {
            Paragraph paragraph = parseParagraph(string);
            result.add(paragraph);
        }
        return result;
    }

    public Paragraph parseParagraph(String source) {
        Paragraph result = new Paragraph();
        String[] strings = source.split("(?<=[.!?]\\s)");
        for (String string : strings) {
            Sentence sentence = parseSentence(string);
            result.add(sentence);
        }
        return result;
    }

    public Sentence parseSentence(String source) {
        Sentence result = new Sentence();
        String[] strings = source.split("(?<=\\w)(?=\\W) | (?<=\\W) (?=\\w) | (?<=\\W)(?=\\W)");
        for (String string : strings) {
            Word word = parseWord(string);
            result.add(word);
        }
        return result;
    }

    public Word parseWord(String source) {

        Word result = new Word();
        Symbol wordChar;
        for (int i = 0; i < source.length(); i++) {
            wordChar = Symbol.valueOf(source.charAt(i), WordChar.class);
            result.add(wordChar);
        }
        return result;
    }


    public <T extends AbstractComposite> T parse(Class<T> e, String source) throws IllegalAccessException, InstantiationException {
        Text text = parseText(source);
        return (T) text;
    }
}
