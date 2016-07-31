package com.epam.az.text.parser.entity;

import java.util.List;

public class Sentence extends AbstractComposite<SentencePart> {
    public void add(List<SentencePart> sentenceParts) {
        for (SentencePart sentencePart : sentenceParts) {
            items.add(sentencePart);
        }
    }
}
