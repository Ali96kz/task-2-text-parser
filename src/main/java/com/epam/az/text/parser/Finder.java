package com.epam.az.text.parser;

import com.epam.az.text.parser.entity.Sentence;
import com.epam.az.text.parser.entity.Text;
import com.epam.az.text.parser.service.FileReaderz;

public class Finder {
    public Sentence find(Text text){
        Sentence sentence= new Sentence();
        FileReaderz fileReaderz = new FileReaderz();
        String s = fileReaderz.readFile();
        return sentence;
    }
}
