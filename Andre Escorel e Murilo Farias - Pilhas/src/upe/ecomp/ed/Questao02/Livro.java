package upe.ecomp.ed.Questao02;

public class Livro {

	private String nome, anoDeLancamento;
	
	
	public Livro(String nome, String anoDeLancamento) {
		this.anoDeLancamento=anoDeLancamento;
		this.nome=nome;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getAnoDeLancamento() {
		return anoDeLancamento;
	}


	public void setAnoDeLancamento(String anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}
	@Override
	public String toString() {
		return this.nome + " | "+ this.anoDeLancamento;
	}
	
	
	
}
