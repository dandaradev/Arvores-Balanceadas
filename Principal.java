import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe Principal para o programa que lê palavras de um arquivo e insere em uma árvore binária.
 */
public class Principal {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<No> palavras = new ArrayList<>();
        LeitorArquivo leitor = new LeitorArquivo("brasil.txt");
        ArvoreBinariaAVL arvore = new ArvoreBinariaAVL();
        while ((palavras = leitor.getPalavrasLinha()) != null) {
            for (No palavra : palavras) {
                arvore.inserir(palavra);
            }
        }
        arvore.imprimirOrdem();
    }
}