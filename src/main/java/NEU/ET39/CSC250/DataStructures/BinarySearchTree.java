package NEU.ET39.CSC250.DataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
    Node_DLL<T> root;
    int count;

    public BinarySearchTree() {
        this.root = null;
        this.count = 0;
    }

//    public Node_DLL<T> getRoot() {
//        return root;
//    }
//
//    public void setRoot(Node_DLL<T> root) {
//        this.root = root;
//    }
//
//    public int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//        if (count < 0) {
//            throw new IllegalArgumentException("Count cannot be negative");
//        }
//        this.count = count;
//    }
//
//    public void add(T value) {
//        Node_DLL<T> newNode = new Node_DLL<>(value);
//        if (root == null) {
//            root = newNode;
//        } else {
//            addRecursive(root, newNode);
//        }
//        count++;
//    }
//
//    private void addRecursive(Node_DLL<T> current, Node_DLL<T> newNode) {
//        if (newNode.getData().compareTo(current.getData()) < 0) {
//            if (current.getPrev() == null) {
//                current.setPrev(newNode);
//            } else {
//                addRecursive(current.getPrev(), newNode);
//            }
//        } else {
//            if (current.getNext() == null) {
//                current.setNext(newNode);
//            } else {
//                addRecursive(current.getNext(), newNode);
//            }
//        }
//    }
//
//    public boolean contains(T value) {
//        return containsRecursive(root, value);
//    }
//
//    private boolean containsRecursive(Node_DLL<T> current, T value) {
//        if (current == null) {
//            return false;
//        }
//        if (value.compareTo(current.getData()) == 0) {
//            return true;
//        } else if (value.compareTo(current.getData()) < 0) {
//            return containsRecursive(current.getPrev(), value);
//        } else {
//            return containsRecursive(current.getNext(), value);
//        }
//    }
//
//    public void remove(T value) {
//        root = removeRecursive(root, value);
//        count--;
//    }
//
//    private Node_DLL<T> removeRecursive(Node_DLL<T> current, T value) {
//        if (current == null) {
//            return null;
//        }
//        if (value.compareTo(current.getData()) < 0) {
//            current.setPrev(removeRecursive(current.getPrev(), value));
//        } else if (value.compareTo(current.getData()) > 0) {
//            current.setNext(removeRecursive(current.getNext(), value));
//        } else {
//            if (current.getPrev() == null) {
//                return current.getNext();
//            } else if (current.getNext() == null) {
//                return current.getPrev();
//            }
//            current.setData(minValue(current.getNext()));
//            current.setNext(removeRecursive(current.getNext(), current.getData()));
//        }
//        return current;
//    }
//
//    private T minValue(Node_DLL<T> node) {
//        T minValue = node.getData();
//        while (node.getPrev() != null) {
//            minValue = node.getPrev().getData();
//            node = node.getPrev();
//        }
//        return minValue;
//    }
//
//    public void clear() {
//        root = null;
//        count = 0;
//    }
//
//    public String toString() {
//        return toStringRecursive(root);
//    }
//
//    private String toStringRecursive(Node_DLL<T> current) {
//        if (current == null) {
//            return "";
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append(toStringRecursive(current.getPrev()));
//        sb.append(current.getData()).append(" ");
//        sb.append(toStringRecursive(current.getNext()));
//        return sb.toString();
//    }
//
//    public int height() {
//        return heightRecursive(root);
//    }
//
//    private int heightRecursive(Node_DLL<T> node) {
//        if (node == null) {
//            return -1;
//        }
//        int leftHeight = heightRecursive(node.getPrev());
//        int rightHeight = heightRecursive(node.getNext());
//        return Math.max(leftHeight, rightHeight) + 1;
//    }
//
//    public int size() {
//        return count;
//    }
//
//    public boolean isEmpty() {
//        return count == 0;
//    }
//
//    public void inOrderTraversal() {
//        inOrderTraversalRecursive(root);
//    }
//
//    private void inOrderTraversalRecursive(Node_DLL<T> node) {
//        if (node != null) {
//            inOrderTraversalRecursive(node.getPrev());
//            System.out.print(node.getData() + " ");
//            inOrderTraversalRecursive(node.getNext());
//        }
//    }
//
//    public void preOrderTraversal() {
//        preOrderTraversalRecursive(root);
//    }
//
//    private void preOrderTraversalRecursive(Node_DLL<T> node) {
//        if (node != null) {
//            System.out.print(node.getData() + " ");
//            preOrderTraversalRecursive(node.getPrev());
//            preOrderTraversalRecursive(node.getNext());
//        }
//    }
//
//    public void postOrderTraversal() {
//        postOrderTraversalRecursive(root);
//    }
//
//    private void postOrderTraversalRecursive(Node_DLL<T> node) {
//        if (node != null) {
//            postOrderTraversalRecursive(node.getPrev());
//            postOrderTraversalRecursive(node.getNext());
//            System.out.print(node.getData() + " ");
//        }
//    }
//
//    public void levelOrderTraversal() {
//        if (root == null) {
//            return;
//        }
//        Queue<Node_DLL<T>> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            Node_DLL<T> current = queue.poll();
//            System.out.print(current.getData() + " ");
//            if (current.getPrev() != null) {
//                queue.add(current.getPrev());
//            }
//            if (current.getNext() != null) {
//                queue.add(current.getNext());
//            }
//        }
//    }
}