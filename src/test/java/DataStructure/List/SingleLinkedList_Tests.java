package DataStructure.List;

import NEU.ET39.CSC250.DataStructure.List.SingleLinkedList;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class SingleLinkedList_Tests {
    // 2 test methods for each method in the DoubleLinkedList class

    @Test
    public void testCount() {
        // Test the count method
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assert (list.getCount() == 3);
    }

    @Test
    public void testEmptyCount() {
        // Test the count method on an empty list
        SingleLinkedList list = new SingleLinkedList();
        assert (list.getCount() == 0);
    }

    @Test
    public void testAdd() {
        // Test the add method
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        assert (list.getCount() == 1);
    }

    @Test
    public void testAddMultiple() {
        // Test the add method with multiple elements
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assert (list.getCount() == 3);
    }

    @Test
    public void insertAt() {
        // Test the insertAt method
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        list.insert(1, 1);
        assert (list.getCount() == 3);
    }

    @Test
    public void testInsertAtInvalidIndex() {
        // Test the insertAt method with an invalid index
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.insert(3, 3), "Invalid index");
    }

    @Test
    public void testGet() {
        // Test the get method
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assert (list.get(1).equals(2));
    }

    @Test
    public void testGetInvalidIndex() {
        // Test the get method with an invalid index
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(3), "Invalid index");
    }

    @Test
    public void testRemoveFirst() {
        // Test the removeFirst method
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        list.removeFirst();
        assert (list.getCount() == 1);
    }

    @Test
    public void testRemoveFirstEmpty() {
        // Test the removeFirst method on an empty list
        SingleLinkedList list = new SingleLinkedList();
        Assertions.assertThrows(IllegalStateException.class, () -> list.removeFirst(), "Invalid index");
    }

    @Test
    public void testRemoveLast() {
        // Test the removeLast method
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        list.removeLast();
        assert (list.getCount() == 1);
    }

    @Test
    public void testRemoveLastEmpty() {
        // Test the removeLast method on an empty list
        SingleLinkedList list = new SingleLinkedList();
        Assertions.assertThrows(IllegalStateException.class, () -> list.removeLast(), "Invalid index");
    }

    @Test
    public void testRemoveAt() {
        // Test the removeAt method
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeAt(1);
        assert (list.getCount() == 2);
    }

    @Test
    public void testRemoveAtInvalidIndex() {
        // Test the removeAt method with an invalid index
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(3), "Invalid index");
    }

    @Test
    public void testClear(){
        // Test the clear method
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        list.clear();
        assert (list.getCount() == 0);
    }

    @Test
    public void testClearEmpty(){
        SingleLinkedList list = new SingleLinkedList();
        // Test the clear method on an empty list
        list.clear();
        assert (list.getCount() == 0);
    }

    @Test
    public void testSearch(){
        // Test the search method
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assert (list.search(2) == 1);
    }

    @Test
    public void testSearchEmptyList(){
        SingleLinkedList list = new SingleLinkedList();
        // Test the search method on an empty list
        assert (list.search(1) == -1);
    }

    @Test
    public void testToString(){
        // Test the toString method
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assert (list.toString().equals("1 > 2 > 3 > null"));
    }

    @Test
    public void testToStringEmpty(){
        // Test the toString method on an empty list
        SingleLinkedList list = new SingleLinkedList();
        assert (list.toString().equals("null"));
    }
}