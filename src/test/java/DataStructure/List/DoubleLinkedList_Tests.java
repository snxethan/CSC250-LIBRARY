package DataStructure.List;

import NEU.ET39.CSC250.DataStructure.List.DoubleLinkedList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DoubleLinkedList_Tests {

    @Test
    public void testCount() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(3, list.getCount());
    }

    @Test
    public void testEmptyCount() {
        DoubleLinkedList list = new DoubleLinkedList();
        Assertions.assertEquals(0, list.getCount());
    }

    @Test
    public void testAddToHead() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        Assertions.assertEquals(2, list.getCount());
        Assertions.assertEquals(1, list.getHead());
    }

    @Test
    public void testAddToHeadMultiple() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(3, list.getCount());
        Assertions.assertEquals(1, list.getHead());
    }

    @Test
    public void testAddToTail() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        Assertions.assertEquals(2, list.getCount());
        Assertions.assertEquals(2, list.getTail());
    }

    @Test
    public void testAddToTailMultiple() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(3, list.getCount());
        Assertions.assertEquals(3, list.getTail());
    }

    @Test
    public void testRemoveHead() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        list.removeFirst();
        Assertions.assertEquals(1, list.getCount());
    }

    @Test
    public void testRemoveTail() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        list.removeLast();
        Assertions.assertEquals(1, list.getCount());
        Assertions.assertEquals(1, list.getTail());
    }

    @Test
    public void testInsertAt() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(3);
        list.insert(2, 1);
        Assertions.assertEquals(3, list.getCount());
        Assertions.assertEquals(2, list.get(1));
    }

    @Test
    public void testInsertAtInvalidIndex() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.insert(3, 5), "Invalid index");
    }

    @Test
    public void testRemoveAt() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeAt(1);
        Assertions.assertEquals(2, list.getCount());
        Assertions.assertEquals(3, list.get(1));
    }

    @Test
    public void testRemoveAtInvalidIndex() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(5), "Invalid index");
    }

    @Test
    public void removeTail(){
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        list.removeLast();
        Assertions.assertEquals(1, list.getCount());
        Assertions.assertEquals(1, list.getTail());
    }

    @Test
    public void removeTailEmpty(){
        DoubleLinkedList list = new DoubleLinkedList();
        Assertions.assertThrows(IllegalStateException.class, () -> list.removeLast(), "Invalid index");
    }

    @Test
    public void removeHead(){
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        list.removeFirst();
        Assertions.assertEquals(1, list.getCount());
        Assertions.assertEquals(2, list.getHead());
    }

    @Test
    public void removeHeadEmpty(){
        DoubleLinkedList list = new DoubleLinkedList();
        Assertions.assertThrows(IllegalStateException.class, () -> list.removeFirst(), "Invalid index");
    }


    @Test
    public void testClear() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        list.clear();
        Assertions.assertEquals(0, list.getCount());
        Assertions.assertNull(list.getHead());
        Assertions.assertNull(list.getTail());
    }

    @Test
    public void testClearEmpty() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.clear();
        Assertions.assertEquals(0, list.getCount());
        Assertions.assertNull(list.getHead());
        Assertions.assertNull(list.getTail());
    }

    @Test
    public void testToString() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals("1 <> 2 <> 3 <>", list.toString());
    }

    @Test
    public void testToStringEmpty() {
        DoubleLinkedList list = new DoubleLinkedList();
        Assertions.assertEquals("Empty list", list.toString());
    }
}