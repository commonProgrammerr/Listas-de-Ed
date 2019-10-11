package upe.ecomp.ed.resources;

public interface TADFila<T> {

	public void inserir(T e);
	
	public T remover();
	
	public T inicio();
	
	public int size();
	
	public void imprimir();
}
