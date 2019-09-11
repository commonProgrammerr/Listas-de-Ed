package upe.ecomp.ed.Questao10;

import upe.ecomp.ed.resources.*;

public class ListaCaracteres {

	public static ListaDinamica<Character> mudaSequencia(ListaDinamica<Character> a){
		
		ListaDinamica<Character> retorno = new ListaDinamica<Character>();
		PilhaDinamica<Character> letras = new PilhaDinamica<Character>();
		ListaDinamica<Character> numeros = new ListaDinamica<Character>();
		
		
		
		for (int i = 0; i < a.getQtd(); i++) {
			if(Character.isLetter(a.getInicio().getInfo())) {
				letras.push(a.getInicio().getInfo());
				a.remover(a.getInicio().getInfo());
			}else if(Character.isDigit(a.getInicio().getInfo())) {
				numeros.inserir(a.getInicio().getInfo());
				a.remover(a.getInicio().getInfo());
			}	
		}


		for (int i = 1; i <= numeros.getQtd(); i++) {
			retorno.inserir(numeros.procurarIEsimo(numeros.getQtd()-i));
		}
		
		int sizepilha=letras.size();
		
		for (int i = 0; i < sizepilha; i++) {
			retorno.inserir(letras.pop());
		}
		
		return retorno;
			
	}
	
	
	
	
}
