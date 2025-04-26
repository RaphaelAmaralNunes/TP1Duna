import java.util.concurrent.ThreadLocalRandom;

public class Utilitarios {
    public static int gerarNumeroAleatorio(int origem, int limite) {
        return ThreadLocalRandom.current().nextInt(origem, limite);
    }
}
