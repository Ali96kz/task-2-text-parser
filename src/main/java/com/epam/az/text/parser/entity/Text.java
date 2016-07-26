package com.epam.az.text.parser.entity;

import java.util.HashMap;
import java.util.Map;

public class Text extends AbstractComposite<Paragraph>  {

    public void getSentences(HashMap<Integer, Map<String, Integer>> map) {

        for (Paragraph item : items) {
            item.getSentences(map);
        }
    }
}
