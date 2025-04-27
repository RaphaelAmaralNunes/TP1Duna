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
        if (cor.equalsIgnoreCase("VERMELHO")) {
            return VERMELHO + texto + RESETAR;
        } else {
            return VERDE + texto + RESETAR;
        }
    }

    public static void esperar(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static double calcularProbabilidadeAtaqueVermes(int numeroColheitadeiras) {
        double fatorClimatico = Math.random();
        return (0.1 * (numeroColheitadeiras) * (1 + fatorClimatico));
    }

    public static boolean temAtaque(int numeroColheitadeiras, int fremenContratados) {
        int probabilidadePercentual = (int) (calcularProbabilidadeAtaqueVermes(numeroColheitadeiras) * 100);
        if (fremenContratados != 0) {
            probabilidadePercentual -= (fremenContratados * 5);
        }
        if (probabilidadePercentual >= 100) {
            return true;
        } else {
            return gerarNumeroAleatorio(0, 100) < probabilidadePercentual;
        }
    }

    public static int calcularColheitadeirasPerdidas() {
        return gerarNumeroAleatorio(1, 6);
    }

    public static void gerarRelatorioFinal(int melangeAcumulada, int colheitadeirasRestantes, int ataquesSofridos,
                                           int penalidadeImperador){
        System.out.println("FIM DOS 12 CICLOS");
        System.out.printf("Quantidade de especiaria acumulada: %d%n", melangeAcumulada);
        System.out.printf("Colhetadeiras restantes: %d%n",colheitadeirasRestantes);
        System.out.printf("Ataques sofridos: %d%n", ataquesSofridos);
        System.out.println("Cumpriu as exigêncicas do Imperador: " + (penalidadeImperador<3?"Sim":"Não"));
    }

}
