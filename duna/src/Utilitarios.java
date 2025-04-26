import java.util.concurrent.ThreadLocalRandom;

public class Utilitarios {
    public static final String VERMELHO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String RESETAR = "\u001B[00m";

    public static int gerarNumeroAleatorio(int origem, int limite) {
        return ThreadLocalRandom.current().nextInt(origem, limite);
    }

    public static String colorirTexto(String cor, String texto) {
        if (cor.toUpperCase().equals("VERMELHO")) {
            return VERMELHO + texto + RESETAR;
        } else {
            return VERDE + texto + RESETAR;
        }
    }
}
