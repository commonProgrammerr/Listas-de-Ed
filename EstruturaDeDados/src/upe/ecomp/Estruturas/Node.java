package upe.ecomp.Estrutura;
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