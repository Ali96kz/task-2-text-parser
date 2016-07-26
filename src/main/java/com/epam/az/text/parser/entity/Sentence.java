package com.epam.az.text.parser.entity;


import java.util.HashMap;

public class Sentence extends AbstractComposite<SentencePart>{

    @Override
    public void getSentences(HashMap<String, Integer> map) {
        for (SentencePart item : items) {
            if(item instanceof Word){
                Word word = (Word) item;
                word.getSentences(map);
            }
        }
    }

}
