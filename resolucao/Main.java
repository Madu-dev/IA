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

        PrimeiraImplementacao primeira = new PrimeiraImplementacao(raiz, objetivo);
        System.out.println("Iniciando a Primeira Implementação...");
        primeira.gerarAmostrasCopia(primeira.getRaiz(), 10, 0);

        if (primeira.isSolucaoEncontrada()) {
            System.out.println("Solução encontrada na Primeira Implementação!");
        } else {
            System.out.println("Solução não encontrada na Primeira Implementação.");
        }

        SegundaImplementacao segunda = new SegundaImplementacao(raiz, objetivo);
        System.out.println("Iniciando a Segunda Implementação...");
        segunda.gerarAmostrasDireto(segunda.getRaiz(), 10, 0);

        if (segunda.isSolucaoEncontrada()) {
            System.out.println("Solução encontrada na Segunda Implementação!");
        } else {
            System.out.println("Solução não encontrada na Segunda Implementação.");
        }
    }
}
