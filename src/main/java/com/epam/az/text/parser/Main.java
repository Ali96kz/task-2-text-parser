package com.epam.az.text.parser;

import com.epam.az.text.parser.entity.Text;
import com.epam.az.text.parser.parser.Finder;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        Finder finder = new Finder();
        finder.find(new Text());
    }

}
