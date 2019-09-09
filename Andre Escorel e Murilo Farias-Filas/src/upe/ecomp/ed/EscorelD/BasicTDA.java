package upe.ecomp.ed.EscorelD;

/**
 * BasicTDA
 */
public interface BasicTDA<T> {
    void print();
    boolean add(T in);
    boolean add(T in, int index);
    void remove(T alvo);
    int indexOf(T alvo);
}