package upe.ecomp.ed.Questao02;

import upe.ecomp.ed.resources.*;

public class Biblioteca {

	 PilhaDinamica<Livro> pilhaDeLivros;
	
	public Biblioteca() {
		pilhaDeLivros=new PilhaDinamica<Livro>();
	}
	
	public boolean removeLivro(Livro a) {
		int index=pilhaDeLivros.indexOf(a);
		if(index!=-1) {
			PilhaDinamica<Livro> pilhaAuxiliar=new PilhaDinamica<Livro>();
			for(int count=0;count<index;count++) {
				pilhaAuxiliar.push(pilhaDeLivros.top());
				pilhaDeLivros.pop();
			}
			
			pilhaDeLivros.pop();
			for(int count=0;count<index;count++) {
				pilhaDeLivros.push(pilhaAuxiliar.top());
				pilhaAuxiliar.pop();
			}
			
			return true;
		}else {
			return false;
		}
		
		
		
		
	}
	
	public void addLivro(Livro a) {
		pilhaDeLivros.push(a);
	}
	
	public void print() {
		pilhaDeLivros.imprime();
	}
	
	
	
}
