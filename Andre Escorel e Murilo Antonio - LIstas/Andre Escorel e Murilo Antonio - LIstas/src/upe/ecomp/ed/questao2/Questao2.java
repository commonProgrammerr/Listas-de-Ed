package upe.ecomp.ed.questao2;

/**
 * Questao2
 */
public class Questao2 {
    private Integer[] lista;

    public Questao2() {
        lista = new Integer[1];
    }

    public void add(int ad) {
        try {
            for (int i = 0; true; i++)
                if (lista[i] == null) {
                    lista[i] = new Integer(ad);
                    break;
                }
        } catch (IndexOutOfBoundsException e) {
            Integer[] replace = new Integer[lista.length + 1];
            for (int i = 0; i < lista.length; i++)
                replace[i] = lista[i];
            replace[lista.length] = new Integer(ad);
        }
    }

    public void addAll(Integer[] colection) {
        int i = 0;
        for (int j = 0; j < colection.length; j++)
            try {
                for (; true; i++)
                    if (lista[i] == null) {
                        lista[i] = new Integer(colection[j]);
                        break;
                    }
            } catch (IndexOutOfBoundsException e) {
                Integer[] replace = new Integer[lista.length + colection.length];
                for (int k = 0; k < lista.length; k++)
                    replace[k] = lista[k];
                replace[lista.length] = new Integer(colection[j]);
            }
    }

    public void replace(int old, int newInt) {
        for (int i = 0; i < lista.length; i++)
            if (lista[i] == old) {
                lista[i] = new Integer(newInt);
                break;
            }
    }
}