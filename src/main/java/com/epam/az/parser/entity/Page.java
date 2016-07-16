package com.epam.az.parser.entity;

import java.util.ArrayList;
import java.util.List;

public class Page extends BaseEntity {
    private String value;
    private List <Paragraph> paragraphs = new ArrayList<Paragraph>();

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
