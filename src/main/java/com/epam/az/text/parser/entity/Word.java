package com.epam.az.text.parser.entity;


import java.util.HashMap;

public class Word extends AbstractComposite<WordChar> implements SentencePart {

    @Override
    public void getSentences(HashMap<String, Integer> map) {
        StringBuilder stringBuilder = new StringBuilder();

        for (WordChar item : items) {
            stringBuilder.append(item.getValue());
        }
        String word  = stringBuilder.toString();

        if (map.get(word) != null){
            map.put(word, map.get(word)+1);
        }
        else {
            map.put(word, 1);
        }
    }

}
