package resolucao;

public class Main {
    public static void main(String[] args) {
        int[] raiz = {
                8, 0, 6,
                3, 2, 7,
                4, 5, 1
        };

        int[] objetivo = {
                1, 2, 3,
                4, 5, 6,
                7, 8, 0
        };

        int limiteProfundidadeMaximo = 10; // Defina um limite de profundidade máximo para as buscas

        // Teste a primeira implementação
        long inicioPrimeira = System.currentTimeMillis();
        PrimeiraImplementacao primeira = new PrimeiraImplementacao(raiz, objetivo);
        System.out.println("Iniciando a Primeira Implementação...");
        primeira.gerarAmostrasCopia(primeira.getRaiz(), limiteProfundidadeMaximo, 0);
        long fimPrimeira = System.currentTimeMillis();

        if (primeira.isSolucaoEncontrada()) {
            System.out.println("Solução encontrada na Primeira Implementação!");
        } else {
            System.out.println("Solução não encontrada na Primeira Implementação.");
        }
        System.out.println("Nós expandidos: " + primeira.getNosExpandidos());
        System.out.println("Tempo de execução (Primeira Implementação): " + (fimPrimeira - inicioPrimeira) + " ms");

        // Teste a segunda implementação
        long inicioSegunda = System.currentTimeMillis();
        SegundaImplementacao segunda = new SegundaImplementacao(raiz, objetivo);
        System.out.println("Iniciando a Segunda Implementação...");
        segunda.gerarAmostrasDireto(segunda.getRaiz(), limiteProfundidadeMaximo, 0);
        long fimSegunda = System.currentTimeMillis();

        if (segunda.isSolucaoEncontrada()) {
            System.out.println("Solução encontrada na Segunda Implementação!");
        } else {
            System.out.println("Solução não encontrada na Segunda Implementação.");
        }
        System.out.println("Nós expandidos: " + segunda.getNosExpandidos());
        System.out.println("Tempo de execução (Segunda Implementação): " + (fimSegunda - inicioSegunda) + " ms");
    }
}