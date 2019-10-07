package upe.ecomp.ed.Questao4;

import upe.ecomp.ed.resources.*;

/**
 * PilhaPilha
 */
public class PilhaPilha {
    private PilhaEstatica<PilhaEstatica<Integer>> pilha;
    
    public PilhaPilha() {
        pilha = new PilhaEstatica<>(10);
    }

    public PilhaEstatica<Integer> sum() {
        PilhaEstatica<Integer> aux = new PilhaEstatica<>(pilha.size());
        PilhaEstatica<Integer> sum = new PilhaEstatica<>(pilha.size());
        for (PilhaEstatica<Integer> pilhinha : pilha) {
            int soma = 0;
            for (Integer num : pilhinha) {
                soma += num;
            }
            aux.push(soma);
        }
        for (Integer var : aux) {
            sum.push(var);
        }
        return sum;
    }

    public void push(int data) {
        if(pilha.size() >= 10){
            int sum = 0;
            while (!pilha.isEmpty()) {
                while (!pilha.top().isEmpty())
                    sum += pilha.top().pop();
                pilha.pop();
            }
            pilha.push(new PilhaEstatica<Integer>(10));
            pilha.top().push(sum);
        } 
        
        else if(pilha.size() == 0)
            pilha.push(new PilhaEstatica<Integer>(10));
        
        if(pilha.top().size() >= 10)
            pilha.push(new PilhaEstatica<Integer>(10));
        
        pilha.top().push(data);
    }

    public int pop(){
        if(pilha.size() == 0)
            return 0;
        else if(pilha.top().size() == 0)
            pilha.pop();

        return pilha.top().pop();
    }

    @Override
    public String toString() {
        String out = "Topo";
        for (PilhaEstatica<Integer> var : pilha) {
            out += "-> (";
                for (Integer a : var) {
                    out += a.toString() + ",";
                }
            out += ")";
        }
        return out; 
    }
}