package com.epam.az.text.parser.parser;

import com.epam.az.text.parser.entity.Sentence;
import com.epam.az.text.parser.entity.Text;

import java.util.Iterator;

public class Finder {
    public Sentence find(Text text) {
        Iterator it = text.iterator(Sentence.class);

        while (it.hasNext()){
            Sentence sentence = (Sentence) it.next();
            sentence.remove(0);
            sentence.remove(-1);
        }

        return null;
    }
}
