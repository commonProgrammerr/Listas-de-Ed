package upe.ecomp.ed;

public class Dinamic<T> {

    private class Node {
        public T data;
        public Node next;

        public Node(T newData) {
            data = newData;
            next = null;
        }        
    }
    
    private Node head;
    private Node cauda;
    private int size;

    public Dinamic() {
        head = null;
        cauda = null;
        size = 0;
    }
    
    public void add(T in) {
        cauda.next = new Node(in);
        size++;
    }
    public void add(T in, int index) {
        Node j = head;
        for (int i = 0; i < index; i++)
            j = j.next;
        Node aux = new Node(in);
        aux.next = j.next;
        j.next = aux;
        size++;
    }

    public T get(int index) {
        int j = 0;
        for (Node i = head; i != null; i = i.next)
            if(j == index)
                return i.data;
            else 
                j++;
        return null;
    }

    public void remove(T alvo) {
        for (Node i = head; i != null; i = i.next)
            if(i.next.data.equals(alvo)){
                i.next = i.next.next;
                break;
            }
    }
}