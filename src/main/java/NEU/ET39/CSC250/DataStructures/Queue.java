package NEU.ET39.CSC250.DataStructures;

/**
 * A generic queue implementation using DoubleLinkedList.
 * @param <T> the type of elements held in this queue
 */
public class Queue<T extends Comparable<T>> {
    private final DoubleLinkedList<T> list = new DoubleLinkedList<>();

    /**
     * Adds an item to the end of the queue.
     * Big-O: O(1)
     * @param value the item to be added
     */
    public void enqueue(T value) {
        list.add(value);
    }

    /**
     * Removes and returns the item at the front of the queue.
     * Big-O: O(1)
     * @return the front item
     */
    public T dequeue() {
        T front = list.get(0);
        list.removeFirst();
        return front;
    }

    /**
     * Returns the item at the front without removing it.
     * Big-O: O(1)
     * @return the front item
     */
    public T peek() {
        return list.get(0);
    }

    /**
     * Checks if a value exists in the queue.
     * Big-O: O(n)
     * @param val the value to check
     * @return true if exists, false otherwise
     */
    public boolean contains(T val) {
        return list.search(val) != -1;
    }

    /**
     * Returns the item at the given index where index 0 is the next to be dequeued.
     * Big-O: O(n)
     * @param index index to get value at
     * @return value at index
     */
    public T get(int index) {
        return list.get(index);
    }

    // psuedo code for pop/dequeue
//    Method: pop()
//    If the list is empty (count == 0)
//    Throw an exception (IllegalStateException)
//
//    Get value at head (index 0)
//    Call removeFirst() to remove the top item
//    Return the stored value

}
