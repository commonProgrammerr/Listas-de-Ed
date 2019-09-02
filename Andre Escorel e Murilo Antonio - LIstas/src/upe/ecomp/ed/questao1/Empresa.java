package upe.ecomp.ed.questao1;

public class Empresa {
    private String nomeEmpresa;
    private Lista clientes;

    public Empresa(String nome) {
        nomeEmpresa = nome;
        clientes = new Lista();
    }

    public Empresa(String nome, Lista lista) {
        nomeEmpresa = nome;
        clientes = lista;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public Lista getClientes() {
        return clientes;
    }

    public void setClientes(Lista clientes) {
        this.clientes = clientes;
    }
    
}