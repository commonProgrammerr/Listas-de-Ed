import java.lang.reflect.Method;

import upe.ecomp.ed.questao04.Questao4;
import upe.ecomp.ed.questao05.Questao5;
import upe.ecomp.ed.questao06.Questao6;
import upe.ecomp.ed.questao07.Questao07;
import upe.ecomp.ed.questao08.Questao8;
import upe.ecomp.ed.questao09.Questao9;
import upe.ecomp.ed.questao10.Questao10;
import upe.ecomp.ed.questoes123.ArvoreExpressionante;
import upe.ecomp.ed.resources.ArvoreBinaria;

public class Main {
	
	

	public static void main(String[] args){
		Method[] metodos = Main.class.getMethods();
		for (int i = 0; i < metodos.length; i++)
			if(!metodos[i].getName().equals("addArvore"))
				try {
					metodos[i].invoke(null);	
				} catch (Exception e) {
					e.printStackTrace();
				}	
			
		
	}
	public static void testarQuestao123() {
		System.out.println("TESTES QUESTÕES 1, 2 E 3\n");
		System.out.println("Expressão: ( ( 3 * 2 ) - ( ( 4 / 2 ) + ( -10 / 5 ) ) )");
		ArvoreExpressionante exp = new ArvoreExpressionante("( ( 3 * 2 ) - ( ( 4 / 2 ) + ( -10 / 5 ) ) )");
		System.out.println("Arvore:\n");
		exp.imprimir();
		System.out.println("Relosução: " + exp.resolver());
		System.out.println("Nova expressão:  ( 4 * a ) - ( 6 + b ) + ( 8 / ( 9 - 7 ) )");
		exp = new ArvoreExpressionante("( ( 4 * a ) - ( 6 + b ) ) + ( 8 / ( 9 - 7 ) )");
		exp.imprimir();
		System.out.println("Relosução: " + exp.resolver());
	}
	
	public static void testarQuestao04() {
		System.out.println("TESTES QUEST�O 04\n");
		Questao4<Integer> questao04 = new Questao4<Integer>();
		addArvore(questao04);
		System.out.println("Numero de n�s: "+ questao04.returnNumNos(questao04.getRaiz()));
		System.out.println("Numero de folhas: " + questao04.returnNumFolhas(questao04.getRaiz()));
		System.out.println("Profundidade do n� contendo o numero 2: "+ questao04.calcularProfundidadeNo(2, questao04.getRaiz()));
	}
	
	public static void testarQuestao05() {
		System.out.println("TESTE QUESTAO 05\n");
		Questao5 questao05 = new Questao5();
		addArvore(questao05);
		questao05.retornaListaOrdem().imprimeLista();
		questao05.listaProfxAltura().imprimeLista();
	}
	
	public static void testarQuestao06Stri(){
		System.out.println("TESTE QUESTAO 06");
		Questao6<Integer> questao06 = new Questao6<Integer>();
		addArvore(questao06);
		System.out.println("A �rvore � AVL? "+questao06.isAVL());
		questao06.transformaAVL(questao06.getRaiz());
		System.out.println("A �rvore � AVL? "+questao06.isAVL());
	}

	public static void testarQuestao07() {
		System.out.println("TESTE QUESTAO 07");
		Questao07<Integer> questao7 = new Questao07<>();
		addArvore(questao7);
		questao7.imprimir();
		System.out.print("Folha mais proxima da raiz: ");
		System.out.println(questao7.l());
		System.out.print("Folha mais longe da raiz: ");
		System.out.println(questao7.h());
	}
	
	public static void testarQuestao08() {
		System.out.println("TESTE QUESTAO 08");
		Questao8 questao08 = new Questao8();
		addArvore(questao08);
		questao08.retornaLista().imprimeLista();
	}
	
	public static void testarQuestao09() {
		System.out.println("TESTE QUESTAO 09");
		Questao9<Integer> questao09 = new Questao9<Integer>();
		addArvore(questao09);
		System.out.println("Numero de n�s �mpares da �rvore: "+questao09.numNosImpares()+"\n");
		System.out.println("IMPRIMINDO �RVORE 1 \n");
		questao09.imprimir();
		System.out.println("\nIMPRIMINDO �RVORE 2 \n");
		ArvoreBinaria<Integer> arvore2 = new ArvoreBinaria<Integer>();
		arvore2.inserir(6);
		arvore2.inserir(3);
		arvore2.inserir(2);
		arvore2.inserir(1);
		arvore2.inserir(4);
		arvore2.inserir(5);
		arvore2.inserir(8);
		arvore2.imprimir();
		System.out.println("\nIMPRIMINDO RESULTANTE \n");
		questao09.arvoreDif(arvore2).imprimir();
		
	}
	
	public static void testarQuestao10() {
		System.out.println("TESTES QUEST�O 10\n�RVORE N�O CONTIDA\n");
		Questao10<Integer> questao10 = new Questao10<Integer>();
		addArvore(questao10);
		Questao10<Integer> remover = new Questao10<Integer>();
		remover.inserir(6);
		remover.inserir(3);
		remover.contains(2);
		remover.inserir(133);
		questao10.removeSubArvore(remover);
		remover.remover(133);
		System.out.println("\nTESTE COM �RVORE CONTIDA\n");
		questao10.removeSubArvore(remover);
		
	}
	
	public static void addArvore(ArvoreBinaria<Integer> arvore) { //Para facilitar, utilizamos sempre a mesma �rvore nas quest�es. O desenho da �rvore est� contido no package resources
		arvore.inserir(11);								  //N�o � uma �rvore AVL.
		arvore.inserir(6);
		arvore.inserir(3);
		arvore.inserir(2);
		arvore.inserir(1);
		arvore.inserir(4);
		arvore.inserir(5);
		arvore.inserir(8);
		arvore.inserir(7);
		arvore.inserir(9);
		arvore.inserir(17);
		arvore.inserir(25);
	}
	
	

}
