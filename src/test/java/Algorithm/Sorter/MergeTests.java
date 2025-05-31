package Algorithm.Sorter;

import NEU.ET39.CSC250.Algorithm.Sorter;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeTests {

    @Test
    public void testMergeSortEmptyArray() {
        Comparable[] input = {};
        Comparable[] expected = {};
        assertArrayEquals(expected, Sorter.mergeSort(input));
    }

    @Test
    public void testMergeSortSingleElement() {
        Comparable[] input = {5};
        Comparable[] expected = {5};
        assertArrayEquals(expected, Sorter.mergeSort(input));
    }

    @Test
    public void testMergeSortAlreadySorted() {
        Comparable[] input = {1, 2, 3, 4, 5};
        Comparable[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, Sorter.mergeSort(input));
    }

    @Test
    public void testMergeSortReverseOrder() {
        Comparable[] input = {5, 4, 3, 2, 1};
        Comparable[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, Sorter.mergeSort(input));
    }

    @Test
    public void testMergeSortRandomOrder() {
        Comparable[] input = {3, 1, 4, 5, 2};
        Comparable[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, Sorter.mergeSort(input));
    }
}
