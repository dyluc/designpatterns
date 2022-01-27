package com.thenullproject.designpatterns.iterator;

public class ArrayIterator implements Iterator {

    private final Array array;
    private int currentIndex;

    public ArrayIterator(Array array) {
        this.array = array;
        currentIndex = 0;
    }

    @Override
    public Object getNext() {
        return array.get(currentIndex++);
    }

    @Override
    public boolean hasNext() {
        return array.size() > currentIndex;
    }
}
