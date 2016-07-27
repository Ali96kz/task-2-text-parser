package com.epam.az.text.parser.entity;

import java.util.*;

public abstract class AbstractComponent<E extends TextComposite> implements TextComponent<E>, Iterable<E> {
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

    class DeepIterator implements Iterator<E>{
        private Class clazz;
        private int cursor = 0;
        public DeepIterator(Class clazz) {
            this.clazz = clazz;
        }

        public Iterator getDeepIter(Class clazz){
            if(deepIter.get(clazz) == clazz){
                return iterator(clazz);
            }
            return getDeepIter(deepIter.get(clazz));
        }

        @Override
        public boolean hasNext() {
            return cursor <= size();
        }
        @Override
        public E next() {
            cursor++;
            return get(cursor);
        }
    }
}
