package com.epam.az.parser.parser;

import com.epam.az.parser.entity.Page;
import com.epam.az.parser.entity.Paragraph;
import java.util.ArrayList;
import java.util.List;

public class PageParser {
    public void parse(String str, Page page) {
        List<Paragraph> paragraphs = new ArrayList<Paragraph>();
        ParagraphParser paragraphParser = new ParagraphParser();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && str.charAt(i + 1) == ' ' && str.charAt(i + 2) == ' ' && str.charAt(i + 3) == ' ' || i == str.length() ) {
                Paragraph paragraph = new Paragraph();
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = i-1; j > -1; j--) {
                    stringBuilder.append(str.charAt(j));
                    if (str.charAt(j) == ' ' && str.charAt(j - 1) == ' ' || j == 0 ) {
                        paragraph.setValue(stringBuilder.toString());
                        paragraphs.add(paragraph);

                        paragraphParser.parse(paragraph.getValue(), paragraph);
                        break;
                    }
                }
            }
        }
        page.setParagraphs(paragraphs);
    }
}
