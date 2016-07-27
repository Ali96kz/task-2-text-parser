package com.epam.az.text.parser.entity;

import java.util.List;

public interface TextComponent<E extends TextComposite> extends TextComposite {
    void add(E item);

    void remove(E item);

    E get(int index);

    void remove(int index);

    List<E> getItems();

}
