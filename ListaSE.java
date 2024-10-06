/**
 * Classe que representa uma lista simplesmente encadeada para armazenar as ocorrências de uma palavra.
 */
public class ListaSE {
    private Celula primeiro;
    private int comprimento;

    /**
     * Construtor para inicializar uma lista simplesmente encadeada.
     */
    public ListaSE() {
        primeiro = null;
        comprimento = 0;
    }

    /**
     * Verifica se a lista está vazia.
     *
     * @return True se a lista estiver vazia, caso contrário, False.
     */
    public boolean estaVazia() {
        return (primeiro == null);
    }

    /**
     * Imprime todas as linhas armazenadas na lista.
     */
    public void imprimir() {
        Celula aux = primeiro;
        while (aux != null) {
            System.out.printf(" %d", aux.linha);
            if (aux.proximo != null) {
                System.out.printf(",");
            } else {
                System.out.println();
            }
            aux = aux.proximo;
        }
    }

    /**
     * Insere uma célula no final da lista.
     *
     * @param celula A célula a ser inserida.
     */
    public void inserirNoFim(Celula celula) {
        if (estaVazia()) {
            primeiro = celula;
        } else {
            Celula aux = primeiro;
            while (aux.proximo != null) {
                aux = aux.proximo;
            }
            aux.proximo = celula;
        }
        comprimento++;
    }

    // escrever metodo de pesquisar na lista
}
