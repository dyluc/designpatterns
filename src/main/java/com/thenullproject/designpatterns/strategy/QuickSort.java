package com.thenullproject.designpatterns.strategy;

public final class QuickSort implements ArraySortStrategy {

    @Override
    public void sort(Integer[] array) {
        System.out.println("Quick sorting...");
        sort(array, 0, array.length - 1);
    }

    private void sort(Integer[] array, int firstIndex, int lastIndex) {
        if(firstIndex < lastIndex) {
            int i = partition(array, firstIndex, lastIndex);
            sort(array, firstIndex, i - 1);
            sort(array, i + 1, lastIndex);
        }
    }

    private int partition(Integer[] array, int firstIndex, int lastIndex) {

        int pivot = array[lastIndex];
        int i = firstIndex - 1;

        for (int j = firstIndex; j < lastIndex; j++) {
            if (array[j] <= pivot) {
                i++;
                int current = array[i];
                array[i] = array[j];
                array[j] = current;
            }
        }

        int next = array[i + 1];
        array[i + 1] = array[lastIndex];
        array[lastIndex] = next;

        return i + 1;
    }
}