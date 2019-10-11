package upe.ecomp.ed.resources
;
public class PilhaDinamica<T> implements TADPilha<T> {

	private Node<T> topo;
	private int qtd;
	
	public void push(T e) {
		Node<T> novo = new Node<T>(e);
		if (topo == null) 
			topo = novo;
		else {
			novo.setProximo(topo);
			topo = novo;
		}
		qtd++;
	}

	public T pop() {
		T r = null;
		if (topo != null) {
			r = topo.getInfo();
			topo = topo.getProximo();
			qtd--;
		}
		return r;
	}

	public T top() {
		T r = null;
		if (topo != null) 
			r = topo.getInfo();
		return r;
	}

	public int size() {
		return qtd;
	}

	public boolean isEmpty() {
		return topo == null;
	}

	public boolean isFull() {
		return false;
	}

	public String toString() {
		String s = "";
		Node<T> p = topo;
		for (int i = 0; i < qtd; i++) {
			if (i != 0) {
				s += "-> " + p.getInfo().toString();
				p = p.getProximo();
			} else {
				s +=p.getInfo().toString();
				p = p.getProximo();
			}

		}
		return s;
		
	}
	
	
	public int indexOf(T a) {
		int index = 0;
		for (Node<T> c = topo; c != null; c = c.getProximo()) {
			if (c.getInfo().equals(a)) {
				return index;
			}
			index++;
		}
			
		return -1;
		
	}
	
	public void imprime() {
		System.out.println(this.toString());
	}

}
