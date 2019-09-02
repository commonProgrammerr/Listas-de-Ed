package upe.ecomp.ed.questao1;

/**
 * Cliente
 */
public class Cliente {
    public String nome;
    public String cpf;

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == Cliente.class)
            return ((Cliente) obj).nome.equalsIgnoreCase(nome) && cpf.equals(obj);
        else
            return false;
    }
}