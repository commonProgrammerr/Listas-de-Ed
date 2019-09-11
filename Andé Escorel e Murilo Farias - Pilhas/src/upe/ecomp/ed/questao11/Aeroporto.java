package upe.ecomp.ed.questao11;

import upe.ecomp.ed.resources.*;

public class Aeroporto {

	private FilaDinamica<Aviao> decolagem;
	private FilaDinamica<Aviao> espera;

	public Aeroporto() {
		this.decolagem = new FilaDinamica<Aviao>();
		this.espera = new FilaDinamica<Aviao>();
	}

	public void addDecolagem(Aviao e) {
		this.decolagem.inserir(e);
	}

	public void addEspera(Aviao e) {
		this.espera.inserir(e);
	}

	public void autorizaDecolagem() {
		listaDecolagem();
		System.out.println("Avião decolando!");
		decolagem.remover();
		listaDecolagem();
	}
	
	public void moveListas() {
		this.listaDecolagem();
		this.listaEspera();
		System.out.println("MOVENDO AVIÃO PARA LISTA DE ESPERA");
		addDecolagem(espera.inicio());
		espera.remover();
		this.listaDecolagem();
		this.listaEspera();
				
	}

	public void listaDecolagem() {
	System.out.println("LISTA DE DECOLAGEM:");
	decolagem.imprimir();
	}
	
	public void listaEspera() {
		System.out.println("LISTA DE ESPERA: ");
		espera.imprimir();	
	}

	public FilaDinamica<Aviao> getDecolagem() {
		return decolagem;
	}

	public FilaDinamica<Aviao> getEspera() {
		return espera;
	}

}
