package upe.ecomp.ed.questao5;

import upe.ecomp.ed.EscorelD.PriorityQueue;
import upe.ecomp.ed.EscorelD.Queue;

/**
 * Q5
 */
public class Q5 {

    public static void mix(Queue f1, Queue f2, Queue out) {
        
        for (int i = 0; i < (f1.size() | f2.size()); i++) {
            if(i < f1.size())
                ((PriorityQueue) out).enqueue(f1.get(i));
            if(i < f2.size())
                ((PriorityQueue) out).enqueue(f2.get(i));
        }
    }
}