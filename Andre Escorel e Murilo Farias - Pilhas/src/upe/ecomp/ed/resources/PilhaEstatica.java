package upe.ecomp.ed.resources;

import java.util.Iterator;

public class PilhaEstatica<T> implements TADPilha<T>, Iterable<T> {

	private T[] dados;
	private int qtd;
	
	public PilhaEstatica() {
		dados = (T[]) new Object[5];
	}

	public PilhaEstatica(int size) {
		dados = (T[]) new Object[size];
	}
	
	public void push(T e) {
		if (! isFull()) {
			dados[qtd] = e;
			qtd++;
		} else {
			T[] temp = (T[]) new Object[(int) (1.5 * dados.length)];
			for (int i = 0; i < qtd; i++) {
				temp[i] = dados[i];
			}
			dados = temp;
			push(e);
		}
	}

	public T pop() {
		T r = null;
		if (! isEmpty()) {
			qtd--;
			r = dados[qtd];
			dados[qtd] = null;
		}
		return r;
	}

	public T top() {
		T r = null;
		if (! isEmpty()) {
			r = dados[qtd-1];
		}
		return r;
	}

	public int size() {
		return qtd;
	}

	public boolean isEmpty() {
		return qtd == 0;
	}

	public boolean isFull() {
		return qtd == dados.length;
	}

	public String toString() {
		String s = "topo ";
		for (int i = qtd-1; i >= 0; i--) {
			s += "-> " + dados[i];
		}
		return s;
	}
	
	public void imprime() {
		System.out.println(this.toString());
	}

	public Iterator<T> iterator() 
    { 
        return new Iterator<T>() {
            int current = 0;
        
            public boolean hasNext() 
            { 
                return current < size(); 
            } 
            
            public T next() 
            { 
                return dados[current++];
            } 
            
            public void remove() 
            { 
                throw new UnsupportedOperationException(); 
            }
        }; 
    }

}
