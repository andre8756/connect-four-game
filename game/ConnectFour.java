import java.util.Scanner;

public class ConnectFour {
    private final int linhas = 6;
    private final int colunas = 7;
    String[][] tabuleiro = new String[linhas][colunas];
    Scanner scan = new Scanner(System.in);

    public ConnectFour() {
        popular();
        imprimirTabuleiro();
    }

    // Inicializacao
    // -----------------------------------------------------------------

    // Aqui a tabela será populada com a letra B
    public void popular() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                tabuleiro[i][j] = "[B]";
            }
        }
    }

    // Métodos Principais
    private void imprimirTabuleiro() {
    for (int i = 0; i < tabuleiro.length; i++) {
        for (int j = 0; j < tabuleiro[i].length; j++) {
            System.out.print(tabuleiro[i][j]);
        }
        System.out.println();
    }
}
    // -----------------------------------------------------------------

    // Todos os requisitos funcionais

    // Métodos Secundários
    // -----------------------------------------------------------------

    // Métodos que vão ajudar com os requisitos funcionais

    // Main
    // -----------------------------------------------------------------

    public static void main(String[] args) {
        new ConnectFour();
    }
}