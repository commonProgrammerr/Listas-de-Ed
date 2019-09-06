package upe.ecomp.ed.EscorelD;

/**
 * Node
 */
public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T newData) {
        data = newData;
        next = null;
    }
}