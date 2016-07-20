package com.epam.az.text.parser.entity;

public abstract class Symbol implements  Leaf{
    private char value;

    public StringBuilder assemble(StringBuilder stringBuilder) {
        stringBuilder.append(value);
        return stringBuilder;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

}
