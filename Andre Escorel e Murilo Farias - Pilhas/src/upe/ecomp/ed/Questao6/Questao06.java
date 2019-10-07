package upe.ecomp.ed.Questao6;

import upe.ecomp.ed.resources.FilaDinamica;
import upe.ecomp.ed.resources.PilhaDinamica;

/**
 * Questao06
 */
public class Questao06 {

    public static void filter(PilhaDinamica<Integer> a, FilaDinamica<Integer> b) {
        PilhaDinamica<Integer> aux = new PilhaDinamica<>();
        for (int i = 1; !a.isEmpty(); i++) {
            if(i % 2 == 0)
                aux.push(a.pop());
            else
                b.inserir(a.pop());
        }
        while (!aux.isEmpty()) {
            a.push(aux.pop());
        }
        System.out.println(a);
        System.out.println(b);
    }
    
}