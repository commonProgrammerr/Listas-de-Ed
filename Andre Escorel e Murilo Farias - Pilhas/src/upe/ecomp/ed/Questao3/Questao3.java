package upe.ecomp.ed.Questao3;

import upe.ecomp.ed.resources.*;

/**
 * Questao3
 */
public class Questao3 {

    public static boolean insideOf(PilhaDinamica<Integer> p1, PilhaDinamica<Integer> p2) {
        PilhaDinamica<Integer> a = new PilhaDinamica<Integer>();
        PilhaDinamica<Integer> b = new PilhaDinamica<Integer>();
        if(p2.size() < p1.size())
                return false;
        for (int i = 0; !p1.isEmpty() && !p2.isEmpty();) {
            if(p1.top().equals(p2.top())){
                a.push(p1.pop());
                b.push(p2.pop());
                i++;
            } else if(i == 0) {
                b.push(p2.pop());
                i = 0;
            } else {
                while (!a.isEmpty()) {
                    p1.push(a.pop());
                }
                i = 0;
            }
            if(p2.size() < p1.size()){
                while (!a.isEmpty()) {
                    p1.push(a.pop());
                }
                while (!b.isEmpty()) {
                    p2.push(b.pop());
                }
                return false;
            }
                
        }
        while (!a.isEmpty()) {
            p1.push(a.pop());
        }
        while (!b.isEmpty()) {
            p2.push(b.pop());
        }
        return true;
    }

    public static void main(String[] args) {
        PilhaDinamica<Integer> a = new PilhaDinamica<>(); 
        PilhaDinamica<Integer> b = new PilhaDinamica<>();
            
        for (int i = 0; i < 20; i++) {
            b.push(i);
            if(i > 10)
                a.push(i);
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(insideOf(a, b));
        b.pop();
        System.out.println(a);
        System.out.println(b);
        System.out.println(insideOf(a, b));
    }
}