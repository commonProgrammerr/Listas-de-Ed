package upe.ecomp.ed.questao11;

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
		// TODO Auto-generated method stub
		return this.nome;
	}

}
