package com.epam.az.text.parser.entity;

import java.util.List;
import java.util.Map;

public class Paragraph extends AbstractComposite<Sentence> {
    public void getSentences(List<Map<String, Integer>> list) {
        for (Sentence item : items) {
            item.getSentences(list);
        }
    }
}
