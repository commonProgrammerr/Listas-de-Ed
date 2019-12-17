package upe.ecomp.ed.questao08;

import upe.ecomp.ed.resources.*;

public class Questao8 extends ArvoreBinaria<Integer> {

	public ListaDinamica<Integer> retornaLista() {
		Integer[] niveis = new Integer[calcularAlturaNo(getRaiz())+1]; //Cria um array de Integer com dimens�o igual a altura da �rvore +1 e seta todos os valores como 0;
		for (int i = 0; i < niveis.length; i++) {
			niveis[i]=0;
		}
		ListaDinamica<Integer> lista = new ListaDinamica<Integer>(); // cria a lista dinamica
		addLista(niveis, getRaiz(),getRaiz()); // Adiciona os n�s da �rvore na lista
		for (int i = 0; i < niveis.length; i++) {
			lista.inserirFinal(niveis[i]); //Passa os valores do array para a lista ligada
		}
		return lista;
	}

	private void addLista(Integer[] niveis, NodeBinario<Integer> data,NodeBinario<Integer> root)  {

		if (data != null) {
			niveis[calcularProfundidadeNo(data.getInfo(), root)]+=data.getInfo(); //Soma o valor contido no n� ao contido no espa�o do array na casa correspondente
			addLista(niveis,data.getEsq(), getRaiz());	//� profundidade do n�.
			addLista(niveis,data.getDir(), getRaiz());
		}

	}

	

//M�todos para altura e profundidade, j� utilizados em questo�es anteriores

	public int recursivoProfundidadeNo(Integer data, NodeBinario<Integer> root, int profundidade) {
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

	public int calcularProfundidadeNo(Integer data, NodeBinario<Integer> root) {
		return recursivoProfundidadeNo(data, root, 0); // Inicia o m�todo recursivo com valor inicial 1
	}

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
