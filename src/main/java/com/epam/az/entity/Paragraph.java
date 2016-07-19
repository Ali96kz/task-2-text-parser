package com.epam.az.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private List<Sentence> sentences = new ArrayList<Sentence>();

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public Sentence getSentence(int i){
        return sentences.get(i);
    }

    public void remove(int i){
        sentences.remove(i);
    }

    public List<Sentence> getSentences() {
        List<Sentence> result = new ArrayList<Sentence>();
        for (Sentence sentence : sentences) {
            result.add(sentence);
        }
        return result;
    }

    public List<Word> getWords(int i){
        return sentences.get(i).getWords();
    }
    public String assemble(){
        StringBuilder stringBuilder = new StringBuilder();
        //TODO Write this
        return stringBuilder.toString();
    }
}
