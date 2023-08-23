import java.io.PrintStream; 
import java.util.Scanner;

public class TrabalhoDiogo {
    static int[] acertos = new int[3];
    static String[] nome = new String[3];
    static char resposta;
    static int contador = 0;

    public static void main(String[] Forca) {
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;
        out.println("\033[H\033[2J");
        out.println(Welcome());
        Menu();
        in.close();
    }
    public static String Menu() { //menu do jogo
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;
        out.println("1 - Iniciar jogo");
        out.println("2 - Verificar pontuação");
        out.println("3 - Sair");
        out.println("Selecione uma opção: ");
        int opcao = in.nextInt();
        switch (opcao) {
            case 1:
                IniciarJogo();
                break;
            case 2:
                VerificarPontuacao();
                break;
            case 3:
                Sair();
                break;
            default:
                out.println("Opção inválida!");
                break;
        }
        in.close();
        return "Menu";
    }
    /**
     * @return
     */
    public static String IniciarJogo() { //inicia o jogo
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;
        out.println("\033[H\033[2J");
        out.println(Welcome());
        for (int i = 0; i < nome.length; i++) {
            nome[i] = null;
        }
        for (int i = 0; i < 1; i++) {
            out.println("Digite seu nome: ");
            nome[i] = in.nextLine();
            out.printf("Bem vindo, %s!\n", nome[i]);
        }
        out.println("Digite a palavra secreta: ");//digite uma palavra secreta
        String palavraSecreta = in.nextLine();
        boolean palavraValida = false;
        StringBuilder palavraAtual = new StringBuilder();
        int tentativas = 0;
        for (int i = 0; i < palavraSecreta.length(); i++) {
            palavraAtual.append("_");
        }
        out.printf("Você tem 5 tentativas para acertar. \nPalavra atual : %s\n", palavraAtual);
        while (!palavraValida) {
            out.print("Digite uma letra: ");
            char letra = in.next().charAt(0);
            boolean LetraVerdadeiro = false;
            for (int i = 0; i < palavraSecreta.length(); i++) {
                if (palavraSecreta.charAt(i) == letra) {
                    LetraVerdadeiro = true;
                    palavraAtual.setCharAt(i, letra);
                }
            }
            if (letra > 1) {
            }
            out.printf("Palavra atual : %s\n", palavraAtual);

            if (LetraVerdadeiro) {
                out.println("Letra correta! ");
            } else {
                tentativas = tentativas + 1;
                out.println("letra incorreta ou nao pode digitar mais de uma letra! ");
            }
            if (tentativas == 5) {
                out.printf("Você perdeu se lascou%s!", nome[0]);
                palavraValida = true;
                out.printf("\nPontuação do jogador %s: %d\n", nome[0], acertos[0]);
                out.printf("\n%s, você  continuar jogando? (S/N): ", nome[0]);
                char resposta = in.next().charAt(0);
                if (resposta == 'S' || resposta == 's') {
                    IniciarJogo();
                }
                if (resposta == 'N' || resposta == 'n') {
                    Sair();
                    palavraValida = true;
                    break;
                }
                break;
            }
            if (palavraAtual.toString().equals(palavraSecreta)) {
                out.printf("Parabéns %s, você acertou a palavra amém: [%s]. ", nome[0], palavraSecreta);
                palavraValida = true;
                contador = contador + 1;
                if (contador == 1) {
                    acertos[0] = acertos[0] + 1;
                }
                out.printf("\nPontuação do jogador %s: %d\n", nome[0], acertos[0]);
                out.printf("\n%s, você deseja continuar jogando novamente? (S/N): ", nome[0]);
                char resposta = in.next().charAt(0);
                if (resposta == 'S' || resposta == 's') {
                    IniciarJogo();
                }
                if (resposta == 'N' || resposta == 'n') {
                    Menu();
                    palavraValida = true;
                    break;
                }
                contador = contador + 1;
                break;
            }
        }
        in.close();
        return "IniciarJogo";
    }
    public static String VerificarPontuacao() {
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;
        out.println("\033[H\033[2J");
        boolean palavraValida = false;
        while (!palavraValida) {
            if (contador == 0 || nome[0] == null){
                palavraValida = true;
                out.println("Para verificar sua pontuação deve iniciar o jogo");
                out.printf("\nVocê deseja voltar para o menu ? (S/N): ");
                char resposta = in.next().charAt(0);
                if (resposta == 'S' || resposta == 's') {
                    Menu();
                }
                if (resposta == 'N' || resposta == 'n') {
                    Sair();
                    palavraValida = true;
                    break;

                }
                break;
            }
            if (nome[0] == null) {
                if (resposta == 'S' || resposta == 's') {
                    Menu();
                }
                if (resposta == 'N' || resposta == 'n') {
                    Sair();
                    palavraValida = true;
                    break;
                }
            }
            if (nome[0] != null) {
                for (int i = 0; i < nome.length; i++) {
                    out.printf("\nPontuação do jogador %s: %d.\n", nome[i], acertos[i]);
                }
                out.printf("\n%s, você deseja voltar para o menu? (S/N): ", nome[0]);
                char resposta = in.next().charAt(0);
                if (resposta == 'S' || resposta == 's') {
                    Menu();
                }
                if (resposta == 'N' || resposta == 'n') {
                    Sair();
                    palavraValida = true;
                    break;
                }
                palavraValida = true;
            }
            if (resposta == 'N' || resposta == 'n') {
                Sair();
                palavraValida = true;
                break;
            }
        }
        in.close();
        return "VerificarPontuacao";
    }
    public static String Sair() { 
        PrintStream out = System.out;
        out.println("\033[H\033[2J");
        out.println("Fim do jogo!");
        return "fim do jogo";
    }
    public static String Welcome() { 
        return "Bem vindo ao Jogo da forca";
    }
}
