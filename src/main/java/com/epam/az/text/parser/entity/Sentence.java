package com.epam.az.text.parser.entity;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sentence extends AbstractComposite<SentencePart>{

    public void getSentences(List<Map<String, Integer>> list) {
        HashMap<String, Integer> values = new HashMap<>();

        for (SentencePart item : items) {
            if(item instanceof Word){
                Word word = (Word) item;
                word.getSentences(values);
            }
        }
        list.add(values);
    }

}
