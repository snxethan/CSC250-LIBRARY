package DataStructure.List;

import NEU.ET39.CSC250.DataStructure.List.Queue;
import org.junit.jupiter.api.Test;

public class Queue_Tests {

    @Test
    public void testEnqueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assert queue.peek() == 1;
    }

    @Test
    public void testDequeue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assert queue.dequeue() == 1;
        assert queue.peek() == 2;
    }

    @Test
    public void testPeek() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assert queue.peek() == 1;
    }

    @Test
    public void testContains() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assert queue.contains(1);
        assert !queue.contains(3);
    }

    @Test
    public void testGet() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assert queue.get(0) == 1;
        assert queue.get(1) == 2;
        assert queue.get(2) == 3;
    }
}
