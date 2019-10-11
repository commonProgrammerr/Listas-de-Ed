package ecomp.ed.arvore;

public class TesteArvore {

	public static void main(String[] args) {
		TADArvore<Integer> arvore = new ArvoreBinaria<Integer>();
		arvore.inserir(11);
		arvore.inserir(6);
		arvore.inserir(3);
		arvore.inserir(2);
		arvore.inserir(1);
		arvore.inserir(4);
		arvore.inserir(5);
		arvore.inserir(8);
		arvore.inserir(7);		
		arvore.inserir(9);
		arvore.inserir(10);
		arvore.inserir(20);
		arvore.inserir(15);
		arvore.inserir(17);
		arvore.inserir(25);
		System.out.println(arvore.contains(5));
		System.out.println(arvore.contains(11));
		System.out.println(arvore.contains(6));
		arvore.imprimir();
		
		arvore.remover(5);
		arvore.remover(11);
		arvore.remover(6);
		System.out.println(arvore.contains(5));
		System.out.println(arvore.contains(11));
		System.out.println(arvore.contains(6));
		arvore.imprimir();
		
	}

}
