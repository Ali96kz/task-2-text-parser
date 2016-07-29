package com.epam.az.text.parser.service;

import com.epam.az.text.parser.entity.Sentence;
import com.epam.az.text.parser.entity.Text;

import java.util.Iterator;

public class Finder {
    /**
     * Delete from sentence first and last word
     * @param text
     * @return
     */
    public Sentence deleteWord(Text text, StringBuilder stringBuilder) {
        Iterator it = text.iterator(Sentence.class);
        while (it.hasNext()){
            Sentence sentence = (Sentence) it.next();
            sentence.remove(0);
            sentence.remove(-1);
            sentence.assemble(stringBuilder);
        }
        return null;
    }
}
