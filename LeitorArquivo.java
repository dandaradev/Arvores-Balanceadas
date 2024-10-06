import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Classe para leitura de um arquivo e extração de palavras de cada linha.
 */
public class LeitorArquivo {
    private String diretorioArquivo;
    BufferedReader entradaDeDados;
    private StringTokenizer strK;
    private int linhaAtual;

    /**
     * Construtor para inicializar o leitor de arquivo.
     *
     * @param diretorioArquivo O caminho do arquivo a ser lido.
     * @throws FileNotFoundException Se o arquivo especificado não for encontrado.
     */
    public LeitorArquivo(String diretorioArquivo) throws FileNotFoundException {
        this.diretorioArquivo = diretorioArquivo;
        this.entradaDeDados = new BufferedReader(new FileReader(diretorioArquivo));
        this.linhaAtual = 0;
    }

    /**
     * Lê a próxima linha do arquivo e divide em palavras.
     *
     * @return Um array de palavras contidas na linha.
     */
    public String[] proximaLinha() {
        String[] linhaFatiada = null;
        try {
            String linha = entradaDeDados.readLine();
            if (linha != null) {
                linha = linha.toLowerCase(); // Deixa a linha toda em minúsculo.
                strK = new StringTokenizer(linha, " ,.?!:_-\"'");  // Fatia a linha e remove caracteres.
                int count = 0;
                linhaFatiada = new String[strK.countTokens()];
                while (strK.hasMoreTokens()) {
                    linhaFatiada[count] = strK.nextToken();
                    count++;
                }
            } else {
                entradaDeDados.close();
                strK = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        linhaAtual++;
        return linhaFatiada;
    }

    /**
     * Retorna uma lista de objetos No contendo palavras da linha e a linha onde elas ocorrem.
     *
     * @return Uma lista de objetos No.
     */
    public ArrayList<No> getPalavrasLinha() {
        String[] palavras = proximaLinha();
        ArrayList<No> arrayNo = new ArrayList<>();
        if (palavras != null) {
            for (String palavra : palavras) {
                if (palavra.length() >= 3 && palavra.length() <= 20) {
                    No no = new No(palavra, linhaAtual);
                    arrayNo.add(no);
                }
            }
        } else {
            arrayNo = null;
        }
        return arrayNo;
    }
}