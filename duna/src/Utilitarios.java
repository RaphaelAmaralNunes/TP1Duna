import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Classe que fornece métodos auxiliares genéricos para fins de estilização e qualidade de código
 * @author Iuri da Silva Fernandes
 * @author Raphael do Amaral Nunes
 * @version 1.0
 */
public class Utilitarios {
    private static final String VERMELHO = "\u001B[31m";
    private static final String LARANJA = "\u001B[38;2;255;100;0m";
    private static final String AMARELO = "\u001b[33m";
    private static final String VERDE = "\u001B[32m";

    private static final String RESETAR = "\u001B[00m";

    /**
     * Gera um número aleatório inteiro entre o intervalo informado utilizando {@link ThreadLocalRandom}
     * @param origem limite inferior(inclusivo) do intervalo
     * @param limite limite superior(exclusivo) do intervalo
     * @return um número inteiro aleatório entre a {@code origem} e o {@code limite}
     * @throws IllegalArgumentException se {@code origem >= limite}
     * @author Iuri da Silva Fernandes
     */
    public static int gerarNumeroAleatorio(int origem, int limite) {
        return ThreadLocalRandom.current().nextInt(origem, limite);
    }

    /**
     * Colore o texto informado utilizando ANSI Escape Code
     * @param cor a cor que o texto no ficará no terminal
     * @param texto a String a ser colorida
     * @return o {@code texto} informado colorido na {@code cor} informada
     * @author Iuri da Silva Fernandes
     * @author Raphael do Amaral Nunes
     */
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

    /**
     * Faz com que a {@link Thread} atual fique em modo sleep pelo tempo informado em milissegundos
     * @param milissegundos tempo em milissegundos que a {@link Thread} ficará no modo sleep
     * @throws RuntimeException caso o processo seja interrompido
     * @author Iuri da Silva Fernandes
     * @author Raphael do Amaral Nunes
     */
    public static void esperar(int milissegundos) {
        try {
            TimeUnit.MILLISECONDS.sleep(milissegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Calcula a probabilidade um verme atacar com base no número de colheitadeiras enviadas e no clima atual
     * @param numeroColheitadeiras o número de colheitadeiras que serão enviadas
     * @param fatorClimatico o fator climático atual
     * @return a probabilidade percentual de um ataque de vermes acontecer
     * @author Iuri da Silva Fernandes
     * @author Raphael do Amaral Nunes
     */
    public static double calcularProbabilidadeAtaqueVermes(int numeroColheitadeiras, double fatorClimatico) {
        return (0.1 * (numeroColheitadeiras) * (1 + fatorClimatico));
    }

    /**
     * Informa se terá ataque com base no número de colheitadeiras enviadas, fator climático e grupos Fremens contratados
     * no ciclo atual
     * @param numeroColheitadeiras o número de colheitadeiras que serão enviadas
     * @param fatorClimatico o fator climático atual
     * @param fremenContratados a quantidade de grupos Fremens contratados no ciclo atual
     * @return um boolean informando se haverá ataque ou não
     * 
     * @see #calcularProbabilidadeAtaqueVermes(int, double) 
     * @see #gerarNumeroAleatorio(int, int)
     * @author Iuri da Silva Fernandes
     * @author Raphael do Amaral Nunes
     */
    public static boolean temAtaque(int numeroColheitadeiras, double fatorClimatico, int fremenContratados) {
        int probabilidadePercentual = (int) (calcularProbabilidadeAtaqueVermes(numeroColheitadeiras, fatorClimatico) * 100);
        if (fremenContratados != 0) {
            probabilidadePercentual -= (fremenContratados * 5);
        }
        //System.out.println("Probabilidade de ataque = " + probabilidadePercentual + "%");
        if (probabilidadePercentual >= 100) {
            return true;
        } else {
            return gerarNumeroAleatorio(0, 100) <= probabilidadePercentual;
        }
    }

    /**
     * Calcula quantas colheitadeiras foram perdidas após um ataque de vermes
     * @param colheitadeirasEnviadas o número de colheitadeiras que serão enviadas
     * @return um número aleatório gerado entre 1 e 6 ou 1 e colheitadeirasEnviadas
     *
     * @see #gerarNumeroAleatorio(int, int) 
     * @author Iuri da Silva Fernandes
     * @author Raphael do Amaral Nunes
     */
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


    /**
     * Imprime no console os resultados com os principais dados na partida.
     *
     * <p>As seguintes informações são exibidas:
     * <ul>
     *     <li>A quantidade melange acumulada
     *     <li>Colheitadeiras restantes
     *     <li>Quantidade de ataques de vermes sofridos
     *     <li>Penalidades aplicados pelo Imperador
     *     <li>Total de ciclos jogados
     * </ul>
     * <p> O método deve ser chamado no final da partida para fornecer um resumo das estatísticas do jogador
     * @param melangeAcumulada a quantidade de melange acumulada ao longo do jogo
     * @param colheitadeirasRestantes a quantidade de colheitadeiras restantes ao final do jogo
     * @param ataquesSofridos quantos ataques de verme o jogador sofreu ao longo do jogo
     * @param penalidadeImperador quantas penalidades do jogador sofreu ao longo do jogo
     * @param ciclosJogados quantos ciclos foram jogados até o fim da partida
     * @author Iuri da Silva Fernandes
     * @author Raphael do Amaral Nunes
     */
    public static void gerarRelatorioFinal(int melangeAcumulada, int colheitadeirasRestantes, int ataquesSofridos, int penalidadeImperador, int ciclosJogados) {
        System.out.println("FIM DE JOGO!");
        System.out.println("Ciclos jogados = " + ciclosJogados);
        System.out.printf("Quantidade de Melange acumulada: %d%n", melangeAcumulada);
        System.out.printf("Colhetadeiras restantes: %d%n", colheitadeirasRestantes);
        System.out.printf("Ataques sofridos: %d%n", ataquesSofridos);
        System.out.println("Cumpriu as exigêncicas do Imperador: " + (penalidadeImperador < 3 ? "Sim" : "Não"));
    }

}
