package upe.ecomp.ed.questao08;

import upe.ecomp.ed.resources.*;

public class Questao8 extends ArvoreBinaria<Integer> {

	public ListaDinamica<Integer> retornaLista() {
		Integer[] niveis = new Integer[calcularAlturaNo(getRaiz())+1]; //Cria um array de Integer com dimensão igual a altura da árvore +1 e seta todos os valores como 0;
		for (int i = 0; i < niveis.length; i++) {
			niveis[i]=0;
		}
		ListaDinamica<Integer> lista = new ListaDinamica<Integer>(); // cria a lista dinamica
		addLista(niveis, getRaiz(),getRaiz()); // Adiciona os nós da árvore na lista
		for (int i = 0; i < niveis.length; i++) {
			lista.inserirFinal(niveis[i]); //Passa os valores do array para a lista ligada
		}
		return lista;
	}

	private void addLista(Integer[] niveis, NodeBinario<Integer> data,NodeBinario<Integer> root)  {

		if (data != null) {
			niveis[calcularProfundidadeNo(data.getInfo(), root)]+=data.getInfo(); //Soma o valor contido no nó ao contido no espaço do array na casa correspondente
			addLista(niveis,data.getEsq(), getRaiz());	//à profundidade do nó.
			addLista(niveis,data.getDir(), getRaiz());
		}

	}

	

//Métodos para altura e profundidade, já utilizados em questoões anteriores

	public int recursivoProfundidadeNo(Integer data, NodeBinario<Integer> root, int profundidade) {
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

	public int calcularProfundidadeNo(Integer data, NodeBinario<Integer> root) {
		return recursivoProfundidadeNo(data, root, 0); // Inicia o método recursivo com valor inicial 1
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
		return recursivoAlturaNo(data, 0); // Inicia o método recursivo com valor inicial 0
	}

	

}
