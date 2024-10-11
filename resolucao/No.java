package resolucao;

import java.util.Arrays;

class No {
    private int[][] valor;
    private No pai;

    public No(int[][] valor, No pai) {
        this.valor = copiar(valor);
        this.pai = pai;
    }

    public int[][] getValor() {
        return valor;
    }

    public No getPai() {
        return pai;
    }

    private int[][] copiar(int[][] original) {
        if (original == null) return null;
        int[][] copia = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copia[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copia;
    }
}