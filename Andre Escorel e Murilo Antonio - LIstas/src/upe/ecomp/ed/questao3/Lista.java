package upe.ecomp.ed.questao3;

/**
 * Lista
 */
public class Lista {
    private Node head;

    public Lista() {
        head = new Node();
        head.next = head;
    }

    public void add(String newData) {
        for (Node c = head; c != head; c = c.next) {
            if (c.next == head) {
                c.next = new Node();
                c.next.data = newData;
                c.next.next = head;
                break;
            }
        }
    }

    public boolean contains(String s) {
        for (Node c = head; c != null; c = c.next == head ? null : c.next)
            if (c.data.equalsIgnoreCase(s))
                return true;
        return false;
    }

    public static boolean filter(Lista a, Lista b) {
        boolean bool = false;
        
        return bool;
    }
    public static Lista mix(Lista l1, Lista l2) {
        Lista out = new Lista();
        Node a = l1.head;
        Node b = l2.head;
        while (a != null || b != null) {
            if(a != null){
                a = a.next == l1.head ? null : a.next;
                out.add(a.data);
            }
            if(b != null){
                out.add(b.data);
                b = b.next == l2.head ? null : b.next;
            }
        }
        
        return out;
    }

    public int size() {
        int i = -1;
        for (Node c = head; c != null; c = c.next == head ? null : c.next)
            i++;
        return i + 1;
    }
}