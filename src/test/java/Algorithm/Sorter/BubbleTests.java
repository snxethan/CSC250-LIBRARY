package Algorithm.Sorter;

import org.junit.Test;
import static NEU.ET39.CSC250.Algorithm.Sorter.bubbleSort;
import static org.junit.Assert.assertArrayEquals;

public class BubbleTests {
    @Test
    public void testAlreadySorted() {
        Integer[] input = {1, 2, 3};
        Integer[] expected = {1, 2, 3};
        bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testReverseSorted() {
        Integer[] input = {5, 4, 3, 2, 1};
        Integer[] expected = {1, 2, 3, 4, 5};
        bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testWithDuplicates() {
        Integer[] input = {3, 1, 2, 3, 1};
        Integer[] expected = {1, 1, 2, 3, 3};
        bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testEmptyArray() {
        Integer[] input = {};
        Integer[] expected = {};
        bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testAllElementsSame() {
        Integer[] input = {7, 7, 7, 7};
        Integer[] expected = {7, 7, 7, 7};
        bubbleSort(input);
        assertArrayEquals(expected, input);
    }
}