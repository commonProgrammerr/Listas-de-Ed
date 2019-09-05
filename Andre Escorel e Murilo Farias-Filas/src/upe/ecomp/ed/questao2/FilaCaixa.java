package upe.ecomp.ed.questao2;

import upe.ecomp.ed.DinamicQueue;

/**
 * FilaCaixa
 */
public class FilaCaixa extends DinamicQueue<Cliente> implements Comparable<FilaCaixa>{
    
    private boolean status;
    
    public FilaCaixa() {
        super();
        status = true;
    }

    
    public void abreFila() {
        status = true;    
    }

    public void fechaFila() {
        status = false;
    }

    public boolean getStatus() {
        return status;
    }

    @Override
    public int compareTo(FilaCaixa o) {
        return this.size() - o.size();
    }

}