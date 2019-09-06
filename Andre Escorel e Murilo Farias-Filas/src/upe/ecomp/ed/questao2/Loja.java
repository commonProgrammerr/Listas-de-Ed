package upe.ecomp.ed.questao2;

import upe.ecomp.ed.EscorelD.Dinamic;

/**
 * Loja
 */
public class Loja {
    private Dinamic<FilaCaixa> caixas;
    
    public Loja() {
        caixas = new Dinamic<FilaCaixa>();
        caixas.add(new FilaCaixa());
        caixas.add(new FilaCaixa());
        caixas.add(new FilaCaixa());
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
        
        for (FilaCaixa fila : caixas)
            if(fila.size() > 5)
                for (FilaCaixa caixa : caixas)
                    if(!caixa.getStatus()){
                        caixa.abreFila();
                        return;
                    }
        
        System.out.println("Sem cixas disponiveis!");
    }
}