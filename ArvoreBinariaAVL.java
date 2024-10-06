public class ArvoreBinariaAVL {
    No raiz;

    public ArvoreBinariaAVL(){
        raiz = null;
    }

    /**
     * Método privado para inserir um novo nó na árvore binária.
     *
     * @param novo   O novo nó a ser inserido.
     * @param atual  O nó atual onde a comparação é feita.
     * @return O nó atualizado após a inserção.
     */
    private No inserirNovo(No novo, No atual) {
        if (atual == null) {
            return novo;
        }
        if (atual.palavra.compareTo(novo.palavra) > 0) {
            atual.esquerda = inserirNovo(novo, atual.esquerda);
        } else if (atual.palavra.compareTo(novo.palavra) < 0) {
            atual.direita = inserirNovo(novo, atual.direita);
        } else {
            atual.inserirLinha(novo.linha);
        }
        return balancear(atual);
    }

    /**
     * Insere um novo nó na árvore binária.
     *
     * @param novo O nó a ser inserido.
     */
    public void inserir(No novo) {
        raiz = inserirNovo(novo, raiz);
    }

    private int altura(No atual) {
        if (atual == null) {
            return 0;
        }
        return 1 + Math.max(altura(atual.esquerda), altura(atual.direita));
    }

    private int fatorBalanceamento(No no) {
        if (no == null) {
            return 0;
        } else {
            return altura(no.direita) - altura(no.esquerda);
        }
    }

    private No rotacaoSimplesDireita(No raiz) {
        No aux = raiz.esquerda.direita;
        raiz.esquerda.direita = raiz;
        /*elimina referências*/
        raiz = raiz.esquerda;
        raiz.direita.esquerda = aux;
        return raiz;
    }

    private No rotacaoSimplesEsquerda(No raiz) {
        No aux = raiz.direita.esquerda;
        raiz.direita.esquerda = raiz;
        raiz = raiz.direita;
        raiz.esquerda.direita = aux;
        return raiz;
    }

    private No rotacaoEsquerdaDireita(No raiz){
        No aux = raiz.esquerda.direita.esquerda;
        raiz.esquerda.direita.esquerda = raiz.esquerda;
        raiz.esquerda = raiz.esquerda.direita;
        raiz.esquerda.esquerda.direita = aux;
        return rotacaoSimplesDireita(raiz);
    }

    private No rotacaoDireitaEsquerda(No raiz) {
        No aux = raiz.direita.esquerda.direita;
        raiz.direita.esquerda.direita = raiz.direita;
        raiz.direita = raiz.direita.esquerda;
        raiz.direita.direita.esquerda = aux;
        return rotacaoSimplesEsquerda(raiz);
    }

    private No balancear(No no) {
        int balanceamento = fatorBalanceamento(no);
        if (balanceamento > 1) {
            int balanceamentoDireita = fatorBalanceamento(no.direita);
            int balanceamentoEsquerda = fatorBalanceamento(no.esquerda);
            if (balanceamentoDireita == 0 || balanceamentoEsquerda == 1) {
                no = rotacaoSimplesEsquerda(no);
            } else if (balanceamentoDireita == -1) {
                no = rotacaoDireitaEsquerda(no);
            }
        } else if (balanceamento < -1) {
            int balanceamentoDireita = fatorBalanceamento(no.direita);
            int balanceamentoEsquerda = fatorBalanceamento(no.esquerda);
            if (balanceamentoDireita == 0 || balanceamentoEsquerda == -1) {
                no = rotacaoSimplesDireita(no);
            } else if (balanceamentoEsquerda == 1) {
                no = rotacaoEsquerdaDireita(no);
            }
        }
        return no;
    }

    /**
     * Método recursivo privado para imprimir as palavras em ordem.
     *
     * @param elemento O nó atual.
     */
    private void ordem(No elemento) {
        if (elemento != null) {
            ordem(elemento.esquerda);
            System.out.printf(elemento.palavra);
            elemento.linhas.imprimir();
            ordem(elemento.direita);
        }
    }

    /**
     * Imprime as palavras armazenadas na árvore em ordem.
     */
    public void imprimirOrdem() {
        ordem(raiz);
    }
}
