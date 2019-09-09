package upe.ecomp.ed.questao6;

import java.util.Iterator;

/**
 * Deque
 */
public class Deque<T> implements Iterable<T>{
    Node<T> head;
    Node<T> tail;
    int size;

    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addDir(T data) {
        if(size <= 0){
            head = new Node<T>(data);
            tail = head;
        }
        else{
            Node<T> a = new Node<T>(data);
            tail.next = a;
            a.before = tail;
            tail = a;
        }
        size++;
    }

    public void addEsq(T data) {
        if(size <= 0){
            head = new Node<T>(data);
            tail = head;
        }
        else {
            Node<T> a = new Node<T>(data);
            head.before = a;
            a.next = head;
            head = a;
        }
        size++;
    }

    public T popFirst() {
        if(size <= 0)
            return null;
        else {
            T out = head.data;
            head = head.next;
            head.before = null;
            return out;
        }
        
    }

    public T popLast() {
        if(size <= 0)
            return null;
        T out = tail.data;
        tail = tail.before;
        tail.next = null;
        return out;
    }

    public void remove(T alvo) {
        for (Node<T> i = head; i != null; i = i.next)
            if(i.data == alvo){
                if(i.before != null)
                    i.before.next = i.next;
                else if(i.next != null)
                    i.next.before = i.before;
                else{
                    tail = null;
                    head = null;
                }
                return;
            }
        
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

    public void print() {
        System.out.println(this.toString());
    }
    
    public Iterator<T> iterator(){
         
        return new Iterator<T>() {
            Node<T> current = head;
        
            public boolean hasNext() { 
                return current != null; 
            } 
            
            public T next() { 
                T data = current.data; 
                current = current.next; 
                return data; 
            } 
            
            public void remove() { 
                throw new UnsupportedOperationException(); 
            }
        }; 
    }
    
}