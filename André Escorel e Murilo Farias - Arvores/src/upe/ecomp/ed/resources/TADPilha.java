package upe.ecomp.ed.resources;

public interface TADPilha<T> {
	
	public void push(T e);
	public T pop();
	public T top();
	public int size();
	public boolean isEmpty();
	public boolean isFull();
	public void imprime();
}
