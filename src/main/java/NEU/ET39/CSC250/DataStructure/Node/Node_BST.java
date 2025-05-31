package NEU.ET39.CSC250.DataStructure.Node;

public class Node_BST<T extends Comparable<T>> {
    private T data;
    private Node_BST<T> left;
    private Node_BST<T> right;
    private int height;

    public Node_BST(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 0; // Height of a new node is 0
    }

    public T getData() {
        return data;
    }


    public Node_BST<T> getLeft() {
        return left;
    }


    public Node_BST<T> getRight() {
        return right;
    }

    public void setLeft(Node_BST<T> left) {
        this.left = left;
    }

    public void setRight(Node_BST<T> right) {
        this.right = right;
    }


    /**
     * Inserts a value into the subtree rooted at this node.
     * @param newNode The node to insert.
     * O(log n) average, O(n) worst
     */
    public void add(Node_BST<T> newNode) {
        if (newNode.getData().compareTo(this.data) < 0) {
            if (this.left == null) {
                this.left = newNode;
            } else {
                this.left.add(newNode);
            }
        } else {
            if (this.right == null) {
                this.right = newNode;
            } else {
                this.right.add(newNode);
            }
        }
    }

    /**
     * Removes a value from the subtree rooted at this node.
     * @param value The value to remove.
     * O(log n) average, O(n) worst
     */
    public Node_BST<T> remove(T value) {
        if (value.compareTo(this.data) < 0) {
            if (this.left != null) {
                this.left = this.left.remove(value);
            }
        } else if (value.compareTo(this.data) > 0) {
            if (this.right != null) {
                this.right = this.right.remove(value);
            }
        } else {
            // Node to remove found
            if (this.left == null) {
                return this.right;
            } else if (this.right == null) {
                return this.left;
            } else {
                // Node with two children: get the in-order successor
                Node_BST<T> successor = this.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                // Copy successor's data to this node
                this.data = successor.data;
                // Remove successor node
                this.right = this.right.remove(successor.data);
            }
        }
        return this;
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
     * @return The string array representation.
     * O(n)
     */
    public T[] toArray() {
        java.util.List<T> list = new java.util.ArrayList<>();
        toArrayHelper(this, list);
        T[] array = (T[]) java.lang.reflect.Array.newInstance(data.getClass(), list.size());
        return list.toArray(array);
    }


    private void toArrayHelper(Node_BST<T> node, java.util.List<T> list) {
        if (node == null) {
            return;
        }
        toArrayHelper(node.getLeft(), list);
        list.add(node.getData());
        toArrayHelper(node.getRight(), list);
    }


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

    private void inOrderHelper(Node_BST<T> node, java.util.List<String> result) {
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


    private void preOrderHelper(Node_BST<T> node, java.util.List<String> result) {
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

    private void postOrderHelper(Node_BST<T> node, java.util.List<String> result) {
        if (node == null) return;
        postOrderHelper(node.left, result);
        postOrderHelper(node.right, result);
        result.add(node.data.toString());
    }
}
