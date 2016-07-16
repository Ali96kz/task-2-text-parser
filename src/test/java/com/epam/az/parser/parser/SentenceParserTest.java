package com.epam.az.parser.parser;

import com.epam.az.parser.entity.Sentence;
import com.epam.az.parser.entity.Word;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SentenceParserTest {
       SentenceParser sentenceParser = new SentenceParser();
   String paragraph = "This report sets out to understand the current landscape in Java.";

    @Test
    public void testListSize(){
        List<Word>  words = sentenceParser.parse(paragraph);
        assertEquals("Incorrect words list size", 11, words.size());
    }
    @Test
    public void emptySentence(){
        List<Word>  words = sentenceParser.parse("");
        assertEquals("Incorrect words list size", 0, words.size());
    }
}