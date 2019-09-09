package upe.ecomp.ed.questao5;

import upe.ecomp.ed.EscorelD.PriorityQueue;
import upe.ecomp.ed.EscorelD.Queue;

/**
 * Q5
 */
public class Q5<T> extends Queue<T>{
    
    public Q5(int i) {
        super(i);
    }

    @Override
    public void enqueue(T in) {
        Comparable<T> n = (Comparable<T>) in;
        int i = 0;
        for(; i < this.size(); i++)
            if(n.compareTo(this.get(i)) < 0)
                break;
        super.add(in, i);
    }
    
    public void mix(Q5<T> f1, Q5<T> f2, Q5<T> out) {
        
        for (int i = 0; i < (f1.size() | f2.size()); i++) {
            if(i < f1.size())
                out.enqueue(f1.get(i));
            if(i < f2.size())
                out.enqueue(f2.get(i));
        }
    }
}