package upe.ecomp.ed.resources;


public class FilaDinamica<T> implements TADFila<T> {

	private Node<T> inicio, fim;
	private int qtd;

	public void inserir(T e) {
		Node<T> novo = new Node<T>(e);
		if (inicio == null) {
			inicio = novo;
			fim = novo;
		} else {
			fim.setProximo(novo);
			fim = novo;
		}
		qtd++;
	}

	public T remover() {
		T r = null;
		if (inicio != null) {
			r = inicio.getInfo();
			inicio = inicio.getProximo();
			if (inicio == null)
				fim = null;
			qtd--;
		}
		return r;
	}

	public T inicio() {
		T r = null;
		if (inicio != null)
			r = inicio.getInfo();
		return r;
	}

	public int size() {
		return qtd;
	}

	public String toString() {
		String s = "";
		Node<T> p = inicio;
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
	
	

	public void imprimir() {
		System.out.println(this.toString());
	}

}
