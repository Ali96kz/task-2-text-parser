package com.epam.az.text.parser.parser;

import com.epam.az.text.parser.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericRegExParser implements Parser {
    private Map<Class<? extends TextComponent>, String> regEx = new HashMap<Class<? extends TextComponent>, String>();
    private Map<Class<? extends TextComponent>, Class<? extends TextComponent>> clazzes = new HashMap<Class<? extends TextComponent>, Class<? extends TextComponent>>();

    {
        clazzes.put(Text.class, Paragraph.class);
        clazzes.put(Paragraph.class, Sentence.class);
        clazzes.put(Sentence.class, SentencePart.class);

        regEx.put(Text.class, "(?<=\\n)");
        regEx.put(Paragraph.class, "(?<=[.!?]\\s)");
        //TODO Regex incorrect split sentences
        regEx.put(Sentence.class, "(?<=\\w)(?=\\W) | (?<=\\W) (?=\\w) | (?<=\\W)(?=\\W)");
    }

    public GenericRegExParser() {
    }

    public <T extends AbstractComposite> T parse(Class<T> compositeClass, String sourceString) throws IllegalAccessException, InstantiationException {
        String[] values = sourceString.split(regEx.get(compositeClass));
        T result = compositeClass.newInstance();

        if (clazzes.get(compositeClass) == SentencePart.class) {
            for (String value : values) {
                if (value.matches("\\W")) {
                    result.add((TextComponent) punctuationParse(value));
                } else {
                    result.add(parseWord(value));
                }
            }
        } else {
            Class<T> clazz = (Class<T>) clazzes.get(compositeClass);
            for (String value : values) {
                T item = parse(clazz, value);
                result.add(item);
            }
        }

        return result;
    }

    private Word parseWord(String source) {
        Word word = new Word();
        for (int i = 0; i < source.length(); i++) {
            WordChar wordChar = (WordChar) Symbol.valueOf(source.charAt(i), WordChar.class);
            word.add(wordChar);
        }
        return word;
    }

    private List<SentencePart> punctuationParse(String source) {
        List<SentencePart> punctations = new ArrayList<>();
        for (int i = 0; i < source.length(); i++) {
            punctations.add((SentencePart) Symbol.valueOf(source.charAt(i), PunctuationChar.class));
        }
        return punctations;
    }
}