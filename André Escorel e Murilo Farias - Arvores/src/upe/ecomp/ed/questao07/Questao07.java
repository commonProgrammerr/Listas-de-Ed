package upe.ecomp.ed.questao07;

import java.util.Scanner;

import upe.ecomp.ed.questoes123.ArvoreExpressionante;
import upe.ecomp.ed.resources.ArvoreBinaria;
import upe.ecomp.ed.resources.MyMap;
import upe.ecomp.ed.resources.Nde;
import upe.ecomp.ed.resources.NodeBinario;

/**
 * Questao07
 */
public class Questao07<T> extends ArvoreBinaria<T>{
    public Questao07() {
        super();
    }

    public Questao07(NodeBinario<T> subtree) {
        super(subtree);
    }

    public T h() {
        MyMap<Integer, NodeBinario<T>> folhas = new MyMap<>();
        folhas(getRaiz(), 0, folhas);
        int aux = 0;
        for (Nde<Integer, NodeBinario<T>> i = folhas.head; i != null; i = i.next) {
            if(i.key > aux)
                aux = i.key;
        }
        return folhas.get(aux).getInfo();
    }

    public T l() {
        MyMap<Integer, NodeBinario<T>> folhas = new MyMap<>();
        folhas(getRaiz(), 0, folhas);
        int aux = altura(getRaiz(), 0);
        for (Nde<Integer, NodeBinario<T>> i = folhas.head; i != null; i = i.next) {
            if(i.key < aux)
                aux = i.key;
        }

        return folhas.get(aux).getInfo();
    }
    private void folhas(NodeBinario<T> no, int h, MyMap<Integer, NodeBinario<T>> folhas){
        if(no == null)
            return;
        else if(no.getDir() == null && no.getEsq() == null)
            folhas.put(h, no);
        else {
            folhas(no.getDir(), h + 1, folhas);
            folhas(no.getEsq(), h + 1, folhas);
        }
    }

    private int altura(NodeBinario<T> no, int h){
        if(no == null)
            return h-1;
        int d = altura(no.getDir(), h + 1);
        int e = altura(no.getDir(), h + 1);
        return d < e ? e : d;
    }

    public static void main(String[] args) {
        int i = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um texto:");
        while(sc.hasNext()){
          i++;
          System.out.println("Token: "+sc.next());
        }
        sc.close(); //Encerra o programa
      }
    
}                                                                               