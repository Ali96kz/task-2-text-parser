package com.epam.az.text.parser.entity;

import java.util.List;
import java.util.Map;

public class Text extends AbstractComposite<Paragraph> {

    public void getSentences(List<Map<String, Integer>> maps) {
        for (Paragraph item : items) {
            item.getSentences(maps);
        }
    }
}
