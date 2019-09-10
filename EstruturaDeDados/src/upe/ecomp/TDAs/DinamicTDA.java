package upe.ecomp.TDAs;
import upe.ecomp.etruturas.Node;
/**
 * DinamicTDA
 */
public interface DinamicTDA{
    Node<T> head;
    T get(int index);
    boolean add(T data);
    void print();
    T remove(int index);
    void remove(T item);
}