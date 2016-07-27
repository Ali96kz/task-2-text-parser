package com.epam.az.text.parser.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReaderz {
    public String readFile() {
       /* String result = "";
        try {
            BufferedReader InputStream = new BufferedReader(new FileReader("resources/A.txt"));
            result = InputStream.readLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


//        return result;
        return " asdasd asdasd ssssssssssss sssssssssssssasd asd";
    }

    public String read() throws IOException {
        StringBuilder str = new StringBuilder();
        File file = new File("/home/ali/IdeaProjects/task-2-text-parser/src/main/resources/A.txt");
        InputStream inputStream = new FileInputStream(file);
        int data = inputStream.read();
        str.append((char) data);
        while (data != -1) {
            data = inputStream.read();
            str.append((char) data);
        }
        return str.toString();
    }
}
