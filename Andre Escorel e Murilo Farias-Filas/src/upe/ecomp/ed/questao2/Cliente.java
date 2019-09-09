package upe.ecomp.ed.questao2;

/**
 * Pessoa
 */
public class Cliente {
    private String nome;
    public Cliente(String name) {
        this.nome = name;
    }
    @Override
    public java.lang.String toString() {
        return "Cliente:" + nome;
    }
    
}