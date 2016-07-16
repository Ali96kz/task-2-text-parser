package com.epam.az.parser.entity;

import java.util.ArrayList;
import java.util.List;

public class Page extends BaseEntity {

    private List <Paragraph> paragraphs = new ArrayList<Paragraph>();

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }
}
