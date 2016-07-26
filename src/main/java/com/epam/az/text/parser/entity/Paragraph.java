package com.epam.az.text.parser.entity;

import java.util.HashMap;

public class Paragraph extends AbstractComposite<Sentence> {
    @Override
    public void getSentences(HashMap<String, Integer> map) {
        for (Sentence item : items) {
            item.getSentences(map);
        }
    }
}
