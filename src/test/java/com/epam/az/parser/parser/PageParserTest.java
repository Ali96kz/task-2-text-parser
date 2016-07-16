package com.epam.az.parser.parser;

import com.epam.az.parser.entity.Paragraph;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PageParserTest {
    PageParser pageParser = new PageParser();
    String str = "asdasdasd asdasd asdasd asda asdasd asdas fsd    asdasdasdasdasdasdasdasdasdasdasdasd sadasd as  saasd    asdasdasdasdsadasdasdasd";
    @Test
    public void test(){
        List<Paragraph> paragraphs = pageParser.parse(str);
        assertEquals(3, paragraphs.size());
    }
}