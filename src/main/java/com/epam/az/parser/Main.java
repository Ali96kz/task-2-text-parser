package com.epam.az.parser;

import com.epam.az.parser.entity.Page;
import com.epam.az.parser.parser.PageParser;
import com.epam.az.parser.service.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();
        PageParser pageParser = new PageParser();
        String str =  fileReader.read();
        Page page = new Page();
        pageParser.parse(str, page);
    }
}
