package upe.ecomp.ed.questao09;

import upe.ecomp.ed.resources.*;

public class Questao9<T> extends ArvoreBinaria<T> {

//TODO:a)

	
	public int numNosImpares() {
		
		/* Cria uma lista dinâmica
		 * percorre a árvore e procura por nós de profundidade ímpar
		 * caso encontre, adiciona na lista dinâmica, que será retornada no final do método auxiliar
		 * retorna o size da lista dinâmica
		 */
		
		ListaDinamica<T> a = new ListaDinamica<T>();
		return percorrePreOrdemA(getRaiz(), a).getQtd();
	}
	
	
	private ListaDinamica<T> percorrePreOrdemA(NodeBinario<T> no, ListaDinamica<T> a) { 
		if (no != null) { 
			if(calcularProfundidadeNo(no.getInfo(), getRaiz())%2!=0) {
				//calcularProfundidadeNo(no.getInfo(), getRaiz()); //Remover comentário p conferir nós ímpares
				a.inserir(no.getInfo());
			}
			percorrePreOrdemA(no.getEsq(), a);
			percorrePreOrdemA(no.getDir(), a);
		}
		return a;
	}
	
//Mesmo método utilizado na questão 04
	public int recursivoProfundidadeNo(T data, NodeBinario<T> root, int profundidade) {
		if (root == null) {
			return 0;  // Retorna 0 se o nó estiver vazio
		}
		if (data.equals(root.getInfo())) {
			return profundidade; // Retorna a profundidade caso o objeto seja igual ao nó em questão
		}

		int profundidadeNode = recursivoProfundidadeNo(data, root.getEsq(), profundidade + 1); 
		//Percorre a árvore no sentido esquerda, procurando o nó em questão e aumentando a profundidade em +1.
		if (profundidadeNode != 0) {
			return profundidadeNode; //Retorna a profundidade caso o nó tenha sido encontrado, ou seja, não irá percorrer para a direita
		}
		profundidadeNode = recursivoProfundidadeNo(data, root.getDir(), profundidade + 1); //Igual a parte anterior, mas para a direita
		return profundidadeNode; //Não precisa da condição do nó ter sido encontrado, já que será a ultima vez que o método vai percorrer a árvore
	}

	public int calcularProfundidadeNo(T data, NodeBinario<T> root) {
		return recursivoProfundidadeNo(data, root, 0); // Inicia o método recursivo com valor inicial 1
	}

	
	
//TODO:b)
	
	public ArvoreBinaria<T> arvoreDif(ArvoreBinaria<T> arv2) {

		return questao9(getRaiz(), arv2, new ArvoreBinaria<T>());

	}

	// Percorre a árvore 1 em pré ordem, comparando cada nó com os nós da árvore 2,
	// também percorrida em pré ordem
	// Caso arv1 não esteja contido em arv2, adiciona em arv3
	
	public ArvoreBinaria<T> questao9(NodeBinario<T> noarv1, ArvoreBinaria<T> arv2, ArvoreBinaria<T> arv3) {

		if (noarv1 != null) {
			if (!arv2.contains(noarv1.getInfo())) {
				arv3.inserir(noarv1.getInfo());
			}
			questao9(noarv1.getEsq(), arv2, arv3);
			questao9(noarv1.getDir(), arv2, arv3);
		}

		return arv3;
	}

}
