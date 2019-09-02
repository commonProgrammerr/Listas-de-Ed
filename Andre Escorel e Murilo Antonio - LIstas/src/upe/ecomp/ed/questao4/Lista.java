package upe.ecomp.ed.questao4;
import upe.ecomp.ed.questao3.Node;
/**
 * Lista
 */
public class Lista {
    private Node head;
    
    public Lista() {
        head = null;
    }
    
    public boolean add(String newData) {
        if(head == null && head.next == null){
            head = new Node();
            head.data = newData;
            return true;
        } else
            for (Node c = head; c != null; c = c.next)
                if (c.next == null) {
                    c.next = new Node();
                    c.next.data = newData;
                    return true;
                }
            return false;
    
    }
    
    private Node inverter(Node elo) {
        if(elo.next != null){
            Node out = inverter(elo.next);
            out.next = elo;
            return out;
        }else 
            return elo;
    }

    public Void inverter(){
        head = inverter(head);
        return null;
    }

    public void print() {
        for (Node c = head.next; c != null; c = c.next)
            System.out.println(c.data);
    }

    
    public static void main(String[] args) {
        Lista a = new Lista();
        for (int i = 0; i < 5; i++) {
            a.add(Integer.toString(i));
        }
        a.print();
        a.inverter();
        a.print();
    }
}