package upe.ecomp.ed.questao2;

import upe.ecomp.ed.EscorelD.DinamicQueue;

/**
 * FilaCaixa
 */
public class FilaCaixa extends DinamicQueue<Cliente> implements Comparable<FilaCaixa>{
    
    public FilaCaixa() {
        super();
    }
    @Override
    public boolean add(Cliente in) {
        if(this.size() < 10)
            return super.add(in);
        else
            return false;
    }

    @Override
    public boolean add(Cliente in, int index) {
        if(this.size() < 10)
            return super.add(in, index);
        else
            return false;
    }
    
    @Override
    public int compareTo(FilaCaixa o) {
        return this.size() - o.size();
    }

}