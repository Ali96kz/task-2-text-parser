package com.epam.az.text.parser;

import com.epam.az.text.parser.entity.Text;
import com.epam.az.text.parser.parser.GenericRegExParser;
import com.epam.az.text.parser.parser.Parser;
import com.epam.az.text.parser.service.FileReaderz;
import com.epam.az.text.parser.service.Finder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        FileReaderz fileReader = new FileReaderz();
        String s = fileReader.read();
        Parser parser = new GenericRegExParser();
        Text text = parser.parse(Text.class, s);

        Finder finder = new Finder();
        StringBuilder stringBuilder = new StringBuilder();
        finder.deleteWord(text, stringBuilder);
        logger.info(stringBuilder.toString());
    }
}
