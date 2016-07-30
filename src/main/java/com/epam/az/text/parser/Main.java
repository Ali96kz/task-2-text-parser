package com.epam.az.text.parser;

import com.epam.az.text.parser.entity.Text;
import com.epam.az.text.parser.parser.GenericRegExParser;
import com.epam.az.text.parser.parser.Parser;
import com.epam.az.text.parser.service.FileReaderz;
import com.epam.az.text.parser.service.Finder;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        FileReaderz fileReader = new FileReaderz();
        String s = fileReader.read();
        Parser parser = new GenericRegExParser();
        Text text = parser.parse(Text.class, s);

        Finder finder = new Finder();
        StringBuilder stringBuilder = new StringBuilder();
        finder.deleteWord(text, stringBuilder);
        System.out.println(stringBuilder);
    }
}
