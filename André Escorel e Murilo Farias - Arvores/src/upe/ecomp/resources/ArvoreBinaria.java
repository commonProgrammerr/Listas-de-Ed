package ecomp.ed.arvore;

public class ArvoreBinaria<T> implements TADArvore<T> {

	private NoBinario<T> raiz;
	
	public void imprimir() {
		System.out.println("Imprimindo elementos em pre-ordem:");
		percursoPreOrdem(raiz);
		System.out.println("\n---------");
		System.out.println("Imprimindo elementos em ordem:");
		percursoEmOrdem(raiz);
		System.out.println("\n---------");
		System.out.println("Imprimindo elementos em ordem decrescente:");
		percursoEmOrdemDec(raiz);
		System.out.println("\n---------");
		System.out.println("Imprimindo elementos em pos-ordem:");
		percursoPosOrdem(raiz);
		System.out.println("\n---------");
	}

	public void esvaziar() {
		raiz = null;
	}

	public void remover(T e) {
		int c = compare(raiz.getInfo(), e);
		if (c == 0) {
			// o elemento a ser removido � a raiz
			if (raiz.getEsq() == null) {
				raiz = raiz.getDir();
			} else if (raiz.getDir() == null) {
				raiz = raiz.getEsq();
			} else {
				removerRaizSubArvore(raiz);
			}
		} else {
			// o elemento a ser removido n�o � a raiz
			// procura o elemento na arvore
			NoBinario<T> p = raiz;
			while (p != null) {
				c = compare(p.getInfo(), e);
				if (c < 0) {
					// o elemento a ser removido pode estar � direita
					if (p.getDir() != null &&
							p.getDir().getInfo().equals(e)) {
						// encontrei o elemento que deve ser removido
						if (p.getDir().getEsq() == null) {
							p.setDir(p.getDir().getDir());
						} else if (p.getDir().getDir() == null) {
							p.setDir(p.getDir().getEsq());
						} else {
							// o elemento a ser removido nao � folha
							removerRaizSubArvore(p.getDir());
						}
						break;
					} else {
						// desce na �rvore em busca do elemento
						p = p.getDir();
					}
				} else {
					// o elemento a ser removido pode estar � esquerda
					if (p.getEsq() != null &&
							p.getEsq().getInfo().equals(e)) {
						// encontrei o elemento que deve ser removido
						if (p.getEsq().getEsq() == null) {
							p.setEsq(p.getEsq().getDir());
						} else if (p.getEsq().getDir() == null) {
							p.setEsq(p.getEsq().getEsq());
						} else {
							// o elemento a ser removido nao � folha
							removerRaizSubArvore(p.getEsq());
						}
						break;
					} else {
						// desce na �rvore em busca do elemento
						p = p.getEsq();
					}
				}
			}
		}
	}

	private void removerRaizSubArvore(NoBinario<T> raiz) {
		// a raiz n�o � uma folha!
		if (raiz.getEsq().getDir() == null) {
			raiz.setInfo(raiz.getEsq().getInfo());
			raiz.setEsq(raiz.getEsq().getEsq());
		} else {
			// localiza o maior elemento da subarvore esquerda
			NoBinario<T> q = raiz.getEsq();
			while (q.getDir().getDir() != null) {
				q = q.getDir();
			}
			raiz.setInfo(q.getDir().getInfo());
			q.setDir(q.getDir().getEsq());
		}
	}
	
	// se a < b retorna valor negativo
	// se a > b retorna valor positivo
	// caso contrario retorna 0
	private int compare(T a, T b) {
		int r = -1;
		if (a instanceof Comparable) {
			r = ((Comparable) a).compareTo(b);
		}
		return r;
	}

	public boolean contains(T e) {
		boolean r = false;
		NoBinario<T> aux = raiz;
		while (aux != null) {
			if (aux.getInfo().equals(e)) {
				r = true; 
				break;
			} else if (compare(aux.getInfo(), e) < 0) {
				aux = aux.getDir();
			} else {
				aux = aux.getEsq();
			}
		}
		return r;
	}

	public void inserir(T e) {
		if (! contains(e)) {
			NoBinario<T> novo = new NoBinario<T>(e);
			if (raiz == null) {
				raiz = novo;
			} else {
				NoBinario<T> aux = raiz;
				while (aux != null) {
					if (compare(aux.getInfo(), e) < 0) {
						if (aux.getDir() == null) {
							aux.setDir(novo);
							break;
						} else {
							aux = aux.getDir();
						}
					} else {
						if (aux.getEsq() == null) {
							aux.setEsq(novo);
							break;
						} else {
							aux = aux.getEsq();
						}
					}
				}
			}
		}	
	}
	
	private void percursoPreOrdem(NoBinario<T> no) {
		if (no != null) {
			System.out.print(no.getInfo() + " ");
			percursoPreOrdem(no.getEsq());
			percursoPreOrdem(no.getDir());
		}
	}
	
	private void percursoPosOrdem(NoBinario<T> no) {
		if (no != null) {
			percursoPosOrdem(no.getEsq());
			percursoPosOrdem(no.getDir());
			System.out.print(no.getInfo() + " ");
		}
	}
	
	private void percursoEmOrdem(NoBinario<T> no) {
		if (no != null) {
			percursoEmOrdem(no.getEsq());
			System.out.print(no.getInfo() + " ");
			percursoEmOrdem(no.getDir());
		}
	}
	
	private void percursoEmOrdemDec(NoBinario<T> no) {
		if (no != null) {
			percursoEmOrdemDec(no.getDir());
			System.out.print(no.getInfo() + " ");
			percursoEmOrdemDec(no.getEsq());
		}
	}
}
