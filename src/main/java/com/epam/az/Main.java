package com.epam.az;


import com.epam.az.entity.Text;
import com.epam.az.service.FileReaderz;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        FileReaderz fileReader = new FileReaderz();
        String string = fileReader.read();
        Text text =  parser.parseText(string);
    }
}
