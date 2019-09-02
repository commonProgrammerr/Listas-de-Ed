package upe.ecomp.ed.questao1;

import upe.ecomp.ed.Queue;

/**
 * AntQueue
 */
public class AntQueue extends Queue<Formiga> {

    public AntQueue(int capacidade) {
        super(capacidade);
    }

    public void enqueue(Formiga in) {
        for(int i = 0; i < this.size(); i++)
           if(this.get(i).compareTo(in) > 0){
                super.enqueue(in, i);
                break;
            }
    }

    public int listar(int prioritLevel) {
        int j = 0;
        for (int i = 0; i < this.size(); i++)
            if(this.get(i).prioridade == prioritLevel)
                j++;
        return j;
    }
}