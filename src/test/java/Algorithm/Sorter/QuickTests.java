package Algorithm.Sorter;

import NEU.ET39.CSC250.Algorithm.Sorter;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickTests {

    @Test
    public void testQuickSortEmptyArray() {
        Comparable[] input = {};
        Comparable[] expected = {};
        assertArrayEquals(expected, Sorter.quickSort(input, 0, input.length - 1));
    }

    @Test
    public void testQuickSortSingleElement() {
        Comparable[] input = {42};
        Comparable[] expected = {42};
        assertArrayEquals(expected, Sorter.quickSort(input, 0, input.length - 1));
    }

    @Test
    public void testQuickSortAlreadySorted() {
        Comparable[] input = {1, 2, 3, 4, 5};
        Comparable[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, Sorter.quickSort(input, 0, input.length - 1));
    }

    @Test
    public void testQuickSortReverseOrder() {
        Comparable[] input = {9, 7, 5, 3, 1};
        Comparable[] expected = {1, 3, 5, 7, 9};
        assertArrayEquals(expected, Sorter.quickSort(input, 0, input.length - 1));
    }

    @Test
    public void testQuickSortRandomOrder() {
        Comparable[] input = {8, 3, 7, 4, 2, 6, 5, 1};
        Comparable[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, Sorter.quickSort(input, 0, input.length - 1));
    }
}
