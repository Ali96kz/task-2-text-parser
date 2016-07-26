package com.epam.az.text.parser.entity;

import java.util.HashMap;

public class Text extends AbstractComposite<Paragraph>  {
    @Override
    public void getSentences(HashMap<String, Integer> map) {
        for (Paragraph item : items) {
            item.getSentences(map);
        }
    }
}
