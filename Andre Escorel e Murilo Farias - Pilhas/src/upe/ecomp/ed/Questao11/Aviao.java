package upe.ecomp.ed.Questao11;

public class Aviao {

	private String nome;

	public Aviao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}

}
