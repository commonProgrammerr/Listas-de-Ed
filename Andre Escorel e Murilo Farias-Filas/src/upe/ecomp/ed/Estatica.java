package upe.ecomp.ed;

/**
 * Estatica
 */
public class Estatica<T> {
    private T[] dados;
    private int tamanho;

    public Estatica(int capacidade) {
        dados = (T[]) new Object[capacidade];
        tamanho = 0;
    }

    private void upSize(){
        T[] replace = (T[]) new Object[dados.length * 2];
        for (int i = 0; i < dados.length; i++)
            replace[i] = dados[i];
        dados = replace;
    }
    
    public void add(T in) {
        if(tamanho + 1 == dados.length)
            upSize();
        dados[tamanho++] = in;   
    }

    public void add(T in, int index) {
        if(tamanho + 1 == dados.length)
            upSize();
        for (int i = tamanho; i >= index; i--)
            dados[i+1] = dados[i];
        dados[index] = in;
    }

    public T get(int index){
        return dados[index];
    }
    
    public T remove(int index){
        T out = dados[index];
        for (int i = index + 1; i < dados.length; i++)
            dados[i-1] = dados[i];
        return out;
    }

    public void print(){
        System.out.print("[");
        for (int i = 0; i < tamanho; i++) 
            System.out.print(dados[i].toString() + ",");
        System.out.println(dados[tamanho].toString() + "]");
    }

    public int size() {
        return tamanho;
    }
}