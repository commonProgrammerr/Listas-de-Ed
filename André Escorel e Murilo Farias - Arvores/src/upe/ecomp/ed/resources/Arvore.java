package upe.ecomp.ed.resources;

import java.util.Iterator;


public class Arvore<T> implements TADArvore<T> {
	
	private NodeArvore<T> raiz;
	private int maxNumeroFilhos;
	
	public Arvore(int maxNumFilhos) {
		this.maxNumeroFilhos = maxNumFilhos;
	}

	public void imprimir() {
		// TODO Auto-generated method stub
		
	}

	public void esvaziar() {
		raiz = null;
	}

	public void inserir(T e) {
		if (! contains(e)) {
			if (raiz == null) {
				raiz = new NodeArvore<T>(e);
			} else {
				FilaDinamica<NodeArvore<T>> fila = new FilaDinamica<NodeArvore<T>>();
				fila.inserir(raiz);
				while (fila.size() > 0) {
					NodeArvore<T> no = fila.remover();
					if (no.getNumeroFilhos() < maxNumeroFilhos) {
						no.addFilho(new NodeArvore<T>(e));
						break;
					} else {
						for (Iterator iterator = no.getFilhos(); iterator.hasNext();) {
							NodeArvore<T> filho = (NodeArvore<T>) iterator.next();
							fila.inserir(filho);
						}
					}
				}
			}
		}
	}
	
	@Override
	public void remover(T e) {
		if (! contains(e)) {
			
		}
		
	}

	public boolean contains(Object o) {
		return contains(raiz, o);
	}
	
	private boolean contains(NodeArvore<T> subarvore, Object o) {
		boolean r = false;
		if (subarvore == null) {
			return false; // caso base
		} else if (subarvore.getInfo().equals(o)) {
			return true; // caso base
		} else {
			for (Iterator iterator = subarvore.getFilhos(); iterator.hasNext();) {
				NodeArvore<T> filho = (NodeArvore<T>) iterator.next();
				r = contains(filho, o);
				if (r == true) {
					break;
				}
			}
			return r;
		}
	}
	
}
