package Algorithm.Recursive;

import org.junit.Test;
import static NEU.ET39.CSC250.Algorithm.Recursive.BinarySearch;

public class BinaryTests {
    @Test
    public void testEmptyArray(){
        Integer[] input = {};
        int expected = -1;
        assert expected == BinarySearch(input,0,input.length-1,0);
    }

    @Test
    public void testOneElementArray(){
        Integer[] input = {1};
        int expected = 0;
        assert expected == BinarySearch(input,0, 0,1);
    }

    @Test
    public void testTwoElementArray(){
        Integer[] input = {1,2};
        int expected = 0;
        assert expected == BinarySearch(input,0,input.length-1,1);
    }


    // CHAT GPT GENERATED TESTS:
    @Test
    public void testMiddleElementMatch() {
        Integer[] input = {1, 3, 5, 7, 9};
        int expected = 2; // index of 5
        assert expected == BinarySearch(input, 0, input.length - 1, 5);
    }

    @Test
    public void testElementNotFound() {
        Integer[] input = {2, 4, 6, 8, 10};
        int expected = -1; // 7 is not in the array
        assert expected == BinarySearch(input, 0, input.length - 1, 7);
    }

    @Test
    public void testLastElementMatch() {
        Integer[] input = {1, 2, 3, 4, 5};
        int expected = 4; // index of 5
        assert expected == BinarySearch(input, 0, input.length - 1, 5);
    }

}
