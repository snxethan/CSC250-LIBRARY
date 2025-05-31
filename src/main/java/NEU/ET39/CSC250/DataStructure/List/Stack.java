package NEU.ET39.CSC250.DataStructure.List;

public class Stack <T extends Comparable<T>> {
    private final DoubleLinkedList<T> list = new DoubleLinkedList<>();
    /**
     * Pushes an item onto the stack.
     * Big-O: O(1)
     * @param value the item to be added
     */
    public void push(T value) {
        list.insert(value, 0);
    }

    /**
     * Removes and returns the item on the top of the stack.
     * Big-O: O(1)
     * @return the top item
     */
    public T pop() {
        T top = list.get(0);
        list.removeFirst();
        return top;
    }

    /**
     * Returns the top item without removing it.
     * Big-O: O(1)
     * @return the top item
     */
    public T peek() {
        return list.get(0);
    }

    /**
     * Checks if a value exists in the stack.
     * Big-O: O(n)
     * @param val the value to check
     * @return true if exists, false otherwise
     */
    public boolean contains(T val) {
        return list.search(val) != -1;
    }

    /**
     * Returns the item at the given index where index 0 is the top.
     * Big-O: O(n)
     * @param index index to get value at
     * @return value at index
     */
    public T get(int index) {
        return list.get(index);
    }
}
