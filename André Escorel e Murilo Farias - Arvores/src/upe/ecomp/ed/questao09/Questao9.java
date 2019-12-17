package upe.ecomp.ed.questao09;

import upe.ecomp.ed.resources.*;

public class Questao9<T> extends ArvoreBinaria<T> {

//TODO:a)

	
	public int numNosImpares() {
		
		/* Cria uma lista din�mica
		 * percorre a �rvore e procura por n�s de profundidade �mpar
		 * caso encontre, adiciona na lista din�mica, que ser� retornada no final do m�todo auxiliar
		 * retorna o size da lista din�mica
		 */
		
		ListaDinamica<T> a = new ListaDinamica<T>();
		return percorrePreOrdemA(getRaiz(), a).getQtd();
	}
	
	
	private ListaDinamica<T> percorrePreOrdemA(NodeBinario<T> no, ListaDinamica<T> a) { 
		if (no != null) { 
			if(calcularProfundidadeNo(no.getInfo(), getRaiz())%2!=0) {
				//calcularProfundidadeNo(no.getInfo(), getRaiz()); //Remover coment�rio p conferir n�s �mpares
				a.inserir(no.getInfo());
			}
			percorrePreOrdemA(no.getEsq(), a);
			percorrePreOrdemA(no.getDir(), a);
		}
		return a;
	}
	
//Mesmo m�todo utilizado na quest�o 04
	public int recursivoProfundidadeNo(T data, NodeBinario<T> root, int profundidade) {
		if (root == null) {
			return 0;  // Retorna 0 se o n� estiver vazio
		}
		if (data.equals(root.getInfo())) {
			return profundidade; // Retorna a profundidade caso o objeto seja igual ao n� em quest�o
		}

		int profundidadeNode = recursivoProfundidadeNo(data, root.getEsq(), profundidade + 1); 
		//Percorre a �rvore no sentido esquerda, procurando o n� em quest�o e aumentando a profundidade em +1.
		if (profundidadeNode != 0) {
			return profundidadeNode; //Retorna a profundidade caso o n� tenha sido encontrado, ou seja, n�o ir� percorrer para a direita
		}
		profundidadeNode = recursivoProfundidadeNo(data, root.getDir(), profundidade + 1); //Igual a parte anterior, mas para a direita
		return profundidadeNode; //N�o precisa da condi��o do n� ter sido encontrado, j� que ser� a ultima vez que o m�todo vai percorrer a �rvore
	}

	public int calcularProfundidadeNo(T data, NodeBinario<T> root) {
		return recursivoProfundidadeNo(data, root, 0); // Inicia o m�todo recursivo com valor inicial 1
	}

	
	
//TODO:b)
	
	public ArvoreBinaria<T> arvoreDif(ArvoreBinaria<T> arv2) {

		return questao9(getRaiz(), arv2, new ArvoreBinaria<T>());

	}

	// Percorre a �rvore 1 em pr� ordem, comparando cada n� com os n�s da �rvore 2,
	// tamb�m percorrida em pr� ordem
	// Caso arv1 n�o esteja contido em arv2, adiciona em arv3
	
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
