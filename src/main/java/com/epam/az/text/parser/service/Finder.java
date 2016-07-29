package com.epam.az.text.parser.service;

import com.epam.az.text.parser.entity.Sentence;
import com.epam.az.text.parser.entity.Text;
import com.epam.az.text.parser.entity.Word;

import java.util.Iterator;

public class Finder {
    public Sentence find(Text text) {
        Iterator it = text.iterator(Word.class);
        while (it.hasNext()){
            /*Sentence sentence = (Sentence) it.next();
            sentence.remove(0);
            sentence.remove(-1);*/
            System.out.println(it.next());
//           System.out.println(word.assemble(new StringBuilder()));
        }
        return null;
        }
}
