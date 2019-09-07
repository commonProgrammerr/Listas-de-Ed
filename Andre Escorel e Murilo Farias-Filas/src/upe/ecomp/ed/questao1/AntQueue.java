package upe.ecomp.ed.questao1;

import upe.ecomp.ed.EscorelD.Queue;

/**
 * AntQueue
 */
public class AntQueue extends Queue<Formiga> {

    public AntQueue(int capacidade) {
        super(capacidade);
    }

    @Override
    public void enqueue(Formiga newAnt) {
        int i = 0;
        for(; i < this.size(); i++)
            if(newAnt.prioridade < get(i).prioridade)
                break;
        super.add(newAnt, i);
    }

    @Override
    public void print(){
        System.out.println("Size: " + this.size() + "\n[");        
        for (int i = 0; i < this.size(); i++)
                if(i < this.size() -1) 
                    System.out.println("  " + this.get(i) + ",");
                else
                    System.out.println("  " + this.get(i));
        System.out.println("]");
    }
    public int listar(int prioritLevel) {
        int j = 0;
        for (int i = 0; i < this.size(); i++)
            if(this.get(i).prioridade == prioritLevel)
                j++;
        return j;
    }
}