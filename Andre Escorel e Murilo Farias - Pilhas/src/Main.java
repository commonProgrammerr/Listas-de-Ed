import upe.ecomp.ed.Questao01.*;
import upe.ecomp.ed.Questao02.*;
import upe.ecomp.ed.Questao08.*;
import upe.ecomp.ed.Questao09.*;
import upe.ecomp.ed.Questao10.*;
import upe.ecomp.ed.Questao11.*;
import upe.ecomp.ed.Questao3.Questao3;
import upe.ecomp.ed.Questao4.PilhaPilha;
import upe.ecomp.ed.Questao5.ListaR;
import upe.ecomp.ed.Questao6.Questao06;
import upe.ecomp.ed.resources.*;

public class Main {

	
	public static void main(String[] args) {
	
		
		System.out.println("Testes quest�o 1\n");
		CadeiaPalavras q1= new CadeiaPalavras();
		q1.addTexto("Estudando");
		q1.addTexto("Pilhas");
		q1.addTexto("agora!");
		q1.print();
		q1.infoAlteracoes();
		q1.desfazRecente();
		q1.print();
		q1.infoAlteracoes();
		
		
		System.out.println("\nTestes quest�o 2\n");
		Biblioteca biblio = new Biblioteca();
		Livro l3 = new Livro("Livro 3","2019");
		biblio.addLivro(new Livro("Livro 1","2018"));
		biblio.addLivro(new Livro("Livro 2","1987"));
		biblio.addLivro(l3);
		biblio.addLivro(new Livro("Livro 4","2008"));
		biblio.addLivro(new Livro("Livro 5","1523"));
		biblio.print();
		biblio.removeLivro(l3);
		biblio.print();
		System.out.println();



		System.out.println("\nTestes quest�o 3\n");
		PilhaDinamica<Integer> p1 = new PilhaDinamica<>(); 
        PilhaDinamica<Integer> p2 = new PilhaDinamica<>();      
        for (int i = 0; i < 20; i++) {
            p2.push(i);
            if(i > 10)
                p1.push(i);
		}
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(Questao3.insideOf(p1, p2));
        System.out.println(p2.pop() + " removido");
        System.out.println(p1);
        System.out.println(p2);
		System.out.println(Questao3.insideOf(p1, p2));
		

		System.out.println("\nTestes quest�o 4\n");
		PilhaPilha pilhaPilha = new PilhaPilha();
		for (int i = 0; i < 16; i++)
			pilhaPilha.push(i);

		System.out.println(pilhaPilha);
		for (int i = 0; i < 4; i++) 
			pilhaPilha.pop();
		System.out.println(pilhaPilha);
		System.out.println("soma:" + pilhaPilha.sum());


		System.out.println("\nTestes quest�o 5\n");
		ListaR<Integer> tr = new ListaR<>();
		for (int i = 0; i < 10; i++)
			tr.add(i);
		System.out.println(tr);
		for (int i = 0; i < 5; i++)
			tr.remove(i);
		System.out.println(tr);

		System.out.println("\nTestes quest�o 6\n");
		PilhaDinamica<Integer> aux = new PilhaDinamica<>();
		for (int i = 0; i < 16; i++)
			aux.push(i);
		System.out.println(aux);
		Questao06.filter(aux, new FilaDinamica<Integer>());

		System.out.println("\nTestes quest�o 8\n");
		System.out.println(Divisao.div(10,2));
		System.out.println(Divisao.div(10,3));
		System.out.println(Divisao.div(10,4));
		System.out.println(Divisao.div(10,5));
		System.out.println(Divisao.div(10,6));
		System.out.println(Divisao.div(10,7));
		
		
		System.out.println("\nTestes quest�o 09\n");
		ListaDinamica<Integer> q91=new ListaDinamica<Integer>();
		q91.inserir(8);
		q91.inserir(1);
		q91.inserir(12);
		q91.inserir(9);
		q91.inserir(5);
		q91.inserir(8);
		q91.inserir(-7);
		q91.inserir(5);
		q91.inserir(12);
		q91.imprimeLista();
		MetodoLista.retornaLista(q91).imprimeLista();
		
		System.out.println("\nTestes quest�o 10\n");
		ListaDinamica<Character> q101 = new ListaDinamica<Character>();
		q101.inserir('G');
		q101.inserir('8');
		q101.inserir('W');
		q101.inserir('7');
		q101.inserir('T');
		q101.inserir('5');
		q101.inserir('E');
		q101.inserir('1');
		q101.inserir('A');
		q101.imprimeLista();
		ListaCaracteres.mudaSequencia(q101).imprimeLista();
		System.out.println();
		ListaDinamica<Character> q102 = new ListaDinamica<Character>();
		q102.inserir('6');
		q102.inserir('Q');
		q102.inserir('4');
		q102.inserir('H');
		q102.inserir('9');
		q102.inserir('C');
		q102.inserir('3');
		q102.imprimeLista();
		ListaCaracteres.mudaSequencia(q102).imprimeLista();
		

		
		System.out.println("\nTestes quest�o 11\n");
		Aeroporto a = new Aeroporto();
		a.addDecolagem(new Aviao("Avi�o 1"));
		a.addDecolagem(new Aviao("Avi�o 2"));
		a.addDecolagem(new Aviao("Avi�o 3"));
		a.addEspera(new Aviao("Avi�o 4"));
		a.addEspera(new Aviao("Avi�o 5"));
		a.addEspera(new Aviao("Avi�o 6"));
		a.autorizaDecolagem();
		a.moveListas();
		
		
		
		
	}
	
	
}
