package upe.ecomp.ed;

import upe.ecomp.ed.questao1.*;
import upe.ecomp.ed.questao2.Cliente;
import upe.ecomp.ed.questao2.Loja;
import upe.ecomp.ed.questao4.FatorPrimo;
import upe.ecomp.ed.questao5.Q5;
import upe.ecomp.ed.questao6.Deque;
/**
 * Main
 */
public class Main {
    private static void questao1() {
        AntQueue q1 = new AntQueue(10);
        for (int i = 0; i < 6; i++)
            q1.enqueue(new Formiga("Formiga " + (i + 1),  i));
        q1.enqueue(new Formiga("Last Ant ", 0));
        q1.print();
        System.out.println("numero de formigas com prioridade 0: " + q1.listar(0));
    }

    private static void questao2() {
        Loja a = new Loja();
        for (int i = 1; i <= 31; i++){
            a.chegaNovoCliente(new Cliente(Integer.toString(i)));
            if(i == 28 || i == 29)
                a.abreFila();
        }    
        a.print();
        a.atendeCliente(4);
        a.print();
        for (int i = 0; i < 3; i++) {
            a.abreFila();
        }
        a.print();
        for (int i = 0; i < 4; i++) {
            a.veSeAbreFila();
        }

        a.print();
    }
    private static void questao4() {
        FatorPrimo a = new FatorPrimo();
        a.fatorPrimo(20);
        a.print();
        a = new FatorPrimo();
        a.fatorPrimo(3960);
        a.print();
        a = new FatorPrimo();
        a.fatorPrimo(6552);
        a.print();
    }
    private static void questao5() {
        Q5<Integer> c = new Q5<Integer>(10);
        Q5<Integer> a = new Q5<Integer>(5);
        Q5<Integer> b = new Q5<Integer>(5);
        
        for (int i = 0; i < 10; i++)
            if(i > 5 ) 
                a.enqueue(i);
            else
                b.enqueue(i);
                
        System.out.print("Fila: a -> ");
            a.print();
        System.out.print("Fila: b -> ");
            b.print();
        System.out.print("Fila: c -> ");
            c.print();
            c.mix(a, b, c);
        System.out.print("Fila: c -> ");
            c.print();
    }

    private static void questao6() {
        Deque<Integer> a = new Deque<Integer>();
        for (int i = 0; i <= 10; i++) {
            if(i < 6)
                a.addEsq(i);
            else
                a.addDir(i);
        }
        a.print();
        System.out.println("lista menos o elemento 0:");
        a.remove(0);
        a.print();
        System.out.println("menos o primeiro elemento:" + a.popFirst());
        a.print();
        System.out.println("menos o ultimo elemento:" + a.popLast());
        a.print();
    }
    public static void main(String[] args) {
        System.out.println("\nQuestão: 1");
        questao1();
        System.out.println("\nQuestão: 2");
        questao2();
        System.out.println("\nQuestão: 4");
        questao4();
        System.out.println("\nQuestão: 5");
        questao5();
        System.out.println("\nQuestão: 6");
        questao6();

    }
}