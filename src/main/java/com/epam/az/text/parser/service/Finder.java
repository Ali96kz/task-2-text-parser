package com.epam.az.text.parser.service;

import com.epam.az.text.parser.entity.Sentence;
import com.epam.az.text.parser.entity.Text;

import java.util.ArrayList;
import java.util.Iterator;

public class Finder {
    public Sentence find(Text text) {
        Iterator it = text.iterator(Text.class ,Sentence.class);
        while (it.hasNext()){
            Sentence sentence = (Sentence) it.next();
            sentence.remove(1);
            sentence.remove(-1);
            System.out.println(sentence.assemble(new StringBuilder()));

        }
        return null;
        }
}
