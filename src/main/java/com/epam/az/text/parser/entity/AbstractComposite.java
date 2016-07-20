package com.epam.az.text.parser.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractComposite <E extends Compositor> implements Composite <E>{
    private List<E> values = new ArrayList<E>();

    public void add(E item) {
        values.add(item);
    }

    public void remove(E item) {
        values.remove(item);
    }
    public void remove(int i){
        values.remove(i);
    }

    public void get(int index) {
        values.get(index);
    }

    public StringBuilder assemble(StringBuilder stringBuilder) {
        for (E value : values) {
            value.assemble(stringBuilder);
        }
        return stringBuilder;
    }
}
