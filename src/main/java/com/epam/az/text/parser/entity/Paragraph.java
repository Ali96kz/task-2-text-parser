package com.epam.az.text.parser.entity;

import java.util.HashMap;
import java.util.Map;

public class Paragraph extends AbstractComposite<Sentence> {
    public void getSentences(HashMap<Integer, Map<String, Integer>> map) {

        for (Sentence item : items) {
            item.getSentences(map);
        }
    }
}
