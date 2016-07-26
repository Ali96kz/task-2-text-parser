package com.epam.az.text.parser.entity;


import java.util.HashMap;
import java.util.Map;

public class Sentence extends AbstractComposite<SentencePart>{

    public void getSentences(HashMap<Integer, Map<String, Integer>> map) {
        Map<String, Integer> values = new HashMap<String, Integer>();
        for (SentencePart item : items) {
            if(item instanceof Word){
                Word word = (Word) item;
                word.getSentences((HashMap<String, Integer>) values);
            }
        }
    }

}
