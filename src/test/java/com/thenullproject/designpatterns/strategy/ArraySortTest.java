package com.thenullproject.designpatterns.strategy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortTest {

    // Instantiate strategies directly (we are testing the method, not employing a design pattern (see Main.java for how the strategy pattern should be used)).
    private static BubbleSort bubbleSort;
    private static QuickSort quickSort;

    @BeforeAll
    static void init() {
        bubbleSort = new BubbleSort();
        quickSort = new QuickSort();
    }

    @ParameterizedTest(name = "Unsorted Array: {0}, Expected Sorted Array: {1}")
    @DisplayName("Should sort integer array using bubble sort")
    @MethodSource("createArrayTestData")
    public void shouldSortArrayUsingBubbleSort(Integer[] unsortedArray, Integer[] sortedArray) {
        // sort the array
        bubbleSort.sort(unsortedArray);

        // check the sorted array against our expected value
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @ParameterizedTest(name = "Unsorted Array: {0}, Expected Sorted Array: {1}")
    @DisplayName("Should sort integer array using quick sort")
    @MethodSource("createArrayTestData")
    public void shouldSortArrayUsingQuickSort(Integer[] unsortedArray, Integer[] sortedArray) {
        // sort the array
        quickSort.sort(unsortedArray);

        // check the sorted array against our expected value
        assertArrayEquals(sortedArray, unsortedArray);
    }

    public static Stream<Arguments> createArrayTestData() {
        return Stream.of(
                Arguments.of(new Integer[]{5, 2, 90, 4, 37, 1, 8}, new Integer[] {1, 2, 4, 5, 8, 37, 90}),
                Arguments.of(new Integer[]{21, 6, 9, 33, 3}, new Integer[] {3, 6, 9, 21, 33}),
                Arguments.of(new Integer[]{5, 1, 4, 15, 64, 255, 234}, new Integer[] {1, 4, 5, 15, 64, 234, 255}),
                Arguments.of(new Integer[]{-4, -13, -5, -41, 4, 3}, new Integer[] {-41, -13, -5, -4, 3, 4})
        );
    }

}