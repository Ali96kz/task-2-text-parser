package com.epam.az.text.parser.entity;

import java.util.Iterator;
import java.util.List;

public interface TextComposite<E extends TextComponent> extends TextComponent, Iterable<E> {
    void add(E item);

    void remove(E item);

    E get(int index);

    void remove(int index);

    List<E> getItems();

    @Override
    Iterator<E> iterator();
    Iterator<E> iterator(Class parentClass ,Class clazz);
}
