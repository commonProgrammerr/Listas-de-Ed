package upe.ecomp.ed.questao1;

/**
 * Formiga
 */
public class Formiga implements Comparable<Formiga>{
    public int prioridade;
    public String nome;
    
    public Formiga(String nome, int prioidade) {
        this.prioridade = prioidade;
        this.nome = nome;
    }

    @Override
    public int compareTo(Formiga o) {
        return this.prioridade - o.prioridade;
    }
    
}