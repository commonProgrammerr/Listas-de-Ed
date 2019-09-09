package upe.ecomp.ed;

import upe.ecomp.ed.EscorelD.Queue;
import upe.ecomp.ed.questao1.*;
import upe.ecomp.ed.questao5.Q5;
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
    public static void main(String[] args) {
        questao5();
    }
}