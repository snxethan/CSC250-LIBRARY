package NEU.ET39.CSC250.DataStructures;

import NEU.ET39.CSC250.DataStructures.Nodes.Node_BST;

/**
 * Binary Search Tree (BST) implementation
 * This class provides methods to add, remove, and search for elements in the tree,
 * as well as methods to convert the tree to an array and string representation.
 *
 * @param <T> the type of elements in the tree, must be comparable
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private Node_BST<T> root;
    private int count;
    private int height;


    /**
     * The Binary Search Tree data structure
     * O(1)
     */
    public BinarySearchTree() {
        this.root = null;
        this.count = 0;
    }

    public int getHeight() {
        if (root == null) return 0;
        this.height = root.height();
        return height; // Return the height of the tree
    }





    public Node_BST<T> getRoot() {
        if(root == null) {
            return null; // Return null if the tree is empty
        }
        return root;
    }

    public void setRoot(Node_BST<T> root) {
        if(root == null) {
            throw new IllegalArgumentException("Root cannot be null");
        }
        this.root = root;
    }


    /**
     * Get the number of nodes in the binary search tree
     * @return the number of nodes
     */
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if(count < 0) {
            throw new IllegalArgumentException("Count cannot be negative");
        }
        if(count == 0) {
            root = null; // If count is 0, set root to null
        }
        this.count = count;
    }


    /**
     * Convert the binary search tree to an array
     * O(n)
     * @return an array containing the elements of the tree
     */
    public T[] toArray() {
        if (root == null) {
            // Use Object[].class and cast, or store the class of T elsewhere
            return (T[]) java.lang.reflect.Array.newInstance(Comparable.class, 0);
        }
        return root.toArray();
    }


    // toArray psuedocode
    // Function: toArray(node, array, index)
    // Purpose: Fills the array with the elements of the tree
    // Input: node (the current node), array (the array to fill), index (the current index in the array)
    // Output: index (the updated index)
    // if node is not null:
    // index = toArray(node.left, array, index) // Traverse left subtree
    // array[index++] = node.data // Add current node's data to the array
    // index = toArray(node.right, array, index) // Traverse right subtree
    // return index // Return the updated index

    /**
     * Recursively fill the array with the elements of the tree
     * O(n)
     * @param node the current node
     * @param array the array to fill
     * @param index the current index in the array
     * @return
     */
    private int toArrayRecursive(Node_BST<T> node, T[] array, int index) {
        if (node != null) {
            index = toArrayRecursive(node.getLeft(), array, index); // Traverse left subtree
            array[index++] = node.getData(); // Add current node's data to the array
            index = toArrayRecursive(node.getRight(), array, index); // Traverse right subtree
        }
        return index; // Return the updated index
    }

    /**
     * Convert the binary search tree to a string representation
     * @return a string representation of the tree
     */
    public String inOrder(){
        if (root == null) return "";
        return root.inOrder().trim();
    }


    // inOrder psuedocode
    // Function: inOrder(node, sb)
    // Purpose: Appends the elements of the tree to a string
    // Input: node (the current node), sb (the string builder to append to)
    // Output: sb (the updated string builder)
    // if node is not null:
    // inOrder(node.left, sb) // Traverse left subtree
    // sb.append(node.data) // Append current node's data to the string
    // inOrder(node.right, sb) // Traverse right subtree
    // return sb // Return the string builder

    /**
     * Convert the binary search tree to a string representation
     * @return a string representation of the tree
     */
    public String preOrder(){
        if (root == null) return "";
        return root.preOrder().trim();
    }

    // psuedo code for pre order
    // Function: preOrder(node, sb)
    // Purpose: Appends the elements of the tree to a string
    // Input: node (the current node), sb (the string builder to append to)
    // Output: sb (the updated string builder)
    // if node is not null:
    // sb.append(node.data) // Append current node's data to the string
    // preOrder(node.left, sb) // Traverse left subtree
    // preOrder(node.right, sb) // Traverse right subtree



    // psuedo code for post order
    // Function: postOrder(node, sb)
    // Purpose: Appends the elements of the tree to a string
    // Input: node (the current node), sb (the string builder to append to)
    // Output: sb (the updated string builder)
    // if node is not null:
    // postOrder(node.left, sb) // Traverse left subtree
    // postOrder(node.right, sb) // Traverse right subtree
    // sb.append(node.data) // Append current node's data to the string
    /**
     * Convert the binary search tree to a string representation
     * @return a string representation of the tree
     */
    public String postOrder(){
        if (root == null) return "";
        return root.postOrder().trim();
    }


    /**
     * Add a new value to the binary search tree
     * O(log n) average, O(n) worst
     * @param value the value to be added
     */
    public void add(T value) {
        if (root == null) {
            root = new Node_BST<>(value);
        } else {
            root.add(new Node_BST<>(value));
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
        if (root != null && root.contains(value)) {
            root.remove(value);
            count--;
        }
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


    /**
     * Check if a value exists in the binary search tree
     * @param value the value to check
     * @return true if the value exists, false otherwise
     */
    public boolean contains(T value){
        if (root == null) return false;
        return root.contains(value);
    }



}