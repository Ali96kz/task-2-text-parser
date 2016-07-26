package com.epam.az.text.parser;

import com.epam.az.text.parser.entity.Text;
import com.epam.az.text.parser.parser.GenericRegExParser;
import com.epam.az.text.parser.parser.Parser;
import com.epam.az.text.parser.service.FileReaderz;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        FileReaderz fileReader = new FileReaderz();
        Parser parser = new GenericRegExParser();
        String str = fileReader.readFile();
        Text text = parser.parse(Text.class, str);
        StringBuilder stringBuilder = new StringBuilder();
        Map<Integer, Map<String, Integer>> map = new HashMap<Integer, Map<String, Integer>>();

     }
}
