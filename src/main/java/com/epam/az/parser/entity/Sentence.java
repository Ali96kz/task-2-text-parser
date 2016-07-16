package com.epam.az.parser.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence extends BaseEntity{
    private String value;
    private List<Word> words = new ArrayList<Word>();

    public Sentence() {
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
