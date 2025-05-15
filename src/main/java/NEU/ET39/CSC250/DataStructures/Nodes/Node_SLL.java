package NEU.ET39.CSC250.DataStructures.Nodes;

public class Node_SLL<T extends Comparable<T>> {
    private T data;
    private Node_SLL<T> next;

    public Node_SLL(T data) {
        this.data = data;
        this.next = null;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Node_SLL<T> getNext() {
        return next;
    }

    public void setNext(Node_SLL<T> next) {
        this.next = next;
    }

}
