package ecomp.ed.arvore;

public class NoBinario<T> {

	private T info;
	private NoBinario<T> esq, dir;
	
	public NoBinario(T e) {
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

	public NoBinario<T> getEsq() {
		return esq;
	}

	public void setEsq(NoBinario<T> esq) {
		this.esq = esq;
	}

	public NoBinario<T> getDir() {
		return dir;
	}

	public void setDir(NoBinario<T> dir) {
		this.dir = dir;
	}
	
}
