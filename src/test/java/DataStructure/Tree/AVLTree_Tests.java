package DataStructure.Tree;

import NEU.ET39.CSC250.DataStructure.Tree.AVLTree;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AVLTree_Tests {
    //Include all tests from your Binary Search Tree as well as...
    //Write 1 additional test per rotation (4 total) to validate it rotates correctly.
    //Write 2 tests against your ToArray() to validate the Breadth First approach works
    //Should be at least 26 tests.  (20 avl, 4 for Rotation, 2 for ToArray)

    private AVLTree<Integer> avl;

    @BeforeEach
    void setUp() {
        avl = new AVLTree<>();
    }

    @org.junit.jupiter.api.Test
    void testAddSingleNode() {
        avl.add(10);
        assertEquals(1, avl.getCount());
    }

    @org.junit.jupiter.api.Test
    void testAddMultipleNodes() {
        avl.add(10);
        avl.add(5);
        avl.add(15);
        avl.add(7);
        assertEquals(4, avl.getCount());
    }

    @org.junit.jupiter.api.Test
    void testRemoveLeafNode() {
        avl.add(10);
        avl.add(5);
        avl.add(15);
        avl.remove(5);
        assertEquals(2, avl.getCount());
    }

    @org.junit.jupiter.api.Test
    void testRemoveNodeWithOneChild() {
        avl.add(10);
        avl.add(5);
        avl.add(3);
        avl.remove(5);
        assertEquals(2, avl.getCount());
    }

    @org.junit.jupiter.api.Test
    void testRemoveNodeWithTwoChildren() {
        avl.add(10);
        avl.add(5);
        avl.add(15);
        avl.add(13);
        avl.add(17);
        avl.remove(15);
        assertEquals(4, avl.getCount());
    }

    @org.junit.jupiter.api.Test
    void testRemoveRoot() {
        avl.add(10);
        avl.add(5);
        avl.add(15);
        avl.remove(10);  // root has two children
        assertEquals(2, avl.getCount());
    }

    @org.junit.jupiter.api.Test
    void testRemoveNonExistentValue() {
        avl.add(10);
        avl.add(5);
        avl.add(15);
        avl.remove(99);  // should do nothing
        assertEquals(3, avl.getCount());
    }

    @org.junit.jupiter.api.Test
    void testClear() {
        avl.add(10);
        avl.add(5);
        avl.add(15);
        avl.clear();
        assertEquals(0, avl.getCount());
    }

    @org.junit.jupiter.api.Test
    void testRemoveAll() {
        avl.add(10);
        avl.add(5);
        avl.add(15);
        avl.remove(10);
        avl.remove(5);
        avl.remove(15);
        assertEquals(0, avl.getCount());
    }

    @org.junit.jupiter.api.Test
    void testContains() {
        avl.add(10);
        avl.add(5);
        avl.add(15);
        assertEquals(true, avl.contains(10));
        assertEquals(false, avl.contains(20));
    }

    @org.junit.jupiter.api.Test
    void testInOrder() {
        avl.add(10);
        avl.add(5);
        avl.add(15);
        assertEquals("5, 10, 15", avl.inOrder().toString());
    }

    @org.junit.jupiter.api.Test
    void testPreOrder() {
        avl.add(10);
        avl.add(5);
        avl.add(15);
        assertEquals("10, 5, 15", avl.preOrder().toString());
    }

    @org.junit.jupiter.api.Test
    void testPostOrder() {
        avl.add(10);
        avl.add(5);
        avl.add(15);
        assertEquals("5, 15, 10", avl.postOrder().toString());
    }


    @org.junit.jupiter.api.Test
    void testGetHeight() {
        avl.add(10);
        avl.add(5);
        avl.add(15);
        assertEquals(1, avl.getHeight());

        avl.add(3);
        assertEquals(2, avl.getHeight());

        avl.add(7);
        assertEquals(2, avl.getHeight());

        avl.add(13);
        assertEquals(2, avl.getHeight());

        avl.add(17);
        assertEquals(2, avl.getHeight());
    }

    @org.junit.jupiter.api.Test
    void testGetHeight2(){
        avl.add(10);
        avl.add(5);
        avl.add(15);
        avl.add(3);
        avl.add(7);
        avl.add(13);
        avl.add(17);
        avl.add(18);
        assertEquals(3, avl.getHeight());
        System.out.println("toArray: " + Arrays.toString(avl.toArray()));
        avl.add(20);
        System.out.println("toArray after adding 20: " + Arrays.toString(avl.toArray()));
        assertEquals(3, avl.getHeight());
        avl.add(25);
        System.out.println("toArray after adding 25: " + Arrays.toString(avl.toArray()));
        assertEquals(3,avl.getHeight());
    }

        @org.junit.jupiter.api.Test
    public void testAddAndContains() {
        avl.add(10);
        avl.add(20);
        avl.add(30);
        assert avl.contains(10) : "AVL should contain 10";
        assert avl.contains(20) : "AVL should contain 20";
        assert avl.contains(30) : "AVL should contain 30";
        assert !avl.contains(40) : "AVL should not contain 40";
    }

        @org.junit.jupiter.api.Test
    public void testRemove() {
        avl.add(10);
        avl.add(20);
        avl.add(30);
        avl.remove(20);
        assert !avl.contains(20) : "AVL should not contain 20 after removal";
        assert avl.contains(10) : "AVL should still contain 10";
        assert avl.contains(30) : "AVL should still contain 30";
    }

        @org.junit.jupiter.api.Test
    public void testLeftRotation() {
        avl.add(30);
        avl.add(20);
        avl.add(10); // This should trigger a left rotation
        assert avl.getRoot().getData() == 20 : "Root should be 20 after left rotation";
        assert avl.getRoot().getLeft().getData() == 10 : "Left child should be 10";
        assert avl.getRoot().getRight().getData() == 30 : "Right child should be 30";
    }


        @org.junit.jupiter.api.Test
    public void testRightRotation() {
        avl.add(10);
        avl.add(20);
        avl.add(30); // This should trigger a right rotation
        assert avl.getRoot().getData() == 20 : "Root should be 20 after right rotation";
        assert avl.getRoot().getLeft().getData() == 10 : "Left child should be 10";
        assert avl.getRoot().getRight().getData() == 30 : "Right child should be 30";
    }

        @org.junit.jupiter.api.Test
    public void testLeftRightRotation() {
        avl.add(30);
        avl.add(10);
        avl.add(20); // This should trigger a left-right rotation
        assert avl.getRoot().getData() == 20 : "Root should be 20 after left-right rotation";
        assert avl.getRoot().getLeft().getData() == 10 : "Left child should be 10";
        assert avl.getRoot().getRight().getData() == 30 : "Right child should be 30";
    }

        @org.junit.jupiter.api.Test
    public void testRightLeftRotation() {
        avl.add(10);
        avl.add(30);
        avl.add(20); // This should trigger a right-left rotation
        assert avl.getRoot().getData() == 20 : "Root should be 20 after right-left rotation";
        assert avl.getRoot().getLeft().getData() == 10 : "Left child should be 10";
        assert avl.getRoot().getRight().getData() == 30 : "Right child should be 30";
    }



        @org.junit.jupiter.api.Test
    public void testEquivalentToArray() {
        avl.add(10);
        avl.add(20);
        avl.add(20);
        System.out.println("To Array: " + Arrays.toString(avl.toArray()));
        Integer[] expectedArray = {10, 20};
        assert Arrays.equals(avl.toArray(), expectedArray) : "ToArray should return the correct array representation";
    }


        @org.junit.jupiter.api.Test
    public void testToArray(){
        avl.add(11);
        avl.add(10);
        avl.add(24);
        avl.add(13);
        avl.add(56);
        Integer[] expectedArray = {11, 10, 24, 13, 56};
        assert Arrays.equals(avl.toArray(), expectedArray) : "ToArray should return the correct array representation";
    }

        @org.junit.jupiter.api.Test
    public void testToArrayEmpty() {
        Integer[] expectedArray = {};
        assert Arrays.equals(avl.toArray(), expectedArray) : "ToArray should return an empty array for an empty AVL tree";
    }

        @org.junit.jupiter.api.Test
    public void testToArray2(){
        avl.add(5);
        avl.add(3);
        avl.add(7);
        avl.add(2);
        avl.add(4);
        avl.add(6);
        avl.add(8);
        Integer[] expectedArray = {5, 3, 7, 2, 4, 6, 8};
        assert Arrays.equals(avl.toArray(), expectedArray) : "ToArray should return the correct array representation in BFS order";
    }
}
