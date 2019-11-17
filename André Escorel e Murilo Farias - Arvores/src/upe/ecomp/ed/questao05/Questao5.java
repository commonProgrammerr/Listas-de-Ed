package upe.ecomp.ed.questao05;

import upe.ecomp.ed.resources.ArvoreBinaria;
import upe.ecomp.ed.resources.ListaDinamica;
import upe.ecomp.ed.resources.NodeBinario;

public class Questao5 extends ArvoreBinaria<Integer> {

//a)
	public ListaDinamica<Integer> retornaListaOrdem() {
		ListaDinamica<Integer> retorno = new ListaDinamica<Integer>();
		listaEmOrdem(getRaiz(), retorno);
		listaPreOrdem(getRaiz(), retorno);
		listaPosOrdem(getRaiz(), retorno);
		return retorno;
	}

	private void listaPreOrdem(NodeBinario<Integer> no, ListaDinamica<Integer> a) {
		if (no != null) {
			a.inserir(no.getInfo());
			listaPreOrdem(no.getEsq(), a);
			listaPreOrdem(no.getDir(), a);
		}
	}

	private void listaPosOrdem(NodeBinario<Integer> no, ListaDinamica<Integer> a) {
		if (no != null) {
			listaPosOrdem(no.getEsq(), a);
			listaPosOrdem(no.getDir(), a);
			a.inserir(no.getInfo());
		}
	}

	private void listaEmOrdem(NodeBinario<Integer> no, ListaDinamica<Integer> a) {
		if (no != null) {
			listaEmOrdem(no.getEsq(), a);
			a.inserir(no.getInfo());
			listaEmOrdem(no.getDir(), a);
		}
	}

//b)
	
	public ListaDinamica<Integer> listaProfxAltura(){
		ListaDinamica<Integer> retorno = new ListaDinamica<Integer>();
		listaPreOrdemB(getRaiz(),retorno);
		return retorno;
	}
	
	private void listaPreOrdemB(NodeBinario<Integer> no, ListaDinamica<Integer> a) { 
		if (no != null) { //Percorre a �rvore em pr� ordem e adiciona na lista caso a altura seja igual a profundidade
			if(calcularAlturaNo(no)==calcularProfundidadeNo(no, getRaiz())) {
				a.inserir(no.getInfo());
			}
			listaPreOrdemB(no.getEsq(), a);
			listaPreOrdemB(no.getDir(), a);
		}
	}
	
	
//Auxiliares
	
//M�todo para calcular a profundidade de um n�. Mesmo utilizado na quest�o 4, apenas adaptado para receber int

	private int recursivoProfundidadeNo(NodeBinario<Integer> data, NodeBinario<Integer> root, int profundidade) {
		if (root == null) {
			return 0; // Retorna 0 se o n� estiver vazio
		}
		if (data.getInfo().equals(root.getInfo())) {
			return profundidade; // Retorna a profundidade caso o objeto seja igual ao n� em quest�o
		}

		int profundidadeNode = recursivoProfundidadeNo(data, root.getEsq(), profundidade + 1);
		// Percorre a �rvore no sentido esquerda, procurando o n� em quest�o e
		// aumentando a profundidade em +1.
		if (profundidadeNode != 0) {
			return profundidadeNode; // Retorna a profundidade caso o n� tenha sido encontrado, ou seja, n�o ir�
										// percorrer para a direita
		}
		profundidadeNode = recursivoProfundidadeNo(data, root.getDir(), profundidade + 1); // Igual a parte anterior,
																							// mas para a direita
		return profundidadeNode; // N�o precisa da condi��o do n� ter sido encontrado, j� que ser� a ultima vez
									// que o m�todo vai percorrer a �rvore
	}

	private int calcularProfundidadeNo(NodeBinario<Integer> data, NodeBinario<Integer> root) {
		return recursivoProfundidadeNo(data, root, 0); // Inicia o m�todo recursivo com valor inicial 1
	}

//M�todo para calcular a altura de um n�.
//Mesma l�gica do m�todo anterior, mas retorna a altura caso o n� em quest�o seja uma folha
	
	
	private int recursivoAlturaNo(NodeBinario<Integer> data, int altura) {
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

	private int calcularAlturaNo(NodeBinario<Integer> data) {
		return recursivoAlturaNo(data, 0); // Inicia o m�todo recursivo com valor inicial 0
	}

}
