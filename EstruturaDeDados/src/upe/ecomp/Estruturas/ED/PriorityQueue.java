package upe.ecomp.Estruturas.ED;

/**
 * PrioritQueue
 */
public class PriorityQueue<T> extends Queue<T>{
    
    public PriorityQueue(int capacidade) {
        super(capacidade);
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
}