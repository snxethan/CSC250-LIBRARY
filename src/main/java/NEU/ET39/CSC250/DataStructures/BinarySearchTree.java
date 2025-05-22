package NEU.ET39.CSC250.DataStructures;

import NEU.ET39.CSC250.DataStructures.Nodes.Node_BST;

import java.lang.reflect.Array;

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
        if(root == null) {
            return 0;
        } else {
            // Calculate the height of the tree
            height = calculateHeight(root);
            return height;
        }
    }

    public void setHeight(int height) {
        if(root == null) {
            this.height = 0; // Set height to 0 if the tree is empty
        } else {
            this.height = calculateHeight(root);
        }
    }

    /**
     * Calculate the height of the tree recursively
     * O(n)
     * @param node the current node
     * @return the height of the tree
     */
    private int calculateHeight(Node_BST<T> node) {
        if(node == null) {
            return -1; // Return -1 for null nodes
        } else {
            int leftHeight = calculateHeight(node.getLeft());
            int rightHeight = calculateHeight(node.getRight());
            return Math.max(leftHeight, rightHeight) + 1; // Return the maximum height of the two subtrees
        }
    }
    // height psuedocode
    // Function: height(node)
    // Purpose: Calculates the height of the tree
    // Input: node (the current node)
    // Output: height of the tree
    // if node is null:
    // return -1
    // leftHeight = height(node.left)
    // rightHeight = height(node.right)
    // return max(leftHeight, rightHeight) + 1


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


    /**
     * Convert the binary search tree to an array
     * O(n)
     * @return an array containing the elements of the tree
     */
    public T[] toArray() {
        T[] array = (T[]) Array.newInstance(root.getData().getClass(), count); // Create a type-safe array
        toArrayRecursive(root, array, 0); // Fill the array recursively
        return array; // Return the filled array
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
        StringBuilder sb = new StringBuilder();
        inOrderRecursive(root, sb); // Start the in-order traversal
        if (sb.length() >= 2) {
            sb.setLength(sb.length() - 2); // Remove the trailing ", "
        }
        return sb.toString(); // Return the string representation
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
     * Recursively traverse the tree in-order and append the elements to a string
     * @param node the current node
     * @param sb the string builder to append to
     * @return the string builder
     */
    private StringBuilder inOrderRecursive(Node_BST<T> node, StringBuilder sb) {
        if (node != null) {
            inOrderRecursive(node.getLeft(), sb); // Traverse left subtree
            sb.append(node.getData()).append(", "); // Append current node's data to the string
            inOrderRecursive(node.getRight(), sb); // Traverse right subtree
        }
        return sb; // Return the string builder
    }

    /**
     * Convert the binary search tree to a string representation
     * @return a string representation of the tree
     */
    public String preOrder(){
        StringBuilder sb = new StringBuilder();
        preOrderRecursive(root, sb); // Start the pre-order traversal
        if (sb.length() >= 2) {
            sb.setLength(sb.length() - 2); // Remove the trailing ", "
        }
        return sb.toString(); // Return the string representation
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
    /**
     * Recursively traverse the tree pre-order and append the elements to a string
     * @param node the current node
     * @param sb the string builder to append to
     * @return the string builder
     */
    private StringBuilder preOrderRecursive(Node_BST<T> node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.getData()).append(", "); // Append current node's data to the string
            preOrderRecursive(node.getLeft(), sb); // Traverse left subtree
            preOrderRecursive(node.getRight(), sb); // Traverse right subtree
        }
        return sb; // Return the string builder
    }



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
    public String postOrder() {
        StringBuilder sb = new StringBuilder();
        postOrderRecursive(root, sb);
        if (sb.length() >= 2) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    /**
     * Recursively traverse the tree post-order and append the elements to a string
     * @param node the current node
     * @param sb the string builder to append to
     * @return the string builder
     */

    private StringBuilder postOrderRecursive(Node_BST<T> node, StringBuilder sb) {
        if (node != null) {
            postOrderRecursive(node.getLeft(), sb); // Traverse left subtree
            postOrderRecursive(node.getRight(), sb); // Traverse right subtree
            sb.append(node.getData()).append(", "); // Append current node's data to the string
        }
        return sb; // Return the string builder
    }


    /**
     * Add a new value to the binary search tree
     * O(log n) average, O(n) worst
     * @param value the value to be added
     */
    public void add(T value) {
        Node_BST<T> newNode = new Node_BST<>(value); // Create a new node with the value
        if (root == null) { // If the tree is empty
            root = newNode; // Set root to the new node
        } else {
            addRecursive(root, newNode); // Recursively add the new node
        }
        count++; // Increment the count of nodes
    }

    /**
     * Recursively add a new node to the binary search tree
     * O(log n) average, O(n) worst
     * @param current the current node in the recursive loop, starting from the root
     * @param newNode the new node to be added
     */
    private void addRecursive(Node_BST<T> current, Node_BST<T> newNode) {
        if (newNode.getData().compareTo(current.getData()) < 0) { // Compare the new node's value with the current node's value
            if (current.getLeft() == null) {
                current.setLeft(newNode); // If the left child is null, set it to the new node
            } else {
                addRecursive(current.getLeft(), newNode); // Recursively add to the left subtree
            }
        } else {
            if (current.getRight() == null) {
                current.setRight(newNode); // If the right child is null, set it to the new node
            } else {
                addRecursive(current.getRight(), newNode); // Recursively add to the right subtree
            }
        }
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
        if(contains(value)){
            root = removeRecursive(root, value); // O(log n)
        }
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
        // if the current node is null, return null
        if (current == null) {
            return current;
        }

        // If the value to be deleted is less than the current node's data,
        if (value.compareTo(current.getData()) < 0) {
            // search in the left subtree
            current.setLeft(removeRecursive(current.getLeft(), value)); // O(log n)
        } else if (value.compareTo(current.getData()) > 0) { // If the value is greater,
            // search in the right subtree
            current.setRight(removeRecursive(current.getRight(), value)); // O(log n)
        } else {
            // three cases for current node

            // Case 1: Node with no children (leaf node)
            // Found the node to be deleted
            // If the node has no children (leaf node)
            if (current.getLeft() == null && current.getRight() == null) {
                count--;
                return null; // Remove the node
            }

            // Case 2: Node with one child
            // If the node has one child
            // check which child is null
            if (current.getLeft() == null) {
                count--;
                return current.getRight();
            } else if (current.getRight() == null) {
                count--;
                return current.getLeft();
            }

            // Case 3: Node with two children
            // If the node has two children
            // Find the inorder successor (smallest in the right subtree)
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
        Node_BST<T> newNode = new Node_BST<>(value); // Create a new node with the value
        if (root == null) { // If the tree is empty
            return false;
        }
        return containsRecursive(root, newNode); // Recursively add the new node
    }

    /**
     * Recursively check if a value exists in the binary search tree
     * @param current the current node in the recursive loop, starting from the root
     * @param newNode the new node to be checked
     * @return true if the value exists, false otherwise
     */
    private boolean containsRecursive(Node_BST<T> current, Node_BST<T> newNode) {
        if (current == null) {
            return false; // Base case: value not found
        }

        if (newNode.getData().compareTo(current.getData()) < 0) {
            return containsRecursive(current.getLeft(), newNode); // Search in the left subtree
        } else if (newNode.getData().compareTo(current.getData()) > 0) {
            return containsRecursive(current.getRight(), newNode); // Search in the right subtree
        } else {
            return true; // Value found
        }
    }


}