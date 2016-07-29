package com.epam.az.text.parser.entity;

import java.util.*;
import java.util.List;

public abstract class AbstractComposite<E extends TextComponent> implements TextComposite<E> {
    List<E> items = new ArrayList<>();
    static Map<Class, Class> iterComponent = new HashMap<>();
    static Map<Class, Class> deepIter = new HashMap<>();

    {
        deepIter.put(Paragraph.class, Text.class);
        deepIter.put(Sentence.class, Paragraph.class);
        deepIter.put(Word.class, Sentence.class);

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
        else
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
    @Override
    public Iterator<E> iterator(Class clazz){
        if(iterComponent.get(this.getClass()) == clazz) return iterator();
        return  new DeepIterator(clazz);
    }

    @Override
    public List<E> getItems() {
        return items;
    }

    class DeepIterator<T extends AbstractComposite> implements Iterator<T>{
        private int cursor = 0;
        private Class aClass;
        private Iterator it = null;
        public DeepIterator(Class aClass) {
            this.aClass = aClass;
        }

        @Override
        public boolean hasNext() {
            if(it == null){
                if(items.get(cursor) instanceof AbstractComposite) {
                    AbstractComposite abstractComposite = (AbstractComposite) items.get(cursor);
                    it = abstractComposite.iterator(aClass);
                    return it.hasNext();
                }
            }else {
                if (it.hasNext()) {
                    return it.hasNext();
                } else {
                    if (cursor+1 < size() && items.get(cursor) instanceof AbstractComposite) {
                        cursor++;
                        AbstractComposite composite = (AbstractComposite) items.get(cursor);
                        it = composite.iterator(aClass);
                        return it.hasNext();
                    }
                }

            }
            return false;
        }

        @Override
        public T next() {
            return (T) it.next();
        }

        public boolean initialize(){
            return false;
        }
    }
}
