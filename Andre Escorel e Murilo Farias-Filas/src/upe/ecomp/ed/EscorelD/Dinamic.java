package upe.ecomp.ed.EscorelD;

import java.util.Iterator;

public class Dinamic<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Dinamic() {
        head = null;
        tail = null;
        size = 0;
    }

    public void print() {
        System.out.println(this.toString());
    }
    
    protected boolean add(T in) {
        Node<T> node = new Node<T>(in);
        if (head == null) 
            tail = head = node; 
        else { 
            tail.next = node; 
            tail = node; 
        }
        size++;
        return true;
    }

    public boolean add(T in, int index) {
        Node<T> j = head;
        for (int i = 0; i < index; i++)
            j = j.next;
        Node<T> aux = new Node<>(in);
        aux.next = j.next;
        j.next = aux;
        size++;
        return true;
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
            if (i.next.data == alvo) {
                i.next = i.next.next;
                size--;
                break;
            }
    }

    public int indexOf(T obj) {
        int i = 0;
        for (T var : this) {
            if(var == obj)
                return i;
            else
                i++;
        }
        return -1;
    }
    public int size() {
        return size;
    }
    
    @Override
    public String toString() {
        String out = "[";
        for (T var : this) {
            out += var.toString() + ",";
        }
        out += "]";
        return out;
    }

    public Iterator<T> iterator() 
    { 
        return new Iterator<T>() {
            Node<T> current = head;
        
            public boolean hasNext() 
            { 
                return current != null; 
            } 
            
            public T next() 
            { 
                T data = current.data; 
                current = current.next; 
                return data; 
            } 
            
            public void remove() 
            { 
                throw new UnsupportedOperationException(); 
            }
        }; 
    }
}