package upe.ecomp.ed.resources;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Map
 */
public class MyMap<K, T>{
    public Nde<K, T> head;
    private Nde<K, T> tail;
    private int size;
    public MyMap(){
        head = tail = null;
        size = 0;
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(K key) {
        Nde<K, T> aux;
        aux = head;
        while (aux != null) {
            if(aux.key.equals(key))
                return aux.data;
            else
                aux = aux.next;
        }
        return null;
    }

    public void put(K key, T value) {
        if(head == null)
            head = tail = new Nde<K,T>(key,value);
        else{
            tail.next = new Nde<K,T>(key,value);
            tail= tail.next;
        }
        size++;
    }

}