package NEU.ET39.CSC250.DataStructures;

import NEU.ET39.CSC250.DataStructures.Nodes.Node_DLL;

public class DoubleLinkedList <T extends Comparable<T>> {
    private Node_DLL<T> head;
    private Node_DLL<T> tail;
    private int count;

    public T getHead() {
        return head != null ? head.getData() : null;
    }

    public void setHead(Node_DLL<T> head) {
        if(head == null) {
            throw new IllegalArgumentException("Head cannot be null");
        }
        this.head = head;
    }

    public T getTail() {
        return tail != null ? tail.getData() : null;
    }

    public void setTail(Node_DLL<T> tail) {
        if(tail == null) {
            throw new IllegalArgumentException("Tail cannot be null");
        }
        this.tail = tail;
    }

    public int getCount() {
        if(head == null) {
            return 0;
        }
        return count;
    }

    public void setCount(int count) {
        if(count < 0) {
            throw new IllegalArgumentException("Count cannot be negative");
        }
        if(count == 0) {
            head = null; // If count is 0, set head to null
        }
        this.count = count;
    }

    /**
     *  puts a new value at the Tail end of the list
     * @param value the value to be added
     */
    public void add(T value){
        Node_DLL<T> newNode = new Node_DLL<>(value); // Create a new node with the value
        if (head == null) { // If the list is empty
            head = newNode; // Set head to the new node
            tail = newNode; // Set tail to the new node
        } else {
            tail.setNext(newNode); // Link the current tail to the new node
            newNode.setPrev(tail); // Link the new node's previous to the current tail
            tail = newNode; // Update tail to the new node
        }
        count++; // Increment the count of nodes
    }

    /**
     *  inserts a new value at a given index, pushing the existing value at that index to the next index spot, and so on.
     *  Insert may ONLY target indices that are currently in use. In other words, if you have 5 elements in your list, you may insert at any index between 0 and 4 inclusive. Index 5 would be considered out of bounds as it is not currently in use during the insertion process.
     *  Any index less than zero or equal to or greater than count should throw an index out of bounds exception.
     * @param value the value to be added
     * @param index the index to insert the value at
     */
    public void insert(T value, int index){
        if (index < 0 || index > count) { // Check if index is valid
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node_DLL<T> newNode = new Node_DLL<>(value); // Create a new node with the value
        if (index == 0) { // Insert at the head
            newNode.setNext(head); // Set the new node's next to the current head
            if (head != null) {
                head.setPrev(newNode); // Link the current head's previous to the new node
            }
            head = newNode; // Update the head to the new node
        } else {
            Node_DLL<T> current = head; // Start from the head
            for (int i = 0; i < index - 1; i++) { // Traverse to the node before the index
                current = current.getNext(); // Move to the next node
            }
            newNode.setNext(current.getNext()); // Link the new node's next to the current node's next
            if (current.getNext() != null) {
                current.getNext().setPrev(newNode); // Link the next node's previous to the new node
            }
            current.setNext(newNode); // Link the current node to the new node
            newNode.setPrev(current); // Link the new node's previous to the current node
        }
        count++; // Increment the count of nodes
    }

    /**
     * returns the value at the given index.
     * Any index less than zero or equal to or greater than count should be handled
     * @param index the index to get the value from
     * @return the value at the given index
     */
    public T get(int index){
        if (head == null) { // Check if the list is empty
            throw new IllegalStateException("List is empty");
        }
        if (index < 0 || index >= count) { // Check if index is valid
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node_DLL<T> current = head; // Start from the head
        for (int i = 0; i < index; i++) { // Traverse to the node at the index
            current = current.getNext(); // Move to the next node
        }
        return current.getData(); // Return the data at the node
    }

    /**
     *  removes and returns the first value in the list.
     *  If the list is empty, throw an IllegalStateException
     */
    public void removeFirst(){
        if (head == null) { // Check if the list is empty
            throw new IllegalStateException("List is empty");
        }
        if (head == tail) { // If there's only one node
            head = null; // Set head to null
            tail = null; // Set tail to null
        } else {
            head = head.getNext(); // Update head to the next node
            head.setPrev(null); // Set the previous of the new head to null
        }
        count--; // Decrement the count of nodes
    }

    /**
     *  removes and returns the last value in the list.
     */
    public void removeLast(){
        if (head == null) { // Check if the list is empty
            throw new IllegalStateException("List is empty");
        }
        if (head == tail) { // If there's only one node
            head = null; // Set head to null
            tail = null; // Set tail to null
        } else {
            tail = tail.getPrev(); // Update tail to the previous node
            tail.setNext(null); // Set the next of the new tail to null
        }
        count--; // Decrement the count of nodes
    }

    /**
     * removes and returns the value at a given index.
     * Any index less than zero or equal to or greater than count should throw an index out of bounds exception.
     * @param index the index to remove the value from
     * @return the value at the given index
     */
    public T removeAt(int index){
        if (head == null) { // Check if the list is empty
            throw new IllegalStateException("List is empty");
        }
        if (index < 0 || index >= count) { // Check if index is valid
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node_DLL<T> current = head; // Start from the head
        for (int i = 0; i < index; i++) { // Traverse to the node at the index
            current = current.getNext(); // Move to the next node
        }
        if (current == head) { // If removing the head
            removeFirst(); // Call removeFirst method
        } else if (current == tail) { // If removing the tail
            removeLast(); // Call removeLast method
        } else {
            current.getPrev().setNext(current.getNext()); // Link the previous node to the next node
            current.getNext().setPrev(current.getPrev()); // Link the next node to the previous node
            count--; // Decrement the count of nodes
        }
        return current.getData(); // Return the data at the removed node
    }

    /**
     *  removes all values in the list.
     */
    public void clear(){
        head = null; // Set head to null
        tail = null; // Set tail to null
        count = 0; // Reset the count to 0
    }

    /**
     * searches for a value in the list and returns the first index of that value when found.
     * If the key is not found in the list, the method returns -1.
     * @param value the value to search for
     * @return the index of the value if found, -1 otherwise
     */
    public int search(T value){
        Node_DLL<T> current = head; // Start from the head
        for (int i = 0; i < count; i++) { // Loop through the list
            if (current.getData().compareTo(value) == 0) { // Compare the current node's data with the value
                return i; // Return the index if found
            }
            current = current.getNext(); // Move to the next node
        }
        return -1; // Return -1 if not found
    }

    /**
     *  returns a string representation of the list.
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        if (head == null) {
            return "Empty list";
        }
        StringBuilder sb = new StringBuilder();
        Node_DLL<T> current = head;
        while (current != null) {
            sb.append(current.getData()).append(" <> ");
            current = current.getNext();
        }
        return sb.toString().trim();
    }






}