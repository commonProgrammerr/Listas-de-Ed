package upe.ecomp.ed.resources;

public class ListaEstatica<T> implements TADLista<T> {

	private T[] dados;
	private int qtd;
	
	public int size() {
		return qtd;
	}
	
	public ListaEstatica() {
		dados = (T[]) new Object[5];
	}
	
	public void inserir(T e) {
		if (qtd < dados.length) {
			// tem espaco na lista
			if (indexOf(e) == -1) {
				// o elemento nao foi localizado, entao insere
				dados[qtd] = e;
				qtd++;
			}
		} else {
			T[] temp = (T[]) new Object[(int)(qtd * 1.5)];
			for (int i = 0; i < qtd; i++) {
				temp[i] = dados[i];
			}
			dados = temp;
			// o garbage collector vai limpar o array original
			inserir(e);
		}
	}
	
	public int indexOf(Object o) {
		int r = -1;
		for (int i = 0; i < qtd; i++) {
			// ERRADO -> if (o == dados[i]) {
			if (o.equals(dados[i])) {
				r = i;
				break;
			}
		}
		return r;
	}
	
	public void remover(T e) {
		int i = indexOf(e);
		if (i != -1) {
			// substitui o elemento para uma remocao mais eficiente
			dados[i] = dados[qtd-1];
			dados[qtd-1] = null;
			qtd--;
		}
	}
	
	public String toString() {
		String s = "inicio ";
		for (int i = 0; i < qtd; i++) {
			s += "-> " + dados[i];
		}
		return s;
	}
	
	public void imprimeLista() {
		System.out.println(this.toString());
	}

	public void esvaziar() {
		dados = (T[]) new Object[dados.length];
		qtd = 0;
	}

	public T procurarIEsimo(int i) {
		T r = null;
		if (i >= 0 && i < qtd) {
			r = dados[i];
		}
		return r;
	}

	public boolean contains(Object o) {
		return (indexOf(o) != -1);
	}

}
