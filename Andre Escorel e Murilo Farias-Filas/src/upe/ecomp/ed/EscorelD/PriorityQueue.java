package upe.ecomp.ed.EscorelD;

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
        for(int i = 0; i < this.size(); i++)
           if(n.compareTo(this.get(i)) > 0){
                super.enqueue((T)in, i);
                break;
            }
    }
}