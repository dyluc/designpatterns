package com.thenullproject.designpatterns.strategy;

public final class BubbleSort implements ArraySortStrategy {

    @Override
    public void sort(Integer[] array) {
        System.out.println("Bubble sorting...");
        int length = array.length;
        Integer next;

        do {
            for (int i = 0; i < length - 1; i++) {
                if (array[i] > (next = array[i + 1])) {
                    array[i + 1] = array[i];
                    array[i] = next;
                }
            }
            length--;
        } while(length > 1);
    }
}
