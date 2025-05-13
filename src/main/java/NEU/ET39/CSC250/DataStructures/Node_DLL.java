package NEU.ET39.CSC250.DataStructures;

public class Node_DLL<T extends Comparable<T>> {
    private T data;
    private Node_DLL<T> next;
    private Node_DLL<T> prev;

    public Node_DLL(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node_DLL<T> getNext() {
        return next;
    }

    public void setNext(Node_DLL<T> next) {
        this.next = next;
    }

    public Node_DLL<T> getPrev() {
        return prev;
    }

    public void setPrev(Node_DLL<T> prev) {
        this.prev = prev;
    }
}
