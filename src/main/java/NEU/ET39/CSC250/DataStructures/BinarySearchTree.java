package NEU.ET39.CSC250.DataStructures;

import NEU.ET39.CSC250.DataStructures.Nodes.Node_BST;

public class BinarySearchTree<T extends Comparable<T>> {
    Node_BST<T> root;
    int count;

    /**
     * The Binary Search Tree data structure
     * O(1)
     */
    public BinarySearchTree() {
        this.root = null;
        this.count = 0;
    }


    /**
     * Add to the tree with a specific value
     * @param value the value you want to represent as a node.
     * O(log n) average, O(n) worst
     */
    public void Add(T value){
        Node_BST<T> newNode = new Node_BST<>(value);
        if (root == null) {
            root = newNode;
        } else {
            root.add(newNode);
        }
        count++;
    }


    /**
     * Clear the nodes and reset the count
     */
    public void clear(){
        root = null;
        count = 0;
    }

    /**
     * remove a specific value from the binary search tree.
     * @param value the value you want to remove.
     */
    public void remove(T value) {
        root = removeRecursive(root, value); // O(log n)
    }

    /**
     * recursively loop through and remove a specific value/node
     * if the value exists, shift up nodes in the congruent order of the next possible node
     * @param current the current node in the recursive loop, starting from the root
     * @param value the value you want to remove.
     * @return the current node checked, to be recursed until no children / only 1 child.
     * O(log n)
     */
    private Node_BST<T> removeRecursive(Node_BST<T> current, T value) {

        //best case
        if (current == null) {
            return current;
        }

        if (value.compareTo(current.getData()) < 0) {
            current.setLeft(removeRecursive(current.getLeft(), value)); // O(log n)
        } else if (value.compareTo(current.getData()) > 0) {
            current.setRight(removeRecursive(current.getRight(), value)); // O(log n)
        } else {
            // Node with only one child or no child
            if (current.getLeft() == null) {
                count--;
                return current.getRight();
            } else if (current.getRight() == null) {
                count--;
                return current.getLeft();
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            T temp = findMin(current.getRight());

            // Copy the inorder successor's content to this node
            current.setData(temp);

            // Delete the inorder successor
            current.setRight(removeRecursive(current.getRight(), temp)); // O(log n)
        }
        return current;
    }

    /**
     * Find the smallest node in a given branch
     * @param current the node you are at
     * @return
     * O(log n)
     */
    private T findMin(Node_BST<T> current) {
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current.getData();
    }

    public int getCount(){
        return count;
    }


// Pseudocode for removeRecursive()

// Function: removeRecursive(currentNode, value)
// Purpose: Recursively removes a node with the given value from the BST
// Input: currentNode (starting node), value (value to delete)
// Output: returns the updated subtree

//if currentNode is null:
//            return null
//
//            if value < currentNode.data:
//    currentNode.left = removeRecursive(currentNode.left, value)

//else if value > currentNode.data:
//    currentNode.right = removeRecursive(currentNode.right, value)

//else:
//        // Found the node to remove
//
//        if currentNode.left is null:
//    decrement count
//        return currentNode.right

//    else if currentNode.right is null:
//    decrement count
//        return currentNode.left
//
//            // Node has two children
//            successorValue = findMin(currentNode.right)
//    currentNode.data = successorValue
//    currentNode.right = removeRecursive(currentNode.right, successorValue)
//
//return currentNode

}