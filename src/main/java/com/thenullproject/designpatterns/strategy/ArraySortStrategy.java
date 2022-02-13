package com.thenullproject.designpatterns.strategy;

public sealed interface ArraySortStrategy permits BubbleSort, QuickSort {
    void sort(Integer[] array);
}
