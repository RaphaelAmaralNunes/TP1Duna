import java.util.concurrent.ThreadLocalRandom;

public class GerenciamentoDeEspeciarias {

    public static void main(String[] args) {

    }

    public static int gerarNumeroAleatorio(int origem, int limite) {
        return ThreadLocalRandom.current().nextInt(origem, limite);
    }
}
