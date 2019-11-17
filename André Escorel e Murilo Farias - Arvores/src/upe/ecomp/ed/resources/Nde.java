package upe.ecomp.ed.resources;

/**
 * Nde
 */
public class Nde <K, T>{
    public T data;
    public K key;
    public Nde<K, T> next;
    
    public Nde(K key, T data) {
        this.key = key;
        this.data = data;
    }
    
}