package upe.ecomp.ed.questoes123;

import java.util.Scanner;

import upe.ecomp.ed.resources.ArvoreBinaria;
import upe.ecomp.ed.resources.NodeBinario;
import upe.ecomp.ed.resources.PilhaDinamica;

/**
 * ArvoreExpressionante
 */
public class ArvoreExpressionante extends ArvoreBinaria<String>{
    public ArvoreExpressionante(String ex) {
        super(build(ex));
    }
    //todas as expreções devem estar dentro de parenteses para serem computadas, caso o contrario o methodo não cria o nó
    private static NodeBinario<String> build(String express){
        express = "( " + express + " )";
        PilhaDinamica<NodeBinario<String>> numeros = new PilhaDinamica<>();
        PilhaDinamica<NodeBinario<String>> operadores = new PilhaDinamica<>();
        int open = 0;
        NodeBinario<String> no = null;
        String[] expres = express.split(" ");
        for (int i = 0; i < expres.length; i++) {
            
            if(expres[i].equals("-") 
            || expres[i].equals("+") 
            || expres[i].equals("*") 
            || expres[i].equals("/") 
            || expres[i].equals("^"))
                operadores.push(new NodeBinario<String>(expres[i]));
            
            else if( expres[i].equals(")")){
                if(operadores.size() == 0 && open > 0){
                    if(numeros.size() == 1)
                        open-=3;
                    else {
                        System.err.println("Expressão invalida!");
                        throw new Error("Expressão invalida!");
                    };
                }
                else if(open <= 0 || numeros.size() < 2 || operadores.size() < 1) {
                    System.err.println("Expressão invalida!");
                    throw new Error("Expressão invalida!");
                }
                else {
                    open-=3;
                    no = operadores.pop();
                    no.setDir(numeros.pop());
                    no.setEsq(numeros.pop());
                    numeros.push(no);
                } 
            }
            
            else if(expres[i].equals("("))
                open+=3;
            
            else if(!expres[i].equals("("))
                numeros.push(new NodeBinario<String>(expres[i]));
        }
        
        return no;   
    }

    public double resolver() {
      return valorOf(getRaiz());  
    }

    private double valorOf(NodeBinario<String> a) {
        switch(a.getInfo()){
            case "-":
                return valorOf(a.getEsq()) - valorOf(a.getDir());
            case "+":
                return valorOf(a.getEsq()) + valorOf(a.getDir());
            case "*":
                return valorOf(a.getEsq()) * valorOf(a.getDir());
            case "/":
                return valorOf(a.getEsq()) / valorOf(a.getDir());
            case "^":
                return Math.pow(valorOf( a.getEsq()), valorOf(a.getDir())) ;
            default:
                if(isNum(a.getInfo()))
                    return Double.valueOf(a.getInfo());
                else
                    System.out.println("Defina o valor da variavel " + a.getInfo());
                    Scanner in = new Scanner(System.in);
                    String s = in.nextLine().trim();
                    in.close();
                    if(isNum(s))
                        return Double.parseDouble(s);
                    else{
                        System.err.println("Valor invalido!");
                        throw new Error("Valor invalido!");
                    }

        }   
    }
    public static boolean isNum(String a){
        String[] s = a.split("");
        for (int i = 0; i < s.length; i++) {
            if(!(s[i].equals("1")
            || s[i].equals("2")
            || s[i].equals("3")
            || s[i].equals("4")
            || s[i].equals("5")
            || s[i].equals("6")
            || s[i].equals("7")
            || s[i].equals("8")
            || s[i].equals("9")
            || s[i].equals("0")
            || s[i].equals("-")
            ))
                return false;
        }
        a.indexOf(a);
        return true;
        
    }
    private static void percorre(NodeBinario b, int o) {
        if (b == null)
            return;
        else {
            System.out.print(o + " ");
            System.out.println(b.getInfo());
            percorre(b.getEsq(), o + 1);
            percorre(b.getDir(), o + 1);
        }
    }

    public void percorrer() {
        percorre(getRaiz(), 0);
    }

    public static void main(String[] args) {
        ArvoreExpressionante a = new ArvoreExpressionante("( 2 ^ 2 ) + ( 5 + a )");
        percorre(a.getRaiz(), 0);
        System.out.println(a.resolver());
    }

}