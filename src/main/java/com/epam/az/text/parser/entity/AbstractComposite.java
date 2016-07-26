package com.epam.az.text.parser.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public abstract class AbstractComposite <E extends Compositor> implements Composite <E>, Iterable<E>{
    List<E> items = new ArrayList<E>();
    @Override
    public void add(E item) {
        items.add(item);
    }
    @Override
    public void remove(E item) {
        items.remove(item);
    }
    @Override
    public void remove(int i){
        items.remove(i);
    }
    @Override
    public void get(int index) {
        items.get(index);
    }
    @Override
    public StringBuilder assemble(StringBuilder stringBuilder) {
        for (E value : items) {
            value.assemble(stringBuilder);
        }
        return stringBuilder;
    }
    @Override
    public Iterator<E> iterator() {
        return items.iterator();
    }

}
