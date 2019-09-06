package upe.ecomp.ed.EscorelD;

public class DinamicQueue<T> extends Dinamic<T> {

    public void enqueue(T in){
        this.add(in);
    }

    public T peek(){
        return this.get(0);
    }
    
    public T dequeue() {
        T out = peek();
        remove(out);
        return out;
    }
}