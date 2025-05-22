package DataStructures;

import NEU.ET39.CSC250.DataStructures.BinarySearchTree;
import NEU.ET39.CSC250.DataStructures.Nodes.Node_BST;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTree_Tests {
    private BinarySearchTree<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    void testAddSingleNode() {
        bst.add(10);
        assertEquals(1, bst.getCount());
    }

    @Test
    void testAddMultipleNodes() {
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(7);
        assertEquals(4, bst.getCount());
    }

    @Test
    void testRemoveLeafNode() {
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.remove(5);
        assertEquals(2, bst.getCount());
    }

    @Test
    void testRemoveNodeWithOneChild() {
        bst.add(10);
        bst.add(5);
        bst.add(3);
        bst.remove(5);
        assertEquals(2, bst.getCount());
    }

    @Test
    void testRemoveNodeWithTwoChildren() {
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(13);
        bst.add(17);
        bst.remove(15);
        assertEquals(4, bst.getCount());
    }

    @Test
    void testRemoveRoot() {
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.remove(10);  // root has two children
        assertEquals(2, bst.getCount());
    }

    @Test
    void testRemoveNonExistentValue() {
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.remove(99);  // should do nothing
        assertEquals(3, bst.getCount());
    }

    @Test
    void testClear() {
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.clear();
        assertEquals(0, bst.getCount());
    }

    @Test
    void testRemoveAll() {
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.remove(10);
        bst.remove(5);
        bst.remove(15);
        assertEquals(0, bst.getCount());
    }

    @Test
    void testContains() {
        bst.add(10);
        bst.add(5);
        bst.add(15);
        assertEquals(true, bst.contains(10));
        assertEquals(false, bst.contains(20));
    }

    @Test
    void testInOrder() {
        bst.add(10);
        bst.add(5);
        bst.add(15);
        assertEquals("5, 10, 15", bst.inOrder().toString());
    }

    @Test
    void testPreOrder() {
        bst.add(10);
        bst.add(5);
        bst.add(15);
        assertEquals("10, 5, 15", bst.preOrder().toString());
    }

    @Test
    void testPostOrder() {
        bst.add(10);
        bst.add(5);
        bst.add(15);
        assertEquals("5, 15, 10", bst.postOrder().toString());
    }

    @Test
    void testToArray() {
        bst.add(10);
        bst.add(5);
        bst.add(15);
        Integer[] expected = {5, 10, 15};
        assertEquals(expected, bst.toArray());
    }

    @Test
    void testGetHeight() {
        bst.add(10);
        bst.add(5);
        bst.add(15);
        assertEquals(1, bst.getHeight());

        bst.add(3);
        assertEquals(2, bst.getHeight());

        bst.add(7);
        assertEquals(2, bst.getHeight());

        bst.add(13);
        assertEquals(2, bst.getHeight());

        bst.add(17);
        assertEquals(2, bst.getHeight());
    }

    @Test
    void testGetHeight2(){
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);
        bst.add(13);
        bst.add(17);
        bst.add(18);
        assertEquals(3, bst.getHeight());
        bst.add(20);
        assertEquals(4, bst.getHeight());
        bst.add(25);
        assertEquals(5, bst.getHeight());
    }







}
