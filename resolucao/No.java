package resolucao;
import java.util.Arrays;

public class No {
    private int[] valor;
    private No pai;

    public No(int[] valor, No pai) {
        this.valor = valor.clone();
        this.pai = pai;
    }

    public int[] getValor() {
        return valor;
    }

    public No getPai() {
        return pai;
    }

    // Retorna o caminho até a raiz
    public String getCaminho() {
        if (pai == null) {
            return Arrays.toString(valor);
        }
        return pai.getCaminho() + " -> " + Arrays.toString(valor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof No)) return false;
        No outro = (No) obj;
        return Arrays.equals(valor, outro.valor);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(valor);
    }
}