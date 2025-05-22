package NEU.ET39.CSC250.DataStructures;

import NEU.ET39.CSC250.DataStructures.Nodes.Node_BST;
import org.w3c.dom.Node;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    public AVLTree() {
        super();
    }


    public void add(T value) {
        super.add(value);
        super.setRoot(balance(super.getRoot()));
    }

    public void remove(T value) {
        super.remove(value);
        super.setRoot(balance(super.getRoot()));
    }

    private Node_BST balance(Node_BST node){
        //TODO:
        return node;
    }

}
