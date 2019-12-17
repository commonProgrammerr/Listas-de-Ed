package upe.ecomp.ed.questao10;
import upe.ecomp.ed.resources.*;

public class Questao10<T> extends ArvoreBinaria<T> {

	public void removeSubArvore(ArvoreBinaria<T> arvore) {
		System.out.println("IMPRIMINDO �RVORE\n");
		this.imprimir();
		System.out.println("\nIMPRIMINDO �RVORE A SER REMOVIDA\n");
		arvore.imprimir();
		ListaDinamica<T> listaAux = new ListaDinamica<T>(); //Listas auxiliares que ir�o receber as �rvores planificadas
		ListaDinamica<T> listaAux2 = new ListaDinamica<T>();
		if(isArvoreContida(planificaArvore(this.getRaiz(),listaAux), planificaArvore(arvore.getRaiz(), listaAux2))) { //Verifica a �rvore a ser removida est� contida na �rvore atual
			removeTree(this, arvore.getRaiz());
			System.out.println("Removido com sucesso");
			this.imprimir();
		}else {
			System.out.println("A sub�rvore n�o est� contida. N�o houve remo��o");
		}
	}
	
	public void removeTree(ArvoreBinaria<T> arvore, NodeBinario<T> remove) { //Percorre a �rvore atual em pr� ordem e remove cada elemento da �rvore a remover
		if(remove!=null) {
			arvore.remover(remove.getInfo());
			removeTree(arvore, remove.getEsq());
			removeTree(arvore, remove.getDir());
		}
		
	}
	
	
	
	public boolean isArvoreContida(ListaDinamica<T> arvore, ListaDinamica<T> subarvore) {
		boolean retorno=false;
		Node<T> aux = arvore.getInicio();
		Node<T> auxSub = subarvore.getInicio();
		int i = arvore.indexOf(auxSub.getInfo());
		if(i==-1) {
			return false;
		}else {
			int count=0;
			while(count<i) {
				aux=aux.getProximo();
				count++;
			}
		}
		
		for (i = 0; i < subarvore.getQtd(); i++) { //For para percorrer as listas
			 if(aux.getInfo().equals(auxSub.getInfo())) {	//Inicia no indexOf do primeiro elemento da lista a ser removida, e finaliza no indexOf+tamanho da lista
				 retorno = true;							//ou seja, percorre apenas x elementos, onde x � a quantidade de elementos contida na lista a ser removida.
				 aux=aux.getProximo();						//retorna true se os elementos forem iguais e passa para o pr�ximo n�
				 auxSub=auxSub.getProximo();
			 }else {
				 retorno = false;							//retorna false se qualquer elemento for diferente e quebra o loop
				 break;
			 }
		}
		return retorno;
	}
	
	
	
	public ListaDinamica<T> planificaArvore(NodeBinario<T> root,ListaDinamica<T> listaAux) { //Percorre a �rvore em pr� ordem e adiciona cada elemento em uma lista ligada
		//Comparar a sequencia na lista planificada me pareceu mais simples que comparar a sequencia de n�s das �rvores
		if(root!=null) {
			listaAux.inserirFinal(root.getInfo());
			planificaArvore(root.getEsq(),listaAux);
			planificaArvore(root.getDir(),listaAux);
		}
		return listaAux;
		
	}
	
	
}
