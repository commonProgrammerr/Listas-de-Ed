package upe.ecomp.TDAs;

/**
 * EstaticTDA
 */
public interface EstaticTDA {
    T[] dados;
    boolean add(T data);
    boolean add(T data, int index);
    T get(int index);
    void remove(int index);
    void remove(T item);
    void print();

}