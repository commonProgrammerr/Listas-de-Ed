package upe.ecomp.Estruturas.ED;
/**
 * Queue
 */
public class Queue<T> {

    private Estatica<T> queue;
    
    public Queue(int capacidade) {
        queue = new Estatica<T>(capacidade);
    }

    public void enqueue(T in) {
        queue.add(in);
    }

    public void add(T in, int index) {
        queue.add(in, index);
    }
    public T dequeue(){
        return queue.remove(0);
    }

    public T peek() {
        return queue.get(0);
    }

    public T get(int index) {
        return queue.get(index);
    }
    public int size() {
        return queue.size();
    }

    public void print(){
        queue.print();
    }
}