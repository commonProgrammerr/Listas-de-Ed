package upe.ecomp.ed.questao06;

import upe.ecomp.ed.resources.*;;

public class Questao6<T> extends ArvoreBinaria<T> {

	public void transformaAVL(NodeBinario<T> root) {
		if (!isAVL()) { //Verifica se a árvore é AVL
			ListaDinamica<T> dados = new ListaDinamica<T>();
			ListaDinamica<T> esq = new ListaDinamica<T>();
			ListaDinamica<T> dir = new ListaDinamica<T>();
			ArvoreBinaria<T> nova = new ArvoreBinaria<T>();
			
			dados=addArvoreLista(dados, root); //Passa todos os nós da árvore para uma Lista dinamica, ordenados
			nova.inserir(dados.procurarIEsimo((dados.getQtd())/2)); //Adiciona o elemento que está no meio da lista à árvore
			splitLista(dados, esq, dir); //Divide a lista em 2 listas menores. Uma contendo os elementos menores, e a outra os maiores que o centro
			addLista(esq, nova); //Adiciona a lista menor à árvore
			addLista(dir, nova); //Adiciona a lista maior à árvore
			setRaiz(nova.getRaiz()); //Muda as raízes
		}
		
	}	
	
	
	public void addLista(ListaDinamica<T> lista, ArvoreBinaria<T> arvore) {
	
		if(lista.getInicio()!=null) { //Verifica se a lista tem algum elemento
			T centro = lista.procurarIEsimo(lista.getQtd()/2); //Pega o elemento do meio da lista, e seus vizinhos, e em seguida adiciona à árvore
			T esq = lista.procurarIEsimo((lista.getQtd()/2)-1);
			T dir = lista.procurarIEsimo((lista.getQtd()/2)+1);
			if(centro!=null) {
				arvore.inserir(centro);
				lista.remover(centro);
			}
			if(esq!=null) {
				arvore.inserir(esq);
				lista.remover(esq);
			}
			if(dir!=null) {
				arvore.inserir(dir);
				lista.remover(dir);
			}
			addLista(lista, arvore);
		}

			
	}
	
	
	
	public void splitLista(ListaDinamica<T> dados, ListaDinamica<T> esq, ListaDinamica<T> dir) { //Divide a lista em 2 partes, uma menor e outra maior que o centro
		for (int i = 1; i < (dados.getQtd()/2)+1; i++) {
			esq.inserir(dados.procurarIEsimo(((dados.getQtd())/2)-i));
		}
		
		for (int i = dados.getQtd()-1; i >= (dados.getQtd()/2)+1; i--) {
			dir.inserir(dados.procurarIEsimo(i));
		}
		
		
	}
	
	
	
	
	
	
	

	private ListaDinamica<T> addArvoreLista(ListaDinamica<T> dados, NodeBinario<T> root) {
	// Adiciona os elementos de forma ordenada na lista. Como o método add de lista dinamica sempre adiciona no inicio, percorre a árvore em órdem decrescente.
		if (root != null) {
			addArvoreLista(dados, root.getDir());
			dados.inserir(root.getInfo());
			addArvoreLista(dados, root.getEsq());
		}

		return dados;

	}

	public boolean isAVL() {
		return isBalanceado(getRaiz()); // Evita que o usuário chame o método isBalanceado com algum nó que não seja a raiz
	}

	private boolean isBalanceado(NodeBinario<T> data) { // Para que a árvore esteja balanceada: |He - Hd| <= 1, onde He = altura esquerda e Hd = altura direita
		int alturaEsquerda, alturaDireita;

		if (data == null) {
			return true; // Retorna true se o nó estiver vazio
		}
      
		alturaEsquerda = calcularAlturaNo(data.getEsq()); // Calcula a altura da direita e esquerda
		alturaDireita = calcularAlturaNo(data.getDir());

		if (Math.abs(alturaEsquerda - alturaDireita) <= 1 && isBalanceado(data.getEsq()) // Se o nó atual estiver balanceado, assim como todos os outros nós seguintes estiverem, retorna true
				&& isBalanceado(data.getDir())) {
			return true;
		}

		return false; // Se chegou até aqui, a árvore não está balanceada

	}

	// Mesmo método utilizado em questões anteriores, acho que deveria ter colocado direto dentro de árvore binária :P

	private int recursivoAlturaNo(NodeBinario<T> data, int altura) {
		if (data == null) {
			return 0;
		}

		if (data.getEsq() == null && data.getDir() == null) {
			return altura;
		}
		int alturaNodeAtual = recursivoAlturaNo(data.getEsq(), altura + 1);

		if (alturaNodeAtual != 0) {
			return alturaNodeAtual;
		}
		alturaNodeAtual = recursivoAlturaNo(data.getDir(), altura + 1);
		return alturaNodeAtual;

	}

	private int calcularAlturaNo(NodeBinario<T> data) {
		return recursivoAlturaNo(data, 0); // Inicia o método recursivo com valor inicial 0
	}

}
