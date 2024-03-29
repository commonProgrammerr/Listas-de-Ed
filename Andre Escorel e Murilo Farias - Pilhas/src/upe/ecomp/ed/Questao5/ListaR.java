package upe.ecomp.ed.Questao5;
import upe.ecomp.ed.resources.Node;
/**
 * ListaR
 */
public class ListaR<T> {
    private Node<T> head;
    public ListaR() {
        head = null;
    }

    private void add(T newData, Node<T> current) {
        if(head == null)
            head = new Node<T>(newData);
        else if(current.getProximo() == null)
            current.setProximo(new Node<T>(newData));
        else 
            add(newData, current.getProximo());
    }

    public void add(T newData) {
        this.add(newData, head);
    }

    private void remove(T target, Node<T> current) {
        if(current.getProximo() != null){
            if(current.getProximo().getInfo() == target)
                current.getProximo().setProximo(current.getProximo().getProximo().getProximo());
            else 
                remove(target, current.getProximo());
        }
    }

    public void remove(T target) {
            if(head.getInfo() == target)
            head = head.getProximo();
            this.remove(target, head);
    }
    
    private String toString(Node<T> current) {
        String out = "";
        if(current == head)
            out += "[";
        out += current.getInfo().toString();
        if(current.getProximo() == null)
            return out + "]";
        else 
            return out + "," + toString(current.getProximo());
    }

    public String toString() {
        return toString(head);
    }
}