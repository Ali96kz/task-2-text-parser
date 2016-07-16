package com.epam.az.parser.parser;

import com.epam.az.parser.entity.Sentence;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParagraphParserTest {
    ParagraphParser paragraphParser = new ParagraphParser();
    String str = "Java, the language and the platform, owes much of its fame and longevity to the libraries, frameworks and tools which together make\n" +
            "up its ecosystem. No other programming language has been able to match the support that a rich ecosystem like the JVM\n" +
            "    has achieved. ssasd extremely important to understand how the ecosystem exists today, as well as its history.";
    @Test
    public void test(){
        List<Sentence> sentences = paragraphParser.parse(str);
        assertEquals("Incorrect list size", 3, sentences.size() );
    }
}