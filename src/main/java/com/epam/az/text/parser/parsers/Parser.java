package com.epam.az.text.parser.parsers;

import com.epam.az.text.parser.entity.AbstractComposite;
import com.epam.az.text.parser.entity.Composite;
import com.epam.az.text.parser.entity.Compositor;

public interface Parser {
    <T extends AbstractComposite> T parse(Class<T> e, String source) throws IllegalAccessException, InstantiationException;

}
