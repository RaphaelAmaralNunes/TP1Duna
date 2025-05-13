import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * (contexto: Duna - Gestão de Especiaria)
 * Você é o governador de Arrakis e deve gerenciar a extração de especiaria (melange) em um ambiente hostil. O programa simulará um ano (12 ciclos) de operações. Em cada ciclo, você decide quantas colheitadeiras enviar para o deserto, sabendo que mais máquinas aumentam a produção mas também atraem mais vermes da areia.
 * A probabilidade de ataque de vermes é calculada como: 10% × (número de colheitadeiras) × (1 + fator climático). O fator climático varia aleatoriamente entre 0 e 1 a cada ciclo. Cada colheitadeira produz entre 100 e 300 unidades de especiaria por ciclo, mas se um verme atacar, você perde 1d6 colheitadeiras (isto é, um número aleatório entre 1 e 6) e toda a produção do ciclo.
 * Você começa com 10 colheitadeiras e pode:
 * Comprar mais colheitadeiras (custo: 500 unidades de especiaria cada)
 * Contratar Fremen para espantar vermes (cada grupo de Fremen custa 200 unidades por ciclo e reduz a probabilidade de ataque em 5%, sendo possível contratar múltiplos grupos para redução cumulativa)
 * O Imperador exige um tributo de 1000 unidades de especiaria a cada 3 ciclos. Não pagá-lo resulta nas seguintes penalidades:
 * Primeiro atraso: multa de 500 unidades de especiaria
 * Segundo atraso: confisco de 2 colheitadeiras
 * Terceiro atraso: destituição do cargo (fim de jogo)
 * O programa deve simular os 12 ciclos, permitindo decisões a cada ciclo e mostrando o resultado final: quantidade de especiaria acumulada, colheitadeiras restantes, ataques de vermes sofridos e se você conseguiu cumprir as exigências do Imperador.
 *
 * @author Iuri da Silva Fernandes
 * @author Raphael do Amaral Nunes
 * @version 1.0
 */

public class GerenciamentoDeEspeciarias {

    public static void main(String[] args) {
        int nivelDeDificuldade;
        boolean escolheuDificuldade = false;

        int colheitadeirasDisponiveis;
        int colheitadeirasEnviadas;
        int colheitadeirasPerdidas;

        int quantidadeMelange = 0;
        int melangeProduzida;
        int melangeRecebida;
        int melangeAcumulada;

        int fremenContratados;

        int ciclosJogados;
        int opcaoEscolhida;
        int ataquesSofridos;
        int penalidadeImperador;

        double fatorClimatico;
        String clima;

        boolean fimCiclo;
        boolean vermeAtacou;

        Scanner scan = new Scanner(System.in);
        System.out.println();

        while (!escolheuDificuldade) {
            System.out.println("Selecione a dificuldade do jogo: ");
            System.out.println("1 - Fácil");
            System.out.println("2 - Médio");
            System.out.println("3 - Difícil");
            System.out.print("Dificuldade escolhida: ");

            try {
                nivelDeDificuldade = scan.nextInt();
            } catch (InputMismatchException e) {
                nivelDeDificuldade = 0;
                scan.next();
            }

            System.out.println();

            switch (nivelDeDificuldade) {
                case 1:
                    quantidadeMelange = 1000;
                    escolheuDificuldade = true;
                    break;
                case 2:
                    quantidadeMelange = 500;
                    escolheuDificuldade = true;
                    break;
                case 3:
                    escolheuDificuldade = true;
                    break;
                default:
                    System.out.println("Escolha uma das dificuldades abaixo.");
                    System.out.println();
            }
        }
        // Configuração inicial
        colheitadeirasDisponiveis = 10;
        ataquesSofridos = 0;
        penalidadeImperador = 0;
        melangeAcumulada = 0;
        ciclosJogados = 0;

        Utilitarios.esperar(1000);

        System.out.println();
        System.out.println("Boas-Vindas Governador de " + Utilitarios.colorirTexto("verde", "Arrakis") + "!");
        System.out.println();

        Utilitarios.esperar(1000);

        for (int i = 1; i <= 12; i++) {
            ciclosJogados += 1;
            colheitadeirasEnviadas = 0;
            fremenContratados = 0;
            melangeRecebida = 0;
            fimCiclo = false;

            fatorClimatico = Math.random();

            System.out.println("Ciclo " + i);
            System.out.println();

            Utilitarios.esperar(1000);
            // Fator climático é gerado via Math.random() e consiste em um número entre 0 e 1
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
                        if (quantidadeMelange < 200) {
                            System.out.println("Quantidade de Melange insuficiente");
                            System.out.println();
                        } else {
                            quantidadeMelange -= 200;
                            fremenContratados += 1;
                            System.out.println("Contratou grupo Fremen");
                            System.out.println("Grupos Fremen contratados: " + fremenContratados);
                            System.out.println();
                        }
                        break;

                    case 4: // Enviar colheitadeiras
                        if (colheitadeirasDisponiveis == 0) {
                            System.out.println("Você não possui colheitadeiras. Compre uma por 500 Melange.");
                        } else {
                            while (colheitadeirasEnviadas == 0) {
                                System.out.println("Quantas colheitadeiras irá enviar: (colheitadeiras disponíveis: " + colheitadeirasDisponiveis + ") ");
                                System.out.print("Quantidade: ");

                                try { //Verificação
                                    colheitadeirasEnviadas = scan.nextInt();
                                } catch (InputMismatchException e) {
                                    scan.next();
                                }
                                System.out.println();
                                Utilitarios.esperar(500);

                                if (colheitadeirasEnviadas < 1 || colheitadeirasEnviadas > colheitadeirasDisponiveis) {
                                    if (colheitadeirasEnviadas < 1) {
                                        System.out.println("Você deve enviar no mínimo 1 colheitadeira.");
                                    } else {
                                        System.out.println("Você não possui " + colheitadeirasEnviadas + " colheitadeiras.");
                                    }
                                    colheitadeirasEnviadas = 0;
                                    System.out.println();
                                    Utilitarios.esperar(500);
                                } else {
                                    fimCiclo = true;
                                }
                            }
                        }
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

            if (colheitadeirasEnviadas > 0) { // Ocorre quando o usuário envia ao menos uma colheitadeira
                System.out.println("Você enviou " + colheitadeirasEnviadas + " colheitadeiras.");
                System.out.println();

                vermeAtacou = Utilitarios.temAtaque(colheitadeirasEnviadas, fatorClimatico, fremenContratados);

                Utilitarios.esperar(1000);

                if (vermeAtacou) {
                    colheitadeirasPerdidas = Utilitarios.calcularColheitadeirasPerdidas(colheitadeirasEnviadas);

                    if (colheitadeirasPerdidas < colheitadeirasEnviadas) {
                        colheitadeirasDisponiveis -= colheitadeirasPerdidas;
                        System.out.println(Utilitarios.colorirTexto("vermelho", "Você sofreu um ataque verme e " + "perdeu " + colheitadeirasPerdidas + (colheitadeirasPerdidas == 1 ? " colheitadeira." : " " + "colheitadeiras.")));

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
                System.out.println();
                Utilitarios.esperar(1000);
            }

            if (i % 3 == 0) {
                System.out.println(Utilitarios.colorirTexto("vermelho", "Tributo do Imperador."));
                System.out.println();
                Utilitarios.esperar(1000);

                System.out.println("O Imperador cobra de você 1000 Melange pelas operações em " + Utilitarios.colorirTexto("verde", "Arrakis"));
                System.out.println();
                Utilitarios.esperar(1000);

                if (quantidadeMelange >= 1000) {
                    System.out.println("Você pagou o tributo do Imperador.");
                    quantidadeMelange -= 1000;
                } else {
                    switch (penalidadeImperador) {

                        case 0:
                            penalidadeImperador += 1;
                            System.out.println("Você não consegue pagar o Imperador.");
                            System.out.println();
                            Utilitarios.esperar(1000);

                            if (quantidadeMelange >= 500) {
                                quantidadeMelange -= 500;
                                System.out.println("Você recebe uma multa de 500 Melange.");
                                System.out.println();
                            } else {
                                quantidadeMelange = 0;
                                System.out.println("O Imperador confiscou todo o seu estoque de Melange.");
                                System.out.println();
                            }

                            Utilitarios.esperar(1000);
                            System.out.println("Você recebeu uma penalidade do Imperador.");
                            System.out.println();
                            break;

                        case 1:
                            penalidadeImperador += 1;
                            System.out.println("Você não consegue pagar o Imperador.");
                            System.out.println();
                            Utilitarios.esperar(1000);

                            if (colheitadeirasDisponiveis > 2) {
                                colheitadeirasDisponiveis -= 2;
                                System.out.println("O Imperador confiscou 2 de suas colheitadeiras.");
                                System.out.println();
                            } else {
                                colheitadeirasDisponiveis = 0;
                                System.out.println("O Imperador confiscou todas as suas colheitadeiras.");
                                System.out.println();
                            }

                            Utilitarios.esperar(1000);
                            System.out.println("Você recebeu uma penalidade do Imperador.");
                            System.out.println();
                            break;

                        case 2:
                            i = 13;
                            penalidadeImperador += 1;
                            System.out.println("Você não consegue pagar o Imperador.");
                            System.out.println();

                            Utilitarios.esperar(1000);

                            System.out.println("Você foi destituído do cargo de Governador de " + Utilitarios.colorirTexto("verde", "Arrakis"));
                            System.out.println();
                            break;
                    }
                }
            }
        }
        Utilitarios.gerarRelatorioFinal(melangeAcumulada, colheitadeirasDisponiveis, ataquesSofridos, penalidadeImperador, ciclosJogados);
    }
}