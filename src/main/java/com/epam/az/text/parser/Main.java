package com.epam.az.text.parser;

import com.epam.az.text.parser.entity.Text;
import com.epam.az.text.parser.parsers.GenericRegExParser;
import com.epam.az.text.parser.parsers.Parser;
import com.epam.az.text.parser.service.FileReaderz;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        FileReaderz fileReader = new FileReaderz();
        Parser parser = new GenericRegExParser();
        String str = fileReader.readFile();
        Text text = parser.parse(Text.class, str);
        StringBuilder stringBuilder = new StringBuilder();

        text.assemble(stringBuilder);
        System.out.println(stringBuilder);
    }
}
