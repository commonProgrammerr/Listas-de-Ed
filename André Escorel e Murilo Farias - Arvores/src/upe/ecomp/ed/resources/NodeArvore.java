package upe.ecomp.ed.resources;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class NodeArvore<T> {

	private T info;
	private ListaEstatica<NodeArvore<T>> filhos;
	
	public NodeArvore(T e) {
		info = e;
		filhos = new ListaEstatica<NodeArvore<T>>();
	}
	
	public void addFilho(NodeArvore<T> f) {
		filhos.inserir(f);
	}
	
	public void removeFilho(NodeArvore<T> f) {
		if (filhos.contains(f)) {
			filhos.remover(f);
		}
	}
	
	public boolean containsFilho(NodeArvore<T> f) {
		return filhos.contains(f);
	}
	
	public boolean equals(Object o) {
		boolean r = false;
		if (o instanceof NodeArvore) {
			r = this.info.equals(((NodeArvore<T>) o).info);
		}
		return r;
	}
	
	public T getInfo() {
		return info;
	}
	
	public Iterator<NodeArvore<T>> getFilhos() {
		List<NodeArvore<T>> temp = new LinkedList<NodeArvore<T>>();
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
