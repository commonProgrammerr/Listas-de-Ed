package upe.ecomp.ed.questao6;

public class ListaDuplaString {

	private Node primeiro;
	private int qtdElementos;

	public ListaDuplaString() {
		this.primeiro = null;
		this.qtdElementos = 0;

	}

	public void addElemento(String a) {
		Node novo = new Node(a);

		if (this.qtdElementos == 0) {
			novo.proximo = null;
			this.primeiro = novo;
		} else {
			primeiro.anterior = novo;
			novo.proximo = primeiro;
			primeiro = novo;
		}
		this.qtdElementos++;

	}

	public void imprimeLista() {
		Node aux = primeiro;
		System.out.print("[");
		for (int count = 0; count < this.qtdElementos; count++) {
			if(aux.proximo!=null) {
			System.out.print(aux.string + ",");
			}else {
				System.out.print(aux.string);
			}
			
			aux = aux.proximo;
		}
		System.out.print("] \n");

	}

	public boolean contains(String a) {

		return this.indexOf(a) != -1;

	}

	public int indexOf(String a) {
		int index = -1;
		Node aux = primeiro;
		for (int count = 0; count < this.qtdElementos; count++) {
			if (aux.string.equals(a)) {
				index = count;
				break;
			} else {
				aux = aux.proximo;
			}
		}
		return index;
	}

	public String buscaElemento(int indice) {
		Node aux = primeiro;
		String elemento = "Elemento n�o contido";
		for (int count = 0; count < this.qtdElementos; count++) {
			if (count == indice) {
				elemento = aux.string;
				break;
			} else {
				aux = aux.proximo;
			}
		}

		return elemento;
	}

	public void removeElemento(String elemento) {
		if (this.contains(elemento)) {
			if (primeiro.string.equals(elemento)) {
				primeiro.proximo.anterior = null;
				primeiro = primeiro.proximo;

			} else {
				Node aux = primeiro;
				while (aux.proximo != null) {
					if (aux.proximo.string.equals(elemento)) {
						aux.proximo.anterior = aux.anterior;
						aux.proximo = aux.proximo.proximo;

						break;
					} else {
						aux = aux.proximo;
					}
				}
			}
			this.qtdElementos--;
		}
	}

	public static ListaDuplaString comparaListas(ListaDuplaString a, ListaDuplaString b) {
		ListaDuplaString c = new ListaDuplaString();
		Node aux = a.primeiro;
		for (int count = 0; count < a.qtdElementos; count++) {
			for (int count2 = 0; count2 < b.qtdElementos; count2++) {
				if (b.contains(aux.string)) {
					if (!c.contains(aux.string)) {
						c.addElemento(aux.string);
					}
				}
			}
			aux = aux.proximo;
		}

		return c;
	}

	public static void main(String[] args) {
		ListaDuplaString a = new ListaDuplaString();
		ListaDuplaString b = new ListaDuplaString();
		a.addElemento("a");
		a.addElemento("b");
		a.addElemento("v");
		a.addElemento("esse vai ser removido");
		a.imprimeLista();
		a.removeElemento("esse vai ser removido");
		a.imprimeLista();
		b.addElemento("a");
		b.addElemento("v");
		b.imprimeLista();
		System.out.println(a.buscaElemento(0));
		System.out.println(a.buscaElemento(1));
		System.out.println(a.buscaElemento(2));
		comparaListas(a, b).imprimeLista();

	}

}
