package pl.hfdp.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * IteratorEnumeration is an adapter for Iterator. It uses Iterables Enumeration.
 */
class IteratorEnumeration<T> implements Iterator<T> {

    private Enumeration<T> enumeration;

    public IteratorEnumeration(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public T next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Enumerations do not support removal of elements.");
    }
}

/**
 * EnumerationIterator is an adapter for Enumerations. It uses Iterables internally.
 */
class EnumerationIterator<T> implements Enumeration<T> {

    private Iterator<T> iterator;

    public EnumerationIterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public T nextElement() {
        return iterator.next();
    }

}

