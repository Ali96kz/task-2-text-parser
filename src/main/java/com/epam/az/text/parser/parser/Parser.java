package com.epam.az.text.parser.parser;

import com.epam.az.text.parser.entity.AbstractComposite;

public interface Parser {
    <T extends AbstractComposite> T parse(Class<T> e, String source) throws IllegalAccessException, InstantiationException;

}
