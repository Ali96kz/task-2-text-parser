package com.epam.az.text.parser.parser;

import com.epam.az.text.parser.entity.*;

import java.util.HashMap;
import java.util.Map;

public class GenericRegExParser implements Parser {
    private Map<Class<? extends TextComponent>, String> regEx = new HashMap<Class<? extends TextComponent>, String>();
    private Map<Class<? extends TextComponent>, Class<? extends TextComponent>> clazzes = new HashMap<Class<? extends TextComponent>, Class<? extends TextComponent>>();
    public GenericRegExParser() {
    }

    {
        clazzes.put(Text.class, Paragraph.class);
        clazzes.put(Paragraph.class, Sentence.class);
        clazzes.put(Sentence.class, SentencePart.class);

        regEx.put(Text.class, "(?<=\\n)");
        regEx.put(Paragraph.class, "(?<=[.!?]\\s)");
        //TODO Regex incorrect split sentences
        regEx.put(Sentence.class, "(?<=\\w)(?=\\W) | (?<=\\W) (?=\\w) | (?<=\\W)(?=\\W)");
    }

    public <T extends AbstractComposite> T parse(Class<T> compositeClass, String sourceString) throws IllegalAccessException, InstantiationException {
        String[] values = sourceString.split(regEx.get(compositeClass));
        T result = compositeClass.newInstance();

        if (clazzes.get(compositeClass) == SentencePart.class) {
            for (String value : values) {
                if (value.matches("\\W")) {
                    result.add(punctuationParse(new PunctuationChar(), value));
                } else {
                    result.add(parseWord(new Word(), value));
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

    private Word parseWord(Word symbol, String source) {
        for (int i = 0; i < source.length(); i++) {
            WordChar wordChar = new WordChar();
            wordChar.setValue(source.charAt(i));
            symbol.add(wordChar);
        }
        return symbol;
    }

    private PunctuationChar punctuationParse(PunctuationChar symbol, String source) {
        for (int i = 0; i < source.length(); i++) {
            symbol.setValue(source.charAt(i));
        }
        return symbol;
    }
}