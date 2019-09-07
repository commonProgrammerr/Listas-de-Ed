package upe.ecomp.ed;

import upe.ecomp.ed.questao1.*;
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        AntQueue q1 = new AntQueue(10);
        for (int i = 0; i < 6; i++)
            q1.enqueue(new Formiga("Formiga " + (i + 1),  i));
        q1.enqueue(new Formiga("Last Ant ", 0));
        q1.print();
        System.out.println("numero de formigas com prioridade 0: " + q1.listar(0));
        
    }
}