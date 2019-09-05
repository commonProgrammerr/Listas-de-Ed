package upe.ecomp.ed.questao2;

import upe.ecomp.ed.Dinamic;
import upe.ecomp.ed.DinamicQueue;

/**
 * Loja
 */
public class Loja {
    private Dinamic<DinamicQueue<Pessoa>> caixas;
    
    public Loja() {
        caixas = new Dinamic<DinamicQueue<Pessoa>>();
        caixas.add(new DinamicQueue<Pessoa>());
        caixas.add(new DinamicQueue<Pessoa>());
        caixas.add(new DinamicQueue<Pessoa>());
    }

    
}