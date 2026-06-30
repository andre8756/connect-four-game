import java.util.Scanner;
import java.util.Random;

public class ConnectFour {
    private final int linhas = 6;
    private final int colunas = 7;

    public ConnectFour() {
        Scanner sc = new Scanner(System.in);
        char[][] tabuleiro = new char[linhas][colunas];
        popular(tabuleiro);
        imprimirTabuleiro(tabuleiro);
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
        char digitoImprimirTabuleiro = 'p';
        boolean inserido = false;
        char corUsuario = perguntarCor(sc);
        System.out.println("Seja bem vindo ao ConnectFour!");
        System.out.println("O tabuleiro se encontra desse jeito:");
        imprimirTabuleiro(tabuleiro);
        System.out.println("Caso queira imprimir o tabuleiro, é só digitar p. A qualquer momento");

        boolean jogoAcabou = false;

        while (jogoAcabou == false) {
            System.out.println("Onde deseja adicionar uma ficha? Digite 1,2,3,4,5,6 ou 7 para escolher a coluna");
            int colunaUsuario = sc.nextInt();
            if(colunaUsuario == digitoImprimirTabuleiro){
                imprimirTabuleiro(tabuleiro);
                return;
            }

            if (colunaUsuario < 1 || colunaUsuario > 7){
                System.out.printf("O número escolhido %d não pode ser usado! Tente novamente e se atente às mensagens",colunaUsuario);
                System.out.println();
                continue;
            }

            for (int i = tabuleiro.length - 1; i >= 0; i--) {
                if (tabuleiro[i][colunaUsuario - 1] == 'B') {
                    tabuleiro[i][colunaUsuario - 1] = corUsuario;
                    inserido = true;
                    break;
                }//falta validacao se a coluna esta cheia
            }

            if (!inserido) {
                System.err.print(
                        "A coluna inserida já está cheia! Por favor tente novamente e selecione uma coluna que possua um lugar vazio para adicionar a ficha");
                return;
            }
            imprimirTabuleiro(tabuleiro);


            // jogada do computador
            inserido = false;
            System.out.println("Agora é a vez do computador jogar");
            Random random = new Random();
            char corComputador = (corUsuario == 'V') ? 'A' : 'V';
            int colunaComputador = random.nextInt(1, 8);
            System.out.printf("A coluna escolhida pelo computador foi a %d°", colunaComputador);
            for (int i = tabuleiro.length - 1; i >= 0; i--) {
                if (tabuleiro[i][colunaComputador - 1] == 'B') {
                    tabuleiro[i][colunaComputador - 1] = corComputador;
                    inserido = true;
                    break;
                }
            }//falta validacao se a coluna esta cheia
            System.out.println("Computador fez sua jogada:  ");
            imprimirTabuleiro(tabuleiro);

            if(jogoAcabou(tabuleiro, corUsuario)){
                System.out.println("ACABOU!!");
                break;
            }

        }
    }

    public boolean jogoAcabou(char[][] tabuleiro, char corUsuario){
        int pontos;

        // Horizontal
        for (int i = 0; i < linhas; i++) {
            pontos = 0;
            for (int j = 0; j < colunas; j++) {
                if(tabuleiro[i][j] == corUsuario){
                    pontos++;
                } else{
                    pontos = 0;
                }
                if(pontos == 4){
                    return true;
                }
            }
        }

        //Diagonal
        for (int i = 0; i < colunas; i++) {
            pontos = 0;

            
            for (int j = 0; j < linhas; j++) {
                if(tabuleiro[j][i] == corUsuario){
                    pontos++;
                } else{
                    pontos = 0;
                }
                if(pontos == 4){
                    return true;
                }
            }
        }

        // Diagonal Decrescente
        for (int i = 0; i <= linhas - 4; i++) {
            for (int j = 0; j <= colunas - 4; j++) {
                if (tabuleiro[i][j] == corUsuario &&
                    tabuleiro[i + 1][j + 1] == corUsuario &&
                    tabuleiro[i + 2][j + 2] == corUsuario &&
                    tabuleiro[i + 3][j + 3] == corUsuario) {

                    return true;
                }
            }
        }

        // Diagonal Crescente
        for (int i = 3; i < linhas; i++) {
            for (int j = 0; j <= colunas - 4; j++) {

                if (tabuleiro[i][j] == corUsuario &&
                    tabuleiro[i - 1][j + 1] == corUsuario &&
                    tabuleiro[i - 2][j + 2] == corUsuario &&
                    tabuleiro[i - 3][j + 3] == corUsuario) {

                    return true;
                }
            }
        }

        return false;

    }

    // -----------------------------------------------------------------

    // Main
    public static void main(String[] args) {
        new ConnectFour();
    }
    // -----------------------------------------------------------------

}