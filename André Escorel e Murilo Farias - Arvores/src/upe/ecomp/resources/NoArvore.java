package ecomp.ed.arvore;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ecomp.ed.lista.ListaDinamica;
import ecomp.ed.lista.ListaEstatica;

public class NoArvore<T> {

	private T info;
	private ListaEstatica<NoArvore<T>> filhos;
	
	public NoArvore(T e) {
		info = e;
		filhos = new ListaEstatica<NoArvore<T>>();
	}
	
	public void addFilho(NoArvore<T> f) {
		filhos.inserir(f);
	}
	
	public void removeFilho(NoArvore<T> f) {
		if (filhos.contains(f)) {
			filhos.remover(f);
		}
	}
	
	public boolean containsFilho(NoArvore<T> f) {
		return filhos.contains(f);
	}
	
	public boolean equals(Object o) {
		boolean r = false;
		if (o instanceof NoArvore) {
			r = this.info.equals(((NoArvore<T>) o).info);
		}
		return r;
	}
	
	public T getInfo() {
		return info;
	}
	
	public Iterator<NoArvore<T>> getFilhos() {
		List<NoArvore<T>> temp = new LinkedList<NoArvore<T>>();
		for(int i=0; i<filhos.size(); i++) {
			temp.add(filhos.procurarIEsimo(i));
		}
		return temp.iterator();
	}
	
	public int getNumeroFilhos() {
		return filhos.size();
	}
	
	public String toString() {
		return "" + info;
	}
}
