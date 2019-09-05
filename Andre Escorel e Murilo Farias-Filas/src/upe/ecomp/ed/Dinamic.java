package upe.ecomp.ed;

import java.util.Iterator;

public class Dinamic<T> implements Iterable<T> {
    protected class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T newData) {
            data = newData;
            next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Dinamic() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T in) {
        Node<T> node = new Node<T>(in);
        if (head == null) 
            tail = head = node; 
        else { 
            tail.next = node; 
            tail = node; 
        }
        size++;
    }

    public void add(T in, int index) {
        Node<T> j = head;
        for (int i = 0; i < index; i++)
            j = j.next;
        Node<T> aux = new Node<>(in);
        aux.next = j.next;
        j.next = aux;
        size++;
    }

    public T get(int index) {
        int j = 0;
        for (Node<T> i = head; i != null; i = i.next)
            if (j == index)
                return i.data;
            else
                j++;
        return null;
    }

    public void remove(T alvo) {
        for (Node<T> i = head; i != null; i = i.next)
            if (i.next.data.equals(alvo)) {
                i.next = i.next.next;
                size--;
                break;
            }
    }

    public int size() {
        return size;
    }
    public Node<T> getHead() 
    { 
        return head; 
    } 
      
    // return Tail 
    public Node<T> getTail() 
    { 
        return tail; 
    } 
      
    // return Iterator instance 
    public Iterator<T> iterator() 
    { 
        return new ListIterator<T>(this); 
    }
    
    private class ListIterator<T> implements Iterator<T> { 
        Node<T> current; 
          
        // initialize pointer to head of the list for iteration 
        public ListIterator(Dinamic<T> list) 
        { 
            current = (Node<T>) list.getHead(); 
        } 
          
        // returns false if next element does not exist 
        public boolean hasNext() 
        { 
            return current != null; 
        } 
          
        // return current data and update pointer 
        public T next() 
        { 
            T data = current.data; 
            current = current.next; 
            return data; 
        } 
          
        // implement if needed 
        public void remove() 
        { 
            throw new UnsupportedOperationException(); 
        } 
    } 
    
}