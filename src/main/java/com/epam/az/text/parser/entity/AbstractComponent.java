package com.epam.az.text.parser.entity;

import java.awt.*;
import java.util.*;
import java.util.List;

public abstract class AbstractComponent<E extends TextComposite> implements TextComponent<E>{
    List<E> items = new ArrayList<>();
    static Map<Class, Class> iterComponent = new HashMap<>();
    static Map<Class, Class> deepIter = new HashMap<>();

    {
        deepIter.put(Text.class, Paragraph.class);
        deepIter.put(Paragraph.class, Sentence.class);
        deepIter.put(Sentence.class, Word.class);
    }

    @Override
    public void add(E item) {
        items.add(item);
    }

    @Override
    public void remove(E item) {
        items.remove(item);
    }

    @Override
    public void remove(int i) {
        if (i < 0) {
            items.remove(items.size() + i);
        }
        items.remove(i);
    }

    @Override
    public E get(int index) {
        return items.get(index);
    }

    @Override
    public StringBuilder assemble(StringBuilder stringBuilder) {
        for (E value : items) {
            value.assemble(stringBuilder);
        }
        return stringBuilder;
    }
    public int size() {
        return items.size();
    }
    @Override
    public Iterator<E> iterator() {
        return items.iterator();
    }

    public Iterator<E> iterator(Class clazz){
        if(true) return iterator();
        if (true) return  new DeepIterator(clazz);

        return Collections.emptyIterator();
    }

    @Override
    public List<E> getItems() {
        return items;
    }

    class DeepIterator<T extends AbstractComponent> implements Iterator<T>{
        private int cursor = 0;
        private Class aClass;

        public DeepIterator(Class aClass) {
            this.aClass = aClass;
        }

        @Override
        public boolean hasNext() {
            if (deepIter.get(aClass) == aClass) {

            }
            return iterator(deepIter.get(aClass)).hasNext();
        }

        @Override
        public T next() {
            if (deepIter.get(aClass) == aClass) {
                cursor++;
                return (T) items.get(cursor);
            }
            return (T) iterator(deepIter.get(aClass)).next();
        }
    }
}
