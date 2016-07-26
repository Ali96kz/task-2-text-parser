package com.epam.az.text.parser.entity;

import java.util.HashMap;

public interface Composite<E extends Compositor> extends Compositor {
    void add(E item);
    void remove(E item);
    void get(int index);
    void remove(int index);

}
