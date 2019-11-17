package upe.ecomp.ed.resources;

public class NodeBinario<T> {

	private T info;
	private NodeBinario<T> esq, dir;
	
	public NodeBinario(T e) {
		info = e;
	}
	
	public String toString() {
		return "" + info;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public NodeBinario<T> getEsq() {
		return esq;
	}

	public void setEsq(NodeBinario<T> esq) {
		this.esq = esq;
	}

	public NodeBinario<T> getDir() {
		return dir;
	}

	public void setDir(NodeBinario<T> dir) {
		this.dir = dir;
	}
	
}
