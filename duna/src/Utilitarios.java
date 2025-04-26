import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Utilitarios {
    private static final String VERMELHO = "\u001B[31m";
    private static final String VERDE = "\u001B[32m";
    private static final String RESETAR = "\u001B[00m";

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

    public static void esperar(int segundos){
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
