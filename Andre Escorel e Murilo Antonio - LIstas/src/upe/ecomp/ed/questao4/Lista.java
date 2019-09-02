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
        if(head == null){
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

    private boolean add(Node newNode) {
        newNode.next = null;
        if(head == null){
            head = newNode;
            return true;
        } else
            for (Node c = head; c != null; c = c.next)
                if (c.next == null) {
                    c.next = newNode;
                    return true;
                }
            return false;
    }
    
    public int size() {
        int i = 0;
        for (Node c = head; c != null; c = c.next)
            i++;
        return i;
    }

    public void inverter() {
        if(this.size() > 0){
            Node aux = head;
            head = head.next;;
            inverter();
            this.add(aux);
        }
    }

    public void print() {
        System.out.print("[");
        for (Node c = head; c != null; c = c.next){
            if(c.next != null)
                System.out.print(c.data + ",");
            else
                System.out.print(c.data);
        }
        System.out.println("]");
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