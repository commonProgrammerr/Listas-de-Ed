package upe.ecomp.ed.questao2;

import java.util.Random;
import upe.ecomp.ed.EscorelD.DinamicList;

/**
 * Loja
 */
public class Loja {
    private DinamicList<FilaCaixa> caixas;
    
    public Loja() {
        caixas = new DinamicList<FilaCaixa>();
        caixas.add(new FilaCaixa());
        caixas.add(new FilaCaixa());
        caixas.add(new FilaCaixa());
    }

    public void abreFila() {
        FilaCaixa open = new FilaCaixa();
        int caixa = (new Random()).nextInt(caixas.size());
        caixas.add(open, caixa);
        System.out.println("Caixa " + caixas.indexOf(open) + " aberto!");
    }
    public void fechaFila() {
        int caixa = (new Random()).nextInt(caixas.size());
        caixas.remove(caixas.get(caixa));
        System.out.println("Caixa "+ caixa + " fechado!");
    }

    public void chegaNovoCliente(Cliente p) {
        FilaCaixa menor = caixas.get(0);
        for (FilaCaixa var : caixas) {
            menor = menor.compareTo(var) < 0 ? menor : var;
        }
        menor.enqueue(p);
    }

    public void atendeCliente(int n) {
        caixas.get(n).dequeue();
    }

    public void veSeAbreFila() {
        for (FilaCaixa var : caixas)
            if(var.size() >= 10)
                if(caixas.size() >= 10){
                    System.out.println("Sem cixas disponiveis!");
                    break;
                }
                else
                    caixas.add(new FilaCaixa());
    }
}