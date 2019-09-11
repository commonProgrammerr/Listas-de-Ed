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
        PilhaEstatica<Integer> sum = new PilhaEstatica<>(pilha.size());
        for (PilhaEstatica<Integer> pilhinha : pilha) {
            int soma = 0;
            for (Integer num : pilhinha) {
                soma += num;
            }
            sum.push(soma);
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
            this.push(sum);
        } 
        
        if(pilha.size() == 0)
            pilha.push(new PilhaEstatica<Integer>(10));
        else if(pilha.top().size() >= 10)
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
        String out = "";
        for (PilhaEstatica<Integer> var : pilha) {
            out += "->";
            out += var.toString().replace("[", "(");
            out += var.toString().replace("]", ")");
            out +="\n";
        }
        return out; 
    }
}