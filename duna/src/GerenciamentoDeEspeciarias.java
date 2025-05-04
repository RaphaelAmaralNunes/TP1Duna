import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal responsável por gerenciar a simulão de extração de Melange no planeta Arrakis.
 *
 * <p> O jogo se divide em 12 ciclos, nos quais o jogador deve gerenciar recursos como o número de colheitadeiras, o número de
 * grupos Fremen contrados e o estoque de Melange.</p>
 *
 * <p>A cada ciclo, o jogador pode realizar ações como comprar colheitadeiras, contratar grupos Fremen, enviar colheitadeiras
 * para colher Melange(passando automaticamente o ciclo atual) ou passar o ciclo sem realizar ações. O evento Ataque de Verme
 * influencia no sucesso da colheita.</p>
 *
 * <p>A cada 3 ciclos, o Imperador exige o pagamento de 1000 Melange com tributo. Caso o jogador não pague, penalidades
 * crescente serão aplicados, resultando na perda de Melange e de colheitadeiras. Caso o jogador não pague 3 vezes, o jogo
 * será finalizado.</p>
 *
 * <p>Ao final da simulação, um relatório é gerado com as principais informações da campanha de mineração.</p>
 *
 * <h4>Recursos Gerenciados:</h4>
 * <ul>
 *     <li>Colheitadeiras</li>
 *     <li>Grupos Fremen</li>
 *     <li>Quantidade de Melange</li>
 * </ul>
 *
 * <h4>Eventos Aleatórios:</h4>
 * <ul>
 *     <li>Clima(calmo, instável, agitado, hostil): influencia da chance de ocorrer um ataque de vermes</li>
 *     <li>Ataque de Vermes: caso ocorra, resulta na perda de 1 a 6 colheitadeiras e de toda Melange gerado em um ciclo</li>
 * </ul>
 *
 * @author Iuri da Silva Fenrnandes
 * @author Rjaca do Amaral Nunes
 * @version 1.0
 */

public class GerenciamentoDeEspeciarias {

    public static void main(String[] args) {

        int colheitadeirasDisponiveis;
        int quantidadeMelange;
        int fremenContratados;

        int opcaoEscolhida;

        int colheitadeirasEnviadas;

        double fatorClimatico;
        String clima;
        boolean vermeAtacou;
        int ataquesSofridos;
        int colheitadeirasPerdidas;
        int melangeProduzida;
        int melangeRecebida;
        int melangeAcumulada;

        int dividaFremen;
        int fremenPerdidos;

        int penalidadeImperador;

        int ciclosJogados;
        boolean fimCiclo;

        colheitadeirasDisponiveis = 10;
        quantidadeMelange = 1000;
        fremenContratados = 0;
        ataquesSofridos = 0;
        penalidadeImperador = 0;
        melangeAcumulada = 0;
        ciclosJogados = 0;

        Utilitarios.esperar(1000);

        System.out.println();
        System.out.println("Boas-Vindas Governador de " + Utilitarios.colorirTexto("verde", "Arrakis") + "!");
        System.out.println();

        Utilitarios.esperar(1000);

        Scanner scan = new Scanner(System.in);

        for (int i = 1; i <= 12; i++) {
            ciclosJogados += 1;
            melangeRecebida = 0;
            fimCiclo = false;

            fatorClimatico = Math.random();

            System.out.println("Ciclo " + i);
            System.out.println();

            Utilitarios.esperar(1000);

            if (fatorClimatico <= 0.25) {
                clima = "calmo";
                System.out.println("O clima está " + Utilitarios.colorirTexto("verde", "calmo") + ".");
            } else if (fatorClimatico <= 0.50) {
                clima = "instável";
                System.out.println("O clima está um pouco " + Utilitarios.colorirTexto("amarelo", "instável") + ".");
            } else if (fatorClimatico <= 0.75) {
                clima = "agitado";
                System.out.println("O clima está " + Utilitarios.colorirTexto("laranja", "agitado") + ".");
            } else {
                clima = "hostíl";
                System.out.println("O clima está " + Utilitarios.colorirTexto("vermelho", "hostíl") + ".");
            }
            System.out.println();

            Utilitarios.esperar(1000);

            System.out.println("Colheitadeiras disponíveis: " + colheitadeirasDisponiveis);
            System.out.println("Quantidade de Melange disponível: " + quantidadeMelange);
            System.out.println("Grupos Fremen contratados: " + fremenContratados);
            System.out.println("Quantidade de penalidades: " + penalidadeImperador);
            System.out.println();

            while (!fimCiclo) {

                Utilitarios.esperar(1000);

                System.out.println("Escolha uma opção:");
                System.out.println("1 - Ver informações do ciclo atual");
                System.out.println("2 - Comprar colheitadeira (500 Melange)");
                System.out.println("3 - Contratar grupo Fremen (200 Melange / ciclo cada)");
                System.out.println("4 - Enviar colheitadeiras");
                System.out.println("5 - Passar ciclo");
                System.out.print("Opção: ");

                try {
                    opcaoEscolhida = scan.nextInt();
                } catch (InputMismatchException e) {
                    opcaoEscolhida = -1;
                    scan.next();
                }
                System.out.println();

                Utilitarios.esperar(200);

                switch (opcaoEscolhida) {
                    case -1: // Captura de Exceções
                        System.out.println("Opção inválida. Escolha uma das opções abaixo.");
                        System.out.println();
                        break;

                    case 1: // Mostrar informações
                        System.out.println("Ciclo atual: " + i);
                        System.out.println("Clima: " + clima);
                        System.out.println("Colheitadeiras disponíveis: " + colheitadeirasDisponiveis);
                        System.out.println("Quantidade de Melange disponível: " + quantidadeMelange);
                        System.out.println("Grupos Fremen contratados: " + fremenContratados);
                        System.out.println("Penalidades do Imperador: " + penalidadeImperador);
                        System.out.println();
                        break;

                    case 2: // Comprar colheitadeira
                        if (quantidadeMelange < 500) {
                            System.out.println("Quantidade de Melange insuficiente.");
                        } else {
                            quantidadeMelange -= 500;
                            colheitadeirasDisponiveis += 1;
                            System.out.println("Comprou 1 colheitadeira.");
                            System.out.println("Colheitadeiras disponíveis: " + colheitadeirasDisponiveis);
                            System.out.println("quantidade de Melange restante: " + quantidadeMelange);
                        }
                        System.out.println();
                        break;

                    case 3: // Contratar grupo Fremen
                        fremenContratados += 1;
                        System.out.println("Contratou grupo Fremen.");
                        System.out.println("Grupos Fremen contratados: " + fremenContratados);
                        System.out.println();
                        break;

                    case 4: // Enviar colheitadeiras
                        System.out.println("Quantas colheitadeiras irá enviar: (colheitadeiras disponíveis: " + colheitadeirasDisponiveis + ") ");
                        System.out.print("Quantidade: ");

                        try { //Verificação
                            colheitadeirasEnviadas = scan.nextInt();
                        } catch (InputMismatchException e) {
                            colheitadeirasEnviadas = 0;
                            scan.next();
                        }
                        System.out.println();

                        if (colheitadeirasEnviadas < 1 || colheitadeirasEnviadas > colheitadeirasDisponiveis) {
                            if (colheitadeirasEnviadas < 1) {
                                System.out.println("Você deve enviar ao menos 1 colheitadeira.");
                            } else {
                                System.out.println("Você não possui " + colheitadeirasEnviadas + " colheitadeiras.");
                            }
                        } else {
                            System.out.println("Você enviou " + colheitadeirasEnviadas + " colheitadeiras.");
                            System.out.println();

                            vermeAtacou = Utilitarios.temAtaque(colheitadeirasEnviadas, fatorClimatico, fremenContratados);

                            Utilitarios.esperar(2000);

                            if (vermeAtacou) {
                                melangeRecebida = 0;
                                colheitadeirasPerdidas = Utilitarios.calcularColheitadeirasPerdidas(colheitadeirasEnviadas);

                                if (colheitadeirasPerdidas < colheitadeirasEnviadas) {
                                    colheitadeirasDisponiveis -= colheitadeirasPerdidas;
                                    System.out.println(Utilitarios.colorirTexto("vermelho", "Você sofreu um ataque verme e perdeu " + colheitadeirasPerdidas + " colheitadeiras."));

                                    Utilitarios.esperar(1000);

                                    System.out.println("Quantidade de colheitadeiras restantes: " + colheitadeirasDisponiveis);
                                } else {
                                    colheitadeirasDisponiveis -= colheitadeirasPerdidas;
                                    System.out.println(Utilitarios.colorirTexto("vermelho", "Você sofreu um ataque de verme e perdeu todas as colheitadeiras enviadas"));

                                    Utilitarios.esperar(1000);

                                    System.out.println("Quantidade de colheitadeiras restantes: " + colheitadeirasDisponiveis);
                                }
                                ataquesSofridos += 1;

                            } else {
                                for (int j = 1; j <= colheitadeirasEnviadas; j++) {
                                    melangeProduzida = Utilitarios.gerarNumeroAleatorio(100, 300);
                                    melangeRecebida += melangeProduzida;
                                }
                                System.out.println(Utilitarios.colorirTexto("VERDE", "Você foi bem sucedido e recebeu " + melangeRecebida + " Melange."));
                                quantidadeMelange += melangeRecebida;
                                melangeAcumulada += melangeRecebida;
                            }
                            fimCiclo = true;
                        }
                        System.out.println();
                        break;

                    case 5: // Passar o ciclo atual
                        System.out.println("Passou o ciclo atual.");
                        System.out.println();
                        fimCiclo = true;
                        break;

                    default: // Caso o usuário digite um número menor que 1 ou maior que 5
                        System.out.println("Opção inválida. Escolha uma das opções abaixo.");
                        System.out.println();
                        Utilitarios.esperar(200);
                }
            }

            Utilitarios.esperar(1000);

            if (fremenContratados > 0) {
                System.out.println("Pagamento dos grupos Fremen.");
                System.out.println();
                Utilitarios.esperar(1000);
                if (quantidadeMelange < (fremenContratados * 200)) {
                    dividaFremen = (fremenContratados * 200) - quantidadeMelange;
                    fremenPerdidos = dividaFremen / 200;
                    fremenContratados -= fremenPerdidos;
                    System.out.println("Você não conseguiu pagar todos os grupos Fremen.");
                    System.out.println(fremenPerdidos + " grupos Fremen se revoltaram e foram embora.");
                    System.out.println("Grupos Fremen restantes: " + fremenContratados);
                } else {
                    quantidadeMelange -= fremenContratados * 200;
                    System.out.println("Você pagou os grupos Fremen.");
                    System.out.println("Melange restante: " + quantidadeMelange);
                }
                System.out.println();
                Utilitarios.esperar(1000);
            }
            //Este é o último bloco lógico antes do fim de um ciclo
            if (i % 3 == 0) {
                System.out.println(Utilitarios.colorirTexto("vermelho", "Tributo do Imperador."));
                System.out.println();

                Utilitarios.esperar(1000);

                System.out.println("O Imperador cobra de você 1000 Melange pelas operações em " + Utilitarios.colorirTexto("verde", "Arrakis"));
                System.out.println();

                Utilitarios.esperar(1000);

                switch (penalidadeImperador) {
                    case 0:
                        if (quantidadeMelange < 1000) {
                            penalidadeImperador += 1;
                            System.out.println("Você não consegue pagar o Imperador.");
                            System.out.println();

                            Utilitarios.esperar(1000);

                            if (quantidadeMelange >= 500){
                                quantidadeMelange -= 500;
                                System.out.println("Você recebe uma multa de 500 Melange.");
                            } else {
                                quantidadeMelange = 0;
                                System.out.println("O Imperador confiscou os seus estoques de Melange.");
                            }
                            System.out.println();

                            Utilitarios.esperar(1000);

                            System.out.println("Você recebeu uma penalidade do Imperador.");

                        } else {
                            quantidadeMelange -= 1000;
                            System.out.println("Você pagou o tributo do Imperador.");
                        }
                        System.out.println();
                        break;

                    case 1:
                        if (quantidadeMelange < 1000) {
                            penalidadeImperador += 1;
                            System.out.println("Você não consegue pagar o Imperador.");
                            System.out.println();

                            Utilitarios.esperar(1000);

                            if (colheitadeirasDisponiveis > 2){
                                colheitadeirasDisponiveis -= 2;
                                System.out.println("O Imperador confiscou 2 de suas colheitadeiras.");
                            } else {
                                colheitadeirasDisponiveis = 0;
                                System.out.println("O Imperador confiscou suas colheitadeiras.");
                            }
                            System.out.println();

                            Utilitarios.esperar(1000);

                            System.out.println("Você recebeu uma penalidade do Imperador.");
                        } else {
                            quantidadeMelange -= 1000;
                            System.out.println("Você pagou o tributo do Imperador.");
                        }
                        System.out.println();
                        break;

                    case 2:
                        if (quantidadeMelange < 1000) {
                            i = 13;
                            penalidadeImperador += 1;
                            System.out.println("Você não consegue pagar o Imperador.");
                            System.out.println();

                            Utilitarios.esperar(1000);

                            System.out.println("Você foi destituído do cargo de Governador de " + Utilitarios.colorirTexto("verde", "Arrakis"));
                            System.out.println();
                        } else {
                            quantidadeMelange -= 1000;
                            System.out.println("Você pagou o tributo do Imperador.");
                            System.out.println();
                        }
                        break;
                }

                Utilitarios.esperar(1000);
            }
        }
        Utilitarios.gerarRelatorioFinal(melangeAcumulada, colheitadeirasDisponiveis, ataquesSofridos, penalidadeImperador, ciclosJogados);
    }
}