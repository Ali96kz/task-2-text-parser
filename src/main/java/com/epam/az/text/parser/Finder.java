package com.epam.az.text.parser;

import com.epam.az.text.parser.entity.Sentence;
import com.epam.az.text.parser.entity.Text;

import java.util.*;

public class Finder {
    public Sentence find(Text text) {
        List<Map<String, Integer>> items = new ArrayList<>();
        text.getSentences(items);
        int max = -1;

        for (Map<String, Integer> item : items) {
            Set<String> set = item.keySet();
            int n = Collections.max(item.values());

            if (n > max)
                max = n;
        }

        return null;
    }
}
