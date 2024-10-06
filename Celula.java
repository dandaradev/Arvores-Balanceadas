/**
 * Classe que representa uma célula de uma lista encadeada.
 */
public class Celula {
    int linha;
    Celula proximo;

    /**
     * Construtor para inicializar uma célula com uma linha.
     *
     * @param linha A linha que a célula representa.
     */
    public Celula(int linha) {
        this.linha = linha;
    }
}