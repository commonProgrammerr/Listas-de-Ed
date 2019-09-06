package upe.ecomp.ed.questao6;

/**
 * NodeD
 */
public class Node<T> {
    public Node<T> before;
    public Node<T> next;
    public T data;

    public Node(T data) {
        before = null;
        next = null;
        this.data = data;
    }  
    public Node(Node<T> before, T data) {
        this.before = before;
        this.before.next = this;
        this.next = null;
        this.data = data;
    }

    public Node(T data, Node<T> next) {
        this.before = null;
        this.next = next;
        this.next.before = this;
        this.data = data;
    }

    public Node(Node<T> before, T data, Node<T> next) {
        this.before = before;
        this.before.next = this;
        this.next = next;
        this.next.before = this;
        this.data = data;
    }

    public void clear() {
        if(this.next != null)
            this.next.before = this.before;
        if(this.before != null)
            this.before.next = this.next;
        this.before = null;
        this.next = null;
    }
}