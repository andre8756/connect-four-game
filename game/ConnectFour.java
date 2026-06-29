import java.util.Scanner;

public class ConnectFour {
    private final int linhas = 6;
    private final int colunas = 7;

    public ConnectFour() {
        Scanner sc = new Scanner(System.in);
        char[][] tabuleiro = new char[linhas][colunas];
        popular(tabuleiro);
        imprimirTabuleiro(tabuleiro);
        perguntarCor(sc);
        jogar(sc, tabuleiro);
    }

    // Inicializacao
    // -----------------------------------------------------------------

    // Aqui a tabela será populada com a letra B
    public void popular(char[][] tabuleiro) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                tabuleiro[i][j] = 'B';
            }
        }
    }

    // Métodos Principais
    private void imprimirTabuleiro(char[][] tabuleiro) {
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
    private char perguntarCor(Scanner sc) {
        System.out.println("Escolha sua cor! Digite V para vermelho ou A para azul");
        char cor = sc.next().toUpperCase().charAt(0);
        return cor;
    }

    private void jogar(Scanner sc, char[][] tabuleiro) {
        boolean inserido = false;
        char corUsuario = perguntarCor(sc);
        System.out.println("Seja bem vindo ao ConnectFour!");
        System.out.println("O tabuleiro se encontra desse jeito:");
        imprimirTabuleiro(tabuleiro);
        System.out.println("Onde deseja adicionar uma ficha? Digite 1,2,3,4,5,6 ou 7 para escolher a coluna");
        int colunaEscolhida = sc.nextInt();
        boolean jogoAcabou = false;

        while (!jogoAcabou) {
        try {
            for (int i = 0; i < tabuleiro.length; i++) {
                if (tabuleiro[colunaEscolhida -1][i] == 'B') {
                    tabuleiro[colunaEscolhida -1][i] = corUsuario;
                    inserido = true;
                    return;    
                }
            }
            if(!inserido){
                System.err.print("A coluna inserida já está cheia! Por favor tente novamente e selecione uma coluna que possua um lugar vazio para adicionar a ficha");
                return;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("O número escolhido %d não pode ser usado! Tente novamente e se atente às mensagens",colunaEscolhida);
        }


    }
}
    // -----------------------------------------------------------------

    // Métodos que vão ajudar com os requisitos funcionais

    // Main
    public static void main(String[] args) {
        new ConnectFour();
    }
    // -----------------------------------------------------------------

}