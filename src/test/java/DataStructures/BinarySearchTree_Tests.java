package DataStructures;

import NEU.ET39.CSC250.DataStructures.BinarySearchTree;
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
        bst.Add(10);
        assertEquals(1, bst.getCount());
    }

    @Test
    void testAddMultipleNodes() {
        bst.Add(10);
        bst.Add(5);
        bst.Add(15);
        bst.Add(7);
        assertEquals(4, bst.getCount());
    }

    @Test
    void testRemoveLeafNode() {
        bst.Add(10);
        bst.Add(5);
        bst.Add(15);
        bst.remove(5);
        assertEquals(2, bst.getCount());
    }

    @Test
    void testRemoveNodeWithOneChild() {
        bst.Add(10);
        bst.Add(5);
        bst.Add(3);
        bst.remove(5);
        assertEquals(2, bst.getCount());
    }

    @Test
    void testRemoveNodeWithTwoChildren() {
        bst.Add(10);
        bst.Add(5);
        bst.Add(15);
        bst.Add(13);
        bst.Add(17);
        bst.remove(15);
        assertEquals(4, bst.getCount());
    }

    @Test
    void testRemoveRoot() {
        bst.Add(10);
        bst.Add(5);
        bst.Add(15);
        bst.remove(10);  // root has two children
        assertEquals(2, bst.getCount());
    }

    @Test
    void testRemoveNonExistentValue() {
        bst.Add(10);
        bst.Add(5);
        bst.Add(15);
        bst.remove(99);  // should do nothing
        assertEquals(3, bst.getCount());
    }

    @Test
    void testClear() {
        bst.Add(10);
        bst.Add(5);
        bst.Add(15);
        bst.clear();
        assertEquals(0, bst.getCount());
    }

    @Test
    void testRemoveAll() {
        bst.Add(10);
        bst.Add(5);
        bst.Add(15);
        bst.remove(10);
        bst.remove(5);
        bst.remove(15);
        assertEquals(0, bst.getCount());
    }

}
