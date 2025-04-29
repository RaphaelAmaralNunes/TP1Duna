import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Utilitarios {
    private static final String VERMELHO = "\u001B[31m";
    private static final String VERDE = "\u001B[32m";
    private static final String LARANJA = "\u001B[38;2;255;100;0m";
    private static final String AMARELO = "\u001b[33m";

    private static final String RESETAR = "\u001B[00m";

    public static int gerarNumeroAleatorio(int origem, int limite) {
        return ThreadLocalRandom.current().nextInt(origem, limite);
    }

    public static String colorirTexto(String cor, String texto) {
        if (cor.equalsIgnoreCase("VERMELHO")) {
            return VERMELHO + texto + RESETAR;
        } else if (cor.equalsIgnoreCase("AMARELO")) {
            return AMARELO + texto + RESETAR;
        } else if (cor.equalsIgnoreCase("LARANJA")) {
            return LARANJA + texto + RESETAR;
        }
        else {
            return VERDE + texto + RESETAR;
        }
    }

    public static void esperar(int milissegundos) {
        try {
            TimeUnit.MILLISECONDS.sleep(milissegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static double calcularProbabilidadeAtaqueVermes(int numeroColheitadeiras, double fatorClimatico) {
        return (0.1 * (numeroColheitadeiras) * (1 + fatorClimatico));
    }

    public static boolean temAtaque(int numeroColheitadeiras, double fatorClimatico, int fremenContratados) {
        int probabilidadePercentual = (int) (calcularProbabilidadeAtaqueVermes(numeroColheitadeiras, fatorClimatico) * 100);
        if (fremenContratados != 0) {
            probabilidadePercentual -= (fremenContratados * 5);
        }
        System.out.println("Probabilidade de ataque = " + probabilidadePercentual + "%");
        if (probabilidadePercentual >= 100) {
            return true;
        } else {
            return gerarNumeroAleatorio(0, 100) <= probabilidadePercentual;
        }
    }

    public static int calcularColheitadeirasPerdidas(int colheitadeirasEnviadas) {
        if (colheitadeirasEnviadas < 6) {
            if (colheitadeirasEnviadas == 1) {
                return 1;
            } else {
                return gerarNumeroAleatorio(1, colheitadeirasEnviadas);
            }
        } else {
            return gerarNumeroAleatorio(1, 6);
        }
    }

    public static void gerarRelatorioFinal(int melangeAcumulada, int colheitadeirasRestantes, int ataquesSofridos, int penalidadeImperador, int ciclosJogados) {
        System.out.println("FIM DE JOGO!");
        System.out.println("Ciclos jogados = " + ciclosJogados);
        System.out.printf("Quantidade de Melange acumulada: %d%n", melangeAcumulada);
        System.out.printf("Colhetadeiras restantes: %d%n", colheitadeirasRestantes);
        System.out.printf("Ataques sofridos: %d%n", ataquesSofridos);
        System.out.println("Cumpriu as exigêncicas do Imperador: " + (penalidadeImperador < 3 ? "Sim" : "Não"));
    }

}
