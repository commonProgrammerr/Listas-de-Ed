package upe.ecomp.ed.questao09;

import upe.ecomp.ed.resources.*;

public class MetodoLista {

	public static ListaDinamica<Integer> retornaLista(ListaDinamica<Integer> lista) {
		ListaDinamica<Integer> lista2 = new ListaDinamica<Integer>();

		for (int i = 0; i < lista.getQtd(); i++) {
			if (!lista2.contains(lista.procurarIEsimo(i))) {
				lista2.inserir(lista.procurarIEsimo(i));
			}
		}

		return lista2;

	}

}
