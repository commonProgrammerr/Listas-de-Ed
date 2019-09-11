package upe.ecomp.ed.questao01;

import upe.ecomp.ed.resources.*;

public class CadeiaPalavras {

	private PilhaDinamica<String> pilha;
	private int alteracoes;

	public CadeiaPalavras() {
		this.pilha = new PilhaDinamica<String>();
		this.alteracoes=0;
	}
	
	public void addTexto(String a) {
		if(this.pilha.isEmpty()) {
			this.pilha.push(a);
		}else {
			this.pilha.push(pilha.top()+"_"+a);
		}
		
		this.alteracoes++;
	}
	
	public void desfazRecente() {
		pilha.pop();
		this.alteracoes++;
	}
	
	public void infoAlteracoes() {
		System.out.println("Foram feitas "+this.alteracoes+" alterações na estrutura");
	}
	
	public void print() {
		pilha.imprime();
	}
	
	

}
