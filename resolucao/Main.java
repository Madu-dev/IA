package resolucao;

public class Main {
    public static void main(String[] args) {
        int[][] raiz = {
                {8, 0, 6},
                {3, 2, 7},
                {4, 5, 1}
        };

        int[][] objetivo = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };

        int limiteProfundidadeMaximo = 10;

        for (int limiteProfundidade = 1; limiteProfundidade <= limiteProfundidadeMaximo; limiteProfundidade++) {
            PrimeiraImplementacao primeira = new PrimeiraImplementacao(raiz, objetivo);
            System.out.println("Iniciando a Primeira Implementação com limite de profundidade: " + limiteProfundidade);
            primeira.gerarAmostrasCopia(primeira.getRaiz(), limiteProfundidade, 0);

            if (primeira.isSolucaoEncontrada()) {
                System.out.println("Solução encontrada na Primeira Implementação com limite de profundidade: " + limiteProfundidade);
                break;
            } else {
                System.out.println("Solução não encontrada na Primeira Implementação com limite de profundidade: " + limiteProfundidade);
            }
        }

        for (int limiteProfundidade = 1; limiteProfundidade <= limiteProfundidadeMaximo; limiteProfundidade++) {
            SegundaImplementacao segunda = new SegundaImplementacao(raiz, objetivo);
            System.out.println("Iniciando a Segunda Implementação com limite de profundidade: " + limiteProfundidade);
            segunda.gerarAmostrasDireto(segunda.getRaiz(), limiteProfundidade, 0);

            if (segunda.isSolucaoEncontrada()) {
                System.out.println("Solução encontrada na Segunda Implementação com limite de profundidade: " + limiteProfundidade);
                break;
            } else {
                System.out.println("Solução não encontrada na Segunda Implementação com limite de profundidade: " + limiteProfundidade);
            }
        }
    }
}