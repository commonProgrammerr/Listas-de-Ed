package upe.ecomp.ed.questao1;

/**
 * Lista
 */
public class Lista {
    private Node head;

    public boolean add(Cliente newData) {
        for (Node c = head; c != null; c = c.next)
            if (c.next == null && !newData.cpf.equals(c.data.cpf)) {
                c.next = new Node();
                c.next.data = newData;
                return true;
            }
        return false;
    }

    public void print() {
        for (Node c = head; c != null; c = c.next)
            System.out.println(c.data.nome + ":" + c.data.cpf);
    }

    public boolean contains(Object o) {
        for (Node c = head; c != null; c = c.next)
            if(c.data.equals(o))
                return true;
        return false;
    }

    public int size() {
        int i = 0;
        for (Node c = head; c != null; c = c.next)
            i++;
        return i;
    }
}