package upe.ecomp.ed;
/**
 * Queue
 */
public class Queue<T> extends Estatica<T> {

    public Queue(int capacidade) {
        super(capacidade);
    }

    public void enqueue(T in) {
        this.add(in);
    }

    public void enqueue(T in, int index) {
        this.add(in, index);
    }

    public T dequeue(){
        return this.remove(0);
    }

    public T peek() {
        return super.get(0);
    }
}