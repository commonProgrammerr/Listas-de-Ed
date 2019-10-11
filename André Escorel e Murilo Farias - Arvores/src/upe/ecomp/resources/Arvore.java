package ecomp.ed.arvore;

import java.util.Iterator;

import ecomp.ed.fila.FilaDinamica;

public class Arvore<T> implements TADArvore<T> {
	
	private NoArvore<T> raiz;
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
				raiz = new NoArvore<T>(e);
			} else {
				FilaDinamica<NoArvore<T>> fila = new FilaDinamica<NoArvore<T>>();
				fila.inserir(raiz);
				while (fila.size() > 0) {
					NoArvore<T> no = fila.remover();
					if (no.getNumeroFilhos() < maxNumeroFilhos) {
						no.addFilho(new NoArvore<T>(e));
						break;
					} else {
						for (Iterator iterator = no.getFilhos(); iterator.hasNext();) {
							NoArvore<T> filho = (NoArvore<T>) iterator.next();
							fila.inserir(filho);
						}
					}
				}
			}
		}
	}
	
	@Override
	public void remover(T e) {
		// TODO Auto-generated method stub
		
	}

	public boolean contains(Object o) {
		return contains(raiz, o);
	}
	
	private boolean contains(NoArvore<T> subarvore, Object o) {
		boolean r = false;
		if (subarvore == null) {
			return false; // caso base
		} else if (subarvore.getInfo().equals(o)) {
			return true; // caso base
		} else {
			for (Iterator iterator = subarvore.getFilhos(); iterator.hasNext();) {
				NoArvore<T> filho = (NoArvore<T>) iterator.next();
				r = contains(filho, o);
				if (r == true) {
					break;
				}
			}
			return r;
		}
	}
	
}
