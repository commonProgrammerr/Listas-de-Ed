package ecomp.ed.arvore;

public interface TADArvore<T> {

	public void imprimir();
	
	public void esvaziar();
	
	public void inserir(T e);
	
	public void remover(T e);
	
	public boolean contains(T e);
		
}
