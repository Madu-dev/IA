package resolucao;

import java.util.Arrays;

public class SegundaImplementacao {
    private No raiz;
    private int[][] amostraObjetivo;
    private boolean solucaoEncontrada = false;

    public SegundaImplementacao(int[][] valorRaiz, int[][] amostraObjetivo) {
        this.raiz = new No(valorRaiz, null);
        this.amostraObjetivo = amostraObjetivo;
    }

    public No getRaiz() {
        return raiz; // Adicionado método getRaiz
    }

    public void gerarAmostrasDireto(No no, int limiteProfundidade, int profundidadeAtual) {
        if (solucaoEncontrada) return;

        int[][] valorAtual = no.getValor();
        if (Arrays.deepEquals(valorAtual, amostraObjetivo)) {
            solucaoEncontrada = true;
            return; // Solução encontrada
        }

        if (profundidadeAtual >= limiteProfundidade) return;

        int[] posZero = encontrarZero(valorAtual);
        int x = posZero[0], y = posZero[1];

        int[][] direcoes = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Cima, Baixo, Esquerda, Direita

        for (int[] dir : direcoes) {
            int novoX = x + dir[0];
            int novoY = y + dir[1];

            if (podeMover(valorAtual, x, y, novoX, novoY)) {
                trocar(valorAtual, x, y, novoX, novoY); // Mover diretamente
                gerarAmostrasDireto(no, limiteProfundidade, profundidadeAtual + 1);
                trocar(valorAtual, x, y, novoX, novoY); // Desfazer a troca
            }
        }
    }

    private int[] encontrarZero(int[][] estado) {
        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado[i].length; j++) {
                if (estado[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private boolean podeMover(int[][] estado, int x, int y, int novoX, int novoY) {
        return novoX >= 0 && novoX < estado.length && novoY >= 0 && novoY < estado[0].length;
    }

    private void trocar(int[][] estado, int x, int y, int novoX, int novoY) {
        int temp = estado[x][y];
        estado[x][y] = estado[novoX][novoY];
        estado[novoX][novoY] = temp;
    }

    public boolean isSolucaoEncontrada() {
        return solucaoEncontrada;
    }
}