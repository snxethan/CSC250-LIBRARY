package Algorithm.Sorter;

import org.junit.Test;

import static NEU.ET39.CSC250.Algorithm.Sorter.insertionSort;
import static org.junit.Assert.assertArrayEquals;


public class InsertTests {
    @Test
    public void testAlreadySorted() {
        Integer[] input = {1, 2, 3};
        Integer[] expected = {1, 2, 3};
        insertionSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testReverseSorted() {
        Integer[] input = {5, 4, 3, 2, 1};
        Integer[] expected = {1, 2, 3, 4, 5};
        insertionSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testWithDuplicates() {
        Integer[] input = {3, 1, 2, 3, 1};
        Integer[] expected = {1, 1, 2, 3, 3};
        insertionSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testEmptyArray() {
        Integer[] input = {};
        Integer[] expected = {};
        insertionSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testAllElementsSame() {
        Integer[] input = {7, 7, 7, 7};
        Integer[] expected = {7, 7, 7, 7};
        insertionSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testRandomArray() {
        Integer[] input = {2,3,1,5,4};
        Integer[] expected = {1, 2, 3, 4, 5};
        insertionSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSingleArray(){
        Integer[] input = {1};
        Integer[] expected = {1};
        insertionSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testNullArray(){
        Integer[] input = {null};
        Integer[] expected = {null};
        insertionSort(input);
        assertArrayEquals(expected, input);
    }

}
