package com.epam.az;

import com.epam.az.entity.Paragraph;
import com.epam.az.service.FileReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();
        Parser parser = new Parser();
        Paragraph paragraph = parser.parse(fileReader.read());

    }
}
