package com.epam.az.text.parser.entity;

import java.util.HashMap;
import java.util.Map;

public abstract class Symbol implements TextLeaf {
    protected final char value;

    Symbol(char value) {
        this.value = value;
    }

    public static Symbol valueOf(char c, Class clazz) {
        Symbol result;
        if (Cache.symbolMap.get(c) == null) {
            if (clazz == PunctuationChar.class) {
                result = new PunctuationChar(c);
            } else {
                result = new WordChar(c);
            }
            return result;
        } else
            return Cache.symbolMap.get(c);
    }

    public StringBuilder assemble(StringBuilder stringBuilder) {
        stringBuilder.append(value);
        return stringBuilder;
    }

    public char getValue() {
        return value;
    }

    static class Cache {
        static Map<Character, Symbol> symbolMap = new HashMap<>();
    }
}
