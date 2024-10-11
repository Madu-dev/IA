package resolucao;
import java.util.Arrays;
import java.util.HashSet;

public class SegundaImplementacao {
    private No raiz;
    private int[] amostraObjetivo;
    private boolean solucaoEncontrada = false;
    private HashSet<No> estadosVisitados = new HashSet<>();
    private int nosExpandidos = 0;

    public SegundaImplementacao(int[] valorRaiz, int[] amostraObjetivo) {
        this.raiz = new No(valorRaiz, null);
        this.amostraObjetivo = amostraObjetivo.clone(); // Clonar o array objetivo
    }

    public No getRaiz() {
        return raiz;
    }

    public void gerarAmostrasDireto(No no, int limiteProfundidade, int profundidadeAtual) {
        if (solucaoEncontrada || profundidadeAtual > limiteProfundidade) return;

        // Verifica se a solução foi encontrada
        if (Arrays.equals(no.getValor(), amostraObjetivo)) {
            solucaoEncontrada = true;
            System.out.println("Caminho da solução: " + no.getCaminho());
            return;
        }

        // Adiciona o estado atual aos visitados
        estadosVisitados.add(no);
        nosExpandidos++;

        int[] valorAtual = no.getValor();
        int posZero = encontrarZero(valorAtual);

        // Direções: Cima, Baixo, Esquerda, Direita
        int[][] direcoes = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int[] dir : direcoes) {
            int novoPosZero = posZero + dir[0] * 3 + dir[1]; // Calcular nova posição

            if (podeMover(valorAtual, posZero, novoPosZero)) {
                // Mover diretamente
                trocar(valorAtual, posZero, novoPosZero);
                No novoNo = new No(valorAtual, no);
                // Verifica se o novo estado já foi visitado
                if (!estadosVisitados.contains(novoNo)) {
                    gerarAmostrasDireto(novoNo, limiteProfundidade, profundidadeAtual + 1);
                }
                // Desfazer a troca
                trocar(valorAtual, novoPosZero, posZero); // Desfazer a troca
            }
        }
    }

    private int encontrarZero(int[] estado) {
        for (int i = 0; i < estado.length; i++) {
            if (estado[i] == 0) {
                return i; // Retorna a posição do zero
            }
        }
        throw new IllegalArgumentException("Estado inválido: 0 não encontrado");
    }

    private boolean podeMover(int[] estado, int posZero, int novoPosZero) {
        return novoPosZero >= 0 && novoPosZero < estado.length;
    }

    private void trocar(int[] estado, int posZero, int novoPosZero) {
        int temp = estado[posZero];
        estado[posZero] = estado[novoPosZero];
        estado[novoPosZero] = temp;
    }

    public boolean isSolucaoEncontrada() {
        return solucaoEncontrada;
    }

    public int getNosExpandidos() {
        return nosExpandidos;
    }
}