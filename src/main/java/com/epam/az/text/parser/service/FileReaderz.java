package com.epam.az.text.parser.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReaderz {

    public String read() {
        StringBuilder str = new StringBuilder();
        File file = new File("./src/main/resources/A.txt");
        try (InputStream inputStream = new FileInputStream(file)) {
            int data = inputStream.read();
            str.append((char) data);
            while (data != -1) {
                data = inputStream.read();
                str.append((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }
}
