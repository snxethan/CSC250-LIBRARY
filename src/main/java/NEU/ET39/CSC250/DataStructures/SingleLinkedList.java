package NEU.ET39.CSC250.DataStructures;

import NEU.ET39.CSC250.DataStructures.Nodes.Node_SLL;

public class SingleLinkedList <T extends Comparable<T>> {
    private Node_SLL<T> head;
    private int count;

    public Node_SLL<T> getHead() {
        return head;
    }

    public void setHead(Node_SLL<T> head) {
        if(head == null) {
            throw new IllegalArgumentException("Head cannot be null");
        }
        this.head = head;
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
        Node_SLL<T> newNode = new Node_SLL<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node_SLL<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        count++;
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
        Node_SLL<T> newNode = new Node_SLL<>(value); // Create a new node with the value
        if (index == 0) { // Insert at the head
            newNode.setNext(head); // Set the new node's next to the current head
            head = newNode; // Update the head to the new node
        } else {
            Node_SLL<T> current = head; // Start from the head
            for (int i = 0; i < index - 1; i++) { // Traverse to the node before the index
                current = current.getNext(); // Move to the next node
            }
            newNode.setNext(current.getNext()); // Set the new node's next to the current node's next
            current.setNext(newNode); // Link the current node to the new node
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
        Node_SLL<T> current = head; // Start from the head
        for (int i = 0; i < index; i++) { // Traverse to the desired index
            current = current.getNext(); // Move to the next node
        }
        return current.getData(); // Return the data at the specified index
    }

    /**
     *  removes and returns the first value in the list.
     *  If the list is empty, throw an IllegalStateException
     */
    public void removeFirst(){
        if (head == null) { // Check if the list is empty
            throw new IllegalStateException("List is empty");
        }
        head = head.getNext(); // Update the head to the next node
        count--; // Decrement the count of nodes
        if(head == null) { // If the list is now empty
            count = 0; // Reset the count to 0
        }
    }

    /**
     *  removes and returns the last value in the list.
     */
    public void removeLast(){
        if (head == null) { // Check if the list is empty
            throw new IllegalStateException("List is empty");
        }
        if (head.getNext() == null) { // If there's only one node
            head = null; // Set head to null
        } else {
            Node_SLL<T> current = head; // Start from the head
            while (current.getNext().getNext() != null) { // Traverse to the second last node
                current = current.getNext(); // Move to the next node
            }
            current.setNext(null); // Set the last node's next to null
        }
        count--; // Decrement the count of nodes
        if(head == null) { // If the list is now empty
            count = 0; // Reset the count to 0
        }
    }

    /**
     * removes and returns the value at a given index.
     * Any index less than zero or equal to or greater than count should throw an index out of bounds exception.
     * @param index the index to remove the value from
     * @return the value at the given index
     */
    public T removeAt(int index){
        if (head == null){
            throw new IllegalStateException("List is empty");
        }
        if (index < 0 || index >= count) { // Check if index is valid
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node_SLL<T> current = head; // Start from the head
        if (index == 0) { // If removing the head
            T data = head.getData(); // Store the data to return
            head = head.getNext(); // Update the head to the next node
            count--; // Decrement the count of nodes
            return data; // Return the removed data
        }
        for (int i = 0; i < index - 1; i++) { // Traverse to the node before the index
            current = current.getNext(); // Move to the next node
        }
        T data = current.getNext().getData(); // Store the data to return
        current.setNext(current.getNext().getNext()); // Link the current node to the node after the one being removed
        count--; // Decrement the count of nodes
        return data; // Return the removed data
    }

    /**
     *  removes all values in the list.
     */
    public void clear(){
        head = null; // Set head to null
        count = 0; // Reset the count of nodes
    }

    /**
     * searches for a value in the list and returns the first index of that value when found.
     * If the key is not found in the list, the method returns -1.
     * @param value the value to search for
     * @return the index of the value if found, -1 otherwise
     */
    public int search(T value){
        Node_SLL<T> current = head; // Start from the head
        int index = 0; // Initialize index
        while (current != null) { // Traverse the list
            if (current.getData().equals(value)) { // Check if the current node's data matches the value
                return index; // Return the index if found
            }
            current = current.getNext(); // Move to the next node
            index++; // Increment index
        }
        return -1; // Return -1 if not found
    }


    /**
     *  returns a string representation of the list.
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node_SLL<T> current = head; // Start from the head
        while (current != null) { // Traverse the list
            sb.append(current.getData()).append(" > "); // Append the data to the string
            current = current.getNext(); // Move to the next node
        }
        sb.append("null"); // Append null at the end
        return sb.toString(); // Return the string representation
    }

}
