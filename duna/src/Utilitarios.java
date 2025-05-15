import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Utilitarios {
    private static final String VERMELHO = "\u001B[31m";
    private static final String LARANJA = "\u001B[38;2;255;100;0m";
    private static final String AMARELO = "\u001b[33m";
    private static final String VERDE = "\u001B[32m";
    private static final String RESETAR = "\u001B[00m";

    // Gera um número aleatório inteiro >= origem e < limite
    public static int gerarNumeroAleatorio(int origem, int limite) {
        return ThreadLocalRandom.current().nextInt(origem, limite);
    }

    // Colore o texto no terminal com base em ANSI escape code
    public static String colorirTexto(String cor, String texto) {
        if (cor.equalsIgnoreCase("VERMELHO")) {
            return VERMELHO + texto + RESETAR;
        } else if (cor.equalsIgnoreCase("AMARELO")) {
            return AMARELO + texto + RESETAR;
        } else if (cor.equalsIgnoreCase("LARANJA")) {
            return LARANJA + texto + RESETAR;
        } else {
            return VERDE + texto + RESETAR;
        }
    }

    // Coloca a Thread main em modo sleep por x milissegundos
    public static void esperar(int milissegundos) {
        try {
            TimeUnit.MILLISECONDS.sleep(milissegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Calcula a chance de um verme atacar no ciclo atual
    private static double calcularProbabilidadeAtaqueVermes(int numeroColheitadeiras, double fatorClimatico) {
        return (0.1 * (numeroColheitadeiras) * (1 + fatorClimatico));
    }

    // Verifica se haverá um ataque de verme no ciclo atual
    public static boolean temAtaque(int numeroColheitadeiras, double fatorClimatico, int fremenContratados) {
        int probabilidadePercentual = (int) (calcularProbabilidadeAtaqueVermes(numeroColheitadeiras, fatorClimatico) * 100);
        if (fremenContratados != 0) {
            probabilidadePercentual -= (fremenContratados * 5);
        }
        if (probabilidadePercentual >= 100) {
            return true;
        } else {
            return gerarNumeroAleatorio(0, 100) <= probabilidadePercentual;
        }
    }

    // Calcula quantas colheitadeiras serão perdidas caso haja ataque de verme
    public static int calcularColheitadeirasPerdidas(int colheitadeirasEnviadas) {
        if (colheitadeirasEnviadas < 6) {
            if (colheitadeirasEnviadas == 1) {
                return 1;
            } else {
                return gerarNumeroAleatorio(1, colheitadeirasEnviadas + 1);
            }
        } else {
            return gerarNumeroAleatorio(1, 7);
        }
    }

    public static void gerarRelatorioFinal(int melangeAcumulada, int colheitadeirasRestantes, int ataquesSofridos, int penalidadeImperador, int ciclosJogados) {
        System.out.println("FIM DE JOGO!");
        System.out.println("Ciclos jogados = " + ciclosJogados);
        System.out.printf("Quantidade de Melange acumulada: %d%n", melangeAcumulada);
        System.out.printf("Colheitadeiras restantes: %d%n", colheitadeirasRestantes);
        System.out.printf("Ataques sofridos: %d%n", ataquesSofridos);
        System.out.println("Cumpriu as exigêncicas do Imperador: " + (penalidadeImperador < 3 ? "Sim" : "Não"));
    }
}
