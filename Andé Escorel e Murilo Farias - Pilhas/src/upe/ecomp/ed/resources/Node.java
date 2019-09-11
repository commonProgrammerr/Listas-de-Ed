package upe.ecomp.ed.resources;

public class Node<T> {
	public Node(T e) {
		info = e;
	}
	protected T info;
	protected Node<T> proximo;
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public Node<T> getProximo() {
		return proximo;
	}
	public void setProximo(Node<T> proximo) {
		this.proximo = proximo;
	}
	
}
