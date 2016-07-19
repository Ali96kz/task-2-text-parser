package com.epam.az.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    public List<Word> words = new ArrayList<Word>();

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public List<Word> getSentences() {
        List<Word> result = new ArrayList<Word>();
        for (Word word: words) {
            result.add(word);
        }
        return result;
    }
    public void add(Word word){
        words.add(word);
    }

    public void remove(int i){
        words.remove(i);
    }
}
