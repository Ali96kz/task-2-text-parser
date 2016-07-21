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
        clazzes.put(AbstractComposite.class, Text.class);
        clazzes.put(Text.class, Paragraph.class);
        clazzes.put(Paragraph.class, Sentence.class);
        clazzes.put(Sentence.class, SentencePart.class);

        regEx.put(Text.class, "(?<=\\n)");
        regEx.put(Paragraph.class, "(?<=[.!?]\\s");
        regEx.put(Sentence.class, "(?<=\\w)(?=\\W) | (?<=\\W) (?=\\w) | (?<=\\W)(?=\\W)");
        regEx.put(SentencePart.class, "");
    }
    public  <T extends AbstractComposite> T parse( Class<T> compositeClass, String sourceString) throws IllegalAccessException, InstantiationException {
        String[] values = sourceString.split(regEx.get(compositeClass));
        T result = null;
        Class<T> clazz = (Class<T>) clazzes.get(compositeClass);
        result = clazz.newInstance();

        if(clazzes.get(clazz) == PunctuationChar.class | clazzes.get(clazz) == WordChar.class){
            for (int i = 0; i < sourceString.length(); i++) {
                Pattern pattern = Pattern.compile("\\w");
                Matcher matcher = pattern.matcher(sourceString);
                Symbol symbol = null;
                if (matcher.matches()) {
                    symbol = new WordChar();
                }
                else {
                    symbol = new PunctuationChar();
                }

                symbol.setValue(sourceString.charAt(i));
                result.add(symbol);
            }
        }

        else {
            for (String value : values) {
                T item = parse(clazz, value);
                result.add(item);
            }
        }
        return result;
    }
}