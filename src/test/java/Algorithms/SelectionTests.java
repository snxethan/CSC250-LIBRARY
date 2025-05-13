package Algorithms;

import org.junit.Test;

import static NEU.ET39.CSC250.Algorithms.Sorter.selectionSort;
import static org.junit.Assert.assertArrayEquals;


public class
SelectionTests {
    @Test
    public void testAlreadySorted() {
        Integer[] input = {1, 2, 3};
        Integer[] expected = {1, 2, 3};
        selectionSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testReverseSorted() {
        Integer[] input = {5, 4, 3, 2, 1};
        Integer[] expected = {1, 2, 3, 4, 5};
        selectionSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testWithDuplicates() {
        Integer[] input = {3, 1, 2, 3, 1};
        Integer[] expected = {1, 1, 2, 3, 3};
        selectionSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testEmptyArray() {
        Integer[] input = {};
        Integer[] expected = {};
        selectionSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testAllElementsSame() {
        Integer[] input = {7, 7, 7, 7};
        Integer[] expected = {7, 7, 7, 7};
        selectionSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testRandomArray() {
        Integer[] input = {2,3,1,5,4};
        Integer[] expected = {1, 2, 3, 4, 5};
        selectionSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSingleElement() {
        Integer[] input = {42};
        Integer[] expected = {42};
        selectionSort(input);
        assertArrayEquals(expected, input);
    }


    @Test
    public void testNegativeNumbers() {
        Integer[] input = {-3, -1, -4, -2};
        Integer[] expected = {-4, -3, -2, -1};
        selectionSort(input);
        assertArrayEquals(expected, input);
    }


    @Test
    public void testMixedNumbers() {
        Integer[] input = {-2, 3, 0, -1, 2};
        Integer[] expected = {-2, -1, 0, 2, 3};
        selectionSort(input);
        assertArrayEquals(expected, input);
    }


    @Test
    public void testLargeNumbers() {
        Integer[] input = {100000, 999999, -100000, 500000};
        Integer[] expected = {-100000, 100000, 500000, 999999};
        selectionSort(input);
        assertArrayEquals(expected, input);
    }


    @Test
    public void testStringSorting() {
        String[] input = {"banana", "apple", "cherrys"};
        String[] expected = {"apple", "banana", "cherrys"};
        selectionSort(input);
        assertArrayEquals(expected, input);
    }



}
