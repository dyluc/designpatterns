package com.thenullproject.designpatterns.strategy;

/**
 * Context class to keep track to interact with strategy interface
 */
public class ArraySort {

    private ArraySortStrategy strategy;

    public void setStrategy(ArraySortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(Integer[] array) {
        strategy.sort(array);
    }
}
