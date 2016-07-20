package com.epam.az.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReaderz {
    public String read() throws IOException {
        StringBuilder str = new StringBuilder();
        File file = new File("/home/ali/IdeaProjects/task-2-text-parser/src/main/resources/A.txt");
        InputStream inputStream = new FileInputStream(file);
        int data = inputStream.read();
        str.append((char)data);
        while(data != -1){
            data = inputStream.read();
            str.append((char) data);
        }
        return str.toString();
    }
}
