package NEU.ET39.CSC250.DataStructures.Nodes;

public class Node_BST<T extends Comparable<T>> {
    private T data;
    private Node_BST<T> left;
    private Node_BST<T> right;

    public Node_BST(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node_BST<T> getLeft() {
        return left;
    }

    public void setLeft(Node_BST<T> left) {
        this.left = left;
    }

    public Node_BST<T> getRight() {
        return right;
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
}
