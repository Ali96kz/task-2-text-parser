package com.epam.az.text.parser.parser;

import com.epam.az.text.parser.entity.AbstractComponent;

public interface Parser {
    <T extends AbstractComponent> T parse(Class<T> e, String source) throws IllegalAccessException, InstantiationException;

}
