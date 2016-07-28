package com.epam.az.text.parser.entity;

import java.util.*;
import java.util.List;

public abstract class AbstractComposite<E extends TextComponent> implements TextComposite<E> {
    List<E> items = new ArrayList<>();
    static Map<Class, Class> iterComponent = new HashMap<>();
    static Map<Class, List<Class>> deepIter = new HashMap<>();

    {
        deepIter.put(Text.class, Arrays.asList(Paragraph.class, Sentence.class));

        iterComponent.put(Text.class, Paragraph.class);
        iterComponent.put(Paragraph.class, Sentence.class);
        iterComponent.put(Sentence.class, Word.class);
        iterComponent.put(Word.class, WordChar.class);
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

    public Iterator<E> iterator(Class parentClass, Class clazz){
        if(iterComponent.get(this.getClass()) == clazz) return iterator();
        System.out.println();
        return  new DeepIterator(this.getClass(),clazz);
    }

    @Override
    public List<E> getItems() {
        return items;
    }

    class DeepIterator<T extends AbstractComposite> implements Iterator<T>{
        private int cursor = 0;
        private Class aClass;
        private Class parentClass;
        public DeepIterator(Class parentClass, Class aClass) {
            this.aClass = aClass;
            this.parentClass = aClass;
        }

        @Override
        public boolean hasNext() {
            if(cursor < size()) return false;
            if(items.get(cursor) instanceof AbstractComposite) {
                AbstractComposite composite = (AbstractComposite) items.get(cursor);
                return composite.iterator(iterComponent.get(parentClass), aClass).hasNext();
            }
            else {
                return false;
            }
        }

        @Override
        public T next() {
            return null;
        }
    }
}