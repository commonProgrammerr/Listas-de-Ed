package upe.ecomp.ed.questao04;

import upe.ecomp.ed.resources.*;

public class Questao4<T> extends ArvoreBinaria<T> {

	// a)

	public int returnNumNos(NodeBinario<T> no) {
		int num = 1;
		if (no == null) { // Retorna -1 se a raiz for null
			return -1; // Percorre a �rvore primeiro para a esquerda e depois para a direita, somando
						// +1 � vari�vel num em cada n�.
		}
		if (no.getEsq() != null) {
			num += returnNumNos(no.getEsq());
		}
		if (no.getDir() != null) {
			num += returnNumNos(no.getDir());
		}
		return num;
	}

	// b)

	public int returnNumFolhas(NodeBinario<T> no) {
		int num = 0;
		if (no.getEsq() == null && no.getDir() == null) { // Retorna 1 apenas se esquerda e direita forem null
			return 1; // Percorre a �rvore primeiro para a esquerda e depois para a direita, somando
						// +1 � vari�vel num em cada folha.
		} else {
			if (no.getEsq() != null) {
				num += returnNumFolhas(no.getEsq());
			}
			if (no.getDir() != null) {
				num += returnNumFolhas(no.getDir());
			}
		}

		return num;
	}

	// c)

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

}
