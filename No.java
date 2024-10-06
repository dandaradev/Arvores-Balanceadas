/**
 * Classe que representa um nó em uma árvore binária contendo uma palavra e suas ocorrências em linhas.
 */
public class No {
    String palavra;
    No direita;
    No esquerda;
    ListaSE linhas;
    int linha;

    /**
     * Construtor para inicializar um nó com uma palavra e a linha onde ela ocorre.
     *
     * @param palavra A palavra a ser armazenada no nó.
     * @param linha   A linha onde a palavra ocorre.
     */
    public No(String palavra, int linha) {
        this.palavra = palavra;
        linhas = new ListaSE();
        this.linha = linha;
        linhas.inserirNoFim(new Celula(linha));
    }

    /**
     * Método para inserir uma linha onde a palavra aparece.
     *
     * @param linha A linha a ser adicionada.
     */
    public void inserirLinha(int linha) {
        linhas.inserirNoFim(new Celula(linha));
    }
}
