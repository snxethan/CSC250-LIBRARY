package NEU.ET39.CSC250.DataStructures.Nodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Node class for AVL Tree
 * This class represents a node in an AVL tree, which is a self-balancing binary search tree.
 * It contains methods for adding, removing, and searching for elements, as well as methods for traversals.
 *
 * @param <T> the type of elements in the tree, must be comparable
 */
public class Node_AVL<T extends Comparable<T>> {

    private T data;
    private Node_AVL<T> left;
    private Node_AVL<T> right;
    private int height;

    /**
     * The AVL Tree Node data structure
     * O(1)
     */
    public Node_AVL(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 0; // Height of a new node is 0
    }

    /**
     * Returns the balance factor of the node.
     * The balance factor is defined as the height of the left subtree minus the height of the right subtree.
     * @return The balance factor.
     * O(1)
     */
    public int getBalanceFactor() {
        // The balance factor is calculated as the height of the left subtree minus the height of the right subtree
        // If the left or right child is null, we consider its height as -1
        int leftHeight = (getLeft() != null) ? getLeft().height() : -1;
        int rightHeight = (getRight() != null) ? getRight().height() : -1;
        return leftHeight - rightHeight;
    }

    // psuedo code for getBalanceFactor:
    // input : the current node
    // output: the balance factor of the current node
    // if the current node is not null:
    //     leftHeight = currentNode.left.height() or -1 if left is null
    //     rightHeight = currentNode.right.height() or -1 if right is null
    //     return leftHeight - rightHeight



    public T getData() {
        return data;
    }


    public Node_AVL<T> getLeft() {
        return left;
    }


    public Node_AVL<T> getRight() {
        return right;
    }

    public void setLeft(Node_AVL<T> left) {
        this.left = left;
    }

    public void setRight(Node_AVL<T> right) {
        this.right = right;
    }


    /**
     * Inserts a value into the subtree rooted at this node.
     * @param newNode The node to insert.
     * O(log n) average, O(n) worst
     */
    public Node_AVL<T> add(Node_AVL<T> newNode) {
        // check if node equals the node to be added
        if (newNode.getData().compareTo(this.data) == 0) {
            return this; // No duplicates allowed in AVL tree
        }
        if (newNode.getData().compareTo(this.data) < 0) {
            if (this.left == null) {
                this.left = newNode;
            } else {
                this.left = this.left.add(newNode);
            }
        } else {
            if (this.right == null) {
                this.right = newNode;
            } else {
                this.right = this.right.add(newNode);
            }
        }
        return balance();
    }

    /**
     * Removes a value from the subtree rooted at this node.
     * @param value The value to remove.
     * O(log n) average, O(n) worst
     */
    public Node_AVL<T> remove(T value) {
        if (value.compareTo(this.data) < 0) {
            if (this.left != null) {
                this.left = this.left.remove(value);
            }
        } else if (value.compareTo(this.data) > 0) {
            if (this.right != null) {
                this.right = this.right.remove(value);
            }
        } else {
            if (this.left == null) {
                return this.right;
            } else if (this.right == null) {
                return this.left;
            } else {
                Node_AVL<T> successor = this.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                this.data = successor.data;
                this.right = this.right.remove(successor.data);
            }
        }
        return balance();
    }

    /**
     * returns if the value exists in the subtree rooted at this node.
     * @param value The value to search for.
     *              O(log n) average, O(n) worst
     */
    public boolean contains(T value) {
        if (value.compareTo(this.data) == 0) {
            return true;
        } else if (value.compareTo(this.data) < 0) {
            return (left != null) && left.contains(value);
        } else {
            return (right != null) && right.contains(value);
        }
    }

    /**
     * Returns the height of the subtree rooted at this node.
     * @return The height of the subtree.
     * O(n)
     */
    public int height() {
        int leftHeight = (left != null) ? left.height() : -1;
        int rightHeight = (right != null) ? right.height() : -1;
        this.height = Math.max(leftHeight, rightHeight) + 1;
        return this.height;
    }

    /**
     * Returns the string array representation of the subtree rooted at this node.
     * Breadth-first traversal.
     * Parent Node > Left Child Node > Right Child Node
     * @return The string array representation.
     * O(n)
     */
    public T[] toArray() {
        List<T> list = new ArrayList<>(); // Use ArrayList to hold the values
        Queue<Node_AVL<T>> queue = new LinkedList<>(); // Use LinkedList as a queue for BFS traversal
        queue.add(this); // Start with the root node

        // Perform a breadth-first traversal
        // while the queue is not empty, poll the front node, add its data to the list,
        // and enqueue its left and right children if they exist.

        // loop through the queue until it is empty
        while (!queue.isEmpty()) {
            Node_AVL<T> current = queue.poll(); // get the front node from the queue
            list.add(current.getData()); // add the data of the current node to the list

            // if the current node has left or right children, add them to the queue
            if (current.getLeft() != null) {
                queue.add(current.getLeft());  // add left child to the queue
            }
            if (current.getRight() != null) {
                queue.add(current.getRight()); // add right child to the queue
            }
        }

        // Convert the list to an array of type T
        T[] array = (T[]) java.lang.reflect.Array.newInstance(this.getData().getClass(), list.size());
        return list.toArray(array);
    }


//    toArray : psuedocode
//    have a list/queue to hold all values
//    rootNode.add

//    leftChildNode.add
//    rightChildNode.add
//
//    traverse leftChildNode
//    traverse rightChildNode
//    recursive method to return
//
//    public List toArray(){
//        List array = new List;
//        array.add(this)
//        toArrayHelper(this, array);
//    }
//
//    public List toArrayHelper(Node, List){
//        list.add(Node.smallerChild)
//        list.add(Node.greaterChild)
//        if(null == null){
//            return null;
//            toArrayHelper(Node.smallerChild, list);
//            toArrayHelper(Node.greaterChild, list);



    /**
     * Returns the in order traversal of the subtree rooted at this node.
     * @return The in order traversal.
     * O(n)
     */
    public String inOrder() {
        java.util.List<String> result = new java.util.ArrayList<>();
        inOrderHelper(this, result);
        return String.join(", ", result);
    }

    private void inOrderHelper(Node_AVL<T> node, java.util.List<String> result) {
        if (node == null) return;
        inOrderHelper(node.left, result);
        result.add(node.data.toString());
        inOrderHelper(node.right, result);
    }

    /**
     * Returns the pre order traversal of the subtree rooted at this node.
     * @return The pre order traversal.
     * O(n)
     */
    public String preOrder() {
        java.util.List<String> result = new java.util.ArrayList<>();
        preOrderHelper(this, result);
        return String.join(", ", result);
    }


    private void preOrderHelper(Node_AVL<T> node, java.util.List<String> result) {
        if (node == null) return;
        result.add(node.data.toString());
        preOrderHelper(node.left, result);
        preOrderHelper(node.right, result);
    }

    /**
     * Returns the post order traversal of the subtree rooted at this node.
     * @return The post order traversal.
     * O(n)
     */
    public String postOrder() {
        java.util.List<String> result = new java.util.ArrayList<>();
        postOrderHelper(this, result);
        return String.join(", ", result);
    }

    private void postOrderHelper(Node_AVL<T> node, java.util.List<String> result) {
        if (node == null) return;
        postOrderHelper(node.left, result);
        postOrderHelper(node.right, result);
        result.add(node.data.toString());
    }


    /**
     * Balances the AVL tree rooted at this node.
     * This method checks the balance factor and performs rotations if necessary.
     * @return The new root of the balanced subtree.
     * O(log n) average, O(n) worst
     */
    public Node_AVL balance(){
        // This method should implement the balancing logic for AVL trees
        // there are 4 different cases to consider:
        // 1. Left Left Case
        // 2. Right Right Case
        // 3. Left Right Case
        // 4. Right Left Case

        // Check the balance factor of the current node (left - right)
        // rotate the opposite direction of the taller subtree e.g. (left subtree is taller, rotate right)
        // If the balance factor is greater than 1, it means the left subtree is taller
        if (getBalanceFactor() > 1) {
            // If the left child has a balance factor less than 0, it means it's a left-right case
            if (getLeft() != null && getLeft().getBalanceFactor() < 0) {
                setLeft(rotateLeft(getLeft())); // Left-right case
            }
            return rotateRight(this); // Left-left case
            // If the balance factor is less than -1, it means the right subtree is taller
        } else if (getBalanceFactor() < -1) {
            // If the right child has a balance factor greater than 0, it means it's a right-left case
            if (getRight() != null && getRight().getBalanceFactor() > 0) {
                setRight(rotateRight(getRight())); // Right-left case
            }
            return rotateLeft(this); // Right-right case
        }
        return this;
    }



    /**
     * Performs a right rotation on the subtree rooted at the given node.
     * This is used to balance the tree when the left subtree is taller than the right subtree.
     * * Right rotation is performed when the left child is taller than the right child.
     * @param node the node to rotate right
     * @return the new root of the subtree after rotation
     */
    public Node_AVL<T> rotateRight(Node_AVL<T> node) {
        if (node == null || node.getLeft() == null) return node;
        Node_AVL<T> newRoot = node.getLeft(); // set a new node/root to the left (smaller) child
        node.setLeft(newRoot.getRight()); // set the left child of the input node to the right child of the new root
        newRoot.setRight(node); // set the right child of the new root to the input node
        return newRoot;
    }

    // psuedo code for rotating right:
    // input : node (the node to rotate right)
    // output: newRoot (the new root of the subtree after rotation)
    // if input node is not null:
    //     newRoot = node.smallerChild
    //     node.smallerChild = newRoot.greaterChild -- to prevent NPE
    //     newRoot.greaterChild = node
    //     node.setBalanceFactor() - update the balance factor from that node (and determine if it is balanced)
    //     newRoot.setBalanceFactor() - update the balance factor from that node (and determine if it is balanced)
    //   return newRoot


    /**
     * Performs a left rotation on the subtree rooted at the given node.
     * This is used to balance the tree when the right subtree is taller than the left subtree.
     * * Left rotation is performed when the right child is taller than the left child.
     * @param node the node to rotate left
     * @return the new root of the subtree after rotation
     */
    public Node_AVL<T> rotateLeft(Node_AVL<T> node) {
        if (node == null || node.getRight() == null) return node;
        Node_AVL<T> newRoot = node.getRight(); // set a new node/root to the right (greater) child
        node.setRight(newRoot.getLeft()); // set the right child of the input node to the left child of the new root
        newRoot.setLeft(node); // set the left child of the new root to the input node
        return newRoot;
    }

    // psuedo code for rotating left:
    // input : node (the node to rotate left)
    // output: newRoot (the new root of the subtree after rotation)
    // if input node is not null:
    //     newRoot = node.greaterChild
    //     node.greaterChild = newRoot.smallerChild
    //     newRoot.smallerChild = node
    //     node.setBalanceFactor() - update the balance factor from that node (and determine if it is balanced)
    //     newRoot.setBalanceFactor() - update the balance factor from that node (and determine if it is balanced)
    //    return newRoot
    
}