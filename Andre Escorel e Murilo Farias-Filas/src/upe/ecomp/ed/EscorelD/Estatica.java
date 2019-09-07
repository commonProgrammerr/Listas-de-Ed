package upe.ecomp.ed.EscorelD;

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
        if(tamanho >= dados.length)
            upSize();
        dados[tamanho] = in;
        tamanho++;   
    }

    public void add(T in, int index) {
        if(tamanho == dados.length)
            upSize();     
        for (int i = tamanho-1; i >= index; i--)
            dados[i+1] = dados[i];
        dados[index] = in;
        tamanho++;
    
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
        System.out.print("Size: " + tamanho + " - [");
        
        for (int i = 0; i < tamanho; i++)
            if(dados[i] != null)
                if(i < tamanho -1) 
                    System.out.print(dados[i] + ", ");
                else
                    System.out.print(dados[i]);

        System.out.println("]");
    }

    public int size() {
        return tamanho;
    }
}