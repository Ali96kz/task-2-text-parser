package com.epam.az.parser.entity;

public class Symbol extends BaseEntity{
    private char value;
    private int count;

    public Symbol() {
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
    public void addCount(){
        count++;
    }
    public int getCount() {
        return count;
    }

}
