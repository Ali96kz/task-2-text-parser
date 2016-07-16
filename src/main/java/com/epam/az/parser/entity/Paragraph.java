package com.epam.az.parser.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private String value;
    private List<Sentence> sentences = new ArrayList<Sentence>();

    public Paragraph() {
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }
}
