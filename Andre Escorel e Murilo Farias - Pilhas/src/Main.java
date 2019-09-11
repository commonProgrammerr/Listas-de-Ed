import upe.ecomp.ed.Questao01.*;
import upe.ecomp.ed.Questao02.*;
import upe.ecomp.ed.Questao08.*;
import upe.ecomp.ed.Questao09.*;
import upe.ecomp.ed.Questao10.*;
import upe.ecomp.ed.Questao11.*;
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

		System.out.println("Testes quest�o 8\n");
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
