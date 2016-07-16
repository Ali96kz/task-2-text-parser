package com.epam.az.parser.parser;

import com.epam.az.parser.entity.Paragraph;
import java.util.ArrayList;
import java.util.List;

public class PageParser {
    public List<Paragraph> parse(String str) {
        List<Paragraph> paragraphs = new ArrayList<Paragraph>();
        ParagraphParser paragraphParser = new ParagraphParser();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && str.charAt(i + 1) == ' ' && str.charAt(i + 2) == ' ' && str.charAt(i + 3) == ' ' || i == str.length() - 1) {
                Paragraph paragraph = new Paragraph();
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = i-1; j > -1; j--) {
                    stringBuilder.append(str.charAt(j));
                    if (str.charAt(j) == ' ' && str.charAt(j - 1) == ' ' || j == 0 ) {
                        paragraph.setValue(stringBuilder.toString());
                        paragraphs.add(paragraph);
                        break;
                    }
                }
            }
        }
        return paragraphs;
    }
}
