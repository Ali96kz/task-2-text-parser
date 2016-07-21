package com.epam.az.text.parser.parsers;

import com.epam.az.text.parser.entity.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenericRegExParser implements Parser {
    private Map<Class<? extends Compositor>, String> regEx = new HashMap<Class<? extends Compositor>, String>();
    private Map<Class<? extends Compositor>, Class<? extends Compositor>> clazzes = new HashMap<Class<? extends Compositor>, Class<? extends Compositor>>();
    public GenericRegExParser(){
        init();
    }
    public void init(){
        clazzes.put(Text.class, Paragraph.class);
        clazzes.put(Paragraph.class, Sentence.class);
        clazzes.put(Sentence.class, SentencePart.class);
        clazzes.put(Word.class, Word.class);

        regEx.put(Text.class, "(?<=\\n)");
        regEx.put(Paragraph.class, "(?<=[.!?]\\s)");
        regEx.put(Sentence.class, "(?<=\\w)(?=\\W) | (?<=\\W) (?=\\w) | (?<=\\W)(?=\\W)");
        regEx.put(Word.class, "");
    }

    public  <T extends AbstractComposite> T parse( Class<T> compositeClass, String sourceString) throws IllegalAccessException, InstantiationException {
        String[] values = sourceString.split(regEx.get(compositeClass));
        T result = compositeClass.newInstance();

        if (clazzes.get(compositeClass) == Word.class) {
            for (int i = 0; i < sourceString.length(); i++) {
                Symbol symbol = new WordChar();
                symbol.setValue(sourceString.charAt(i));
                result.add(symbol);
            }

            return result;
        }

        else if (clazzes.get(compositeClass) == SentencePart.class) {
            for (String value : values) {
                Pattern pattern = Pattern.compile("\\W");
                Matcher matcher = pattern.matcher(value);
                if (matcher.matches()) {
                    for (int i = 0; i < sourceString.length(); i++) {
                        Symbol symbol = new PunctuationChar();
                        symbol.setValue(sourceString.charAt(i));
                        result.add(symbol);
                    }
                }
                else {
                    result.add(parse(Word.class, value));
                }
            }
        }

        else {
            Class<T> clazz = (Class<T>) clazzes.get(compositeClass);
            for (String value : values) {
                T item = parse(clazz, value);
                result.add(item);
            }
        }
        return result;
    }
}