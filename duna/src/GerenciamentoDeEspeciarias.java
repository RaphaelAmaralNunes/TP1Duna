import java.util.Scanner;

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
        quantidadeMelange = 500;
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
            Utilitarios.esperar(200);
            System.out.println("Quantidade de Melange disponível: " + quantidadeMelange);
            Utilitarios.esperar(200);
            System.out.println("Grupos Fremen contratados: " + fremenContratados);
            Utilitarios.esperar(200);
            System.out.println("Quantidade de penalidades = " + penalidadeImperador);
            System.out.println();

            while (!fimCiclo) {

                Utilitarios.esperar(1000);

                System.out.println("Escolha uma opção:");

                Utilitarios.esperar(1000);

                System.out.println("1 - Ver informações do ciclo atual");
                Utilitarios.esperar(200);
                System.out.println("2 - Comprar colheitadeira (500 Melange)");
                Utilitarios.esperar(200);
                System.out.println("3 - Contratar grupo Fremen (200 Melange / ciclo cada)");
                Utilitarios.esperar(200);
                System.out.println("4 - Enviar colheitadeiras");
                Utilitarios.esperar(200);
                System.out.println("5 - Passar ciclo");
                Utilitarios.esperar(200);

                System.out.print("Opção: ");
                opcaoEscolhida = scan.nextInt();
                System.out.println();

                Utilitarios.esperar(1000);

                switch (opcaoEscolhida) {
                    case 1:
                        System.out.println("Ciclo atual = " + i);
                        Utilitarios.esperar(200);
                        System.out.println("Clima = " + clima);
                        Utilitarios.esperar(200);
                        System.out.println("Colheitadeiras disponíveis = " + colheitadeirasDisponiveis);
                        Utilitarios.esperar(200);
                        System.out.println("Quantidade de Melange disponível = " + quantidadeMelange);
                        Utilitarios.esperar(200);
                        System.out.println("Grupos Fremen contratados = " + fremenContratados);
                        Utilitarios.esperar(200);
                        System.out.println("Penalidades do Imperador = " + penalidadeImperador);
                        System.out.println();
                        break;

                    case 2:
                        if (quantidadeMelange < 500) {
                            System.out.println("Quantidade de Melange insuficiente.");
                        } else {
                            quantidadeMelange -= 500;
                            colheitadeirasDisponiveis += 1;
                            System.out.println("Comprou 1 colheitadeira.");
                            System.out.println("Colheitadeiras disponíveis = " + colheitadeirasDisponiveis);
                            System.out.println("quantidade de Melange restante = " + quantidadeMelange);
                        }
                        System.out.println();
                        break;

                    case 3:
                        fremenContratados += 1;
                        System.out.println("Contratou grupo Fremen.");
                        System.out.println("Grupos Fremen contratados = " + fremenContratados);
                        System.out.println();
                        break;

                    case 4:
                        System.out.println("Quantas colheitadeiras irá enviar: (colheitadeiras disponíveis = " + colheitadeirasDisponiveis + ") ");
                        System.out.print("Quantidade: ");
                        colheitadeirasEnviadas = scan.nextInt();
                        System.out.println();

                        if (colheitadeirasEnviadas < 1 || colheitadeirasEnviadas > colheitadeirasDisponiveis) {
                            if (colheitadeirasEnviadas < 1) {
                                System.out.println("Você deve enviar ao menos 1 colheitadeira.");
                            } else {
                                System.out.println("Você não possui " + colheitadeirasEnviadas + " colheitadeiras.");
                            }
                            System.out.println();
                        } else {
                            System.out.println("Você enviou " + colheitadeirasEnviadas + " colheitadeiras.");
                            System.out.println();

                            vermeAtacou = Utilitarios.temAtaque(colheitadeirasEnviadas, fatorClimatico, fremenContratados);

                            for (int j = 1; j <= colheitadeirasEnviadas; j++) {
                                melangeProduzida = Utilitarios.gerarNumeroAleatorio(100, 300);
                                melangeRecebida += melangeProduzida;
                            }

                            if (vermeAtacou) {
                                colheitadeirasPerdidas = Utilitarios.calcularColheitadeirasPerdidas(colheitadeirasEnviadas);
                                melangeRecebida = 0;

                                if (colheitadeirasPerdidas < colheitadeirasEnviadas) {
                                    colheitadeirasDisponiveis -= colheitadeirasPerdidas;
                                    System.out.printf("Você sofreu um ataque de verme e perdeu %d colheitadeiras.\nQuantidade atual " +
                                            "de colheitadeiras: %d%n", colheitadeirasPerdidas, colheitadeirasDisponiveis);
                                } else {
                                    colheitadeirasDisponiveis -= colheitadeirasPerdidas;
                                    System.out.println("Você sofreu um ataque de verme e perdeu todas as colheitadeiras enviadas");
                                }
                                ataquesSofridos += 1;
                            } else {
                                System.out.printf(Utilitarios.colorirTexto("VERDE", "Você foi bem sucedido e recebeu %d " + "Melange"), melangeRecebida);
                                quantidadeMelange += melangeRecebida;
                                melangeAcumulada += melangeRecebida;
                            }

                            System.out.println();
                            fimCiclo = true;
                        }
                        System.out.println();
                        break;

                    case 5:
                        System.out.println("Passou o ciclo atual.");
                        System.out.println();
                        fimCiclo = true;
                        break;

                    default:
                        System.out.println("Opção inválida. Escolha uma das opções abaixo.");
                        System.out.println();
                        Utilitarios.esperar(200);
                }
            }
            if (fremenContratados > 0) {
                System.out.println("Pagamento dos grupos Fremen.");
                System.out.println();
                if (quantidadeMelange < (fremenContratados * 200)) {
                    dividaFremen = (fremenContratados * 200) - quantidadeMelange;
                    fremenPerdidos = dividaFremen / 200;
                    fremenContratados -= fremenPerdidos;
                    System.out.println("Você não conseguiu pagar todos os grupos Fremen.");
                    System.out.println();
                    System.out.println(fremenPerdidos + " grupos Fremen se revoltaram e foram embora.");
                    System.out.println();
                    System.out.println("Grupos Fremen restantes = " + fremenContratados);
                    System.out.println();
                } else {
                    quantidadeMelange -= fremenContratados * 200;
                    System.out.println("Você pagou os grupos Fremen.");
                    System.out.println();
                    System.out.println("Melange restante = " + quantidadeMelange);
                    System.out.println();
                }
            }
            //Este é o último bloco lógico antes do fim de um ciclo
            if (i == 3 || i == 6 || i == 9 || i == 12) {
                System.out.println("Tributo do " + Utilitarios.colorirTexto("vermelho", "Imperador"));
                System.out.println();
                System.out.println("O Imperador cobra de você 1000 Melange como tributo pelas operações em " + Utilitarios.colorirTexto("verde", "Arrakis"));
                System.out.println();
                System.out.println("Quantidade de Melange disponível = " + quantidadeMelange);
                System.out.println();

                switch (penalidadeImperador) {
                    case 0:
                        if (quantidadeMelange < 1000 && quantidadeMelange >= 500) {
                            quantidadeMelange -= 500;
                            penalidadeImperador += 1;
                            System.out.println("Você não consegue pagar o Imperador.");
                            System.out.println();
                            System.out.println("Você recebe uma multa de 500 Melange.");
                            System.out.println();
                            System.out.println("Você recebe uma penalidade do imperador.");
                            System.out.println();
                        } else if (quantidadeMelange < 500) {
                            quantidadeMelange = 0;
                            penalidadeImperador += 1;
                            System.out.println("Você não consegue pagar o Imperador.");
                            System.out.println();
                            System.out.println("O Imperador confisca os seus estoques de Melange.");
                            System.out.println();
                            System.out.println("Você recebe uma penalidade do Imperador.");
                            System.out.println();
                        } else {
                            quantidadeMelange -= 1000;
                            System.out.println("Você pagou o tributo do Imperador.");
                            System.out.println();
                        }
                        break;
                    case 1:
                        if (quantidadeMelange < 1000 && colheitadeirasDisponiveis < 2) {
                            colheitadeirasDisponiveis = 0;
                            penalidadeImperador += 1;
                            System.out.println("Você não consegue pagar o Imperador.");
                            System.out.println();
                            System.out.println("O Imperador confisca suas colheitadeiras.");
                            System.out.println();
                            System.out.println("Você recebe uma penalidade do Imperador.");
                            System.out.println();
                        } else if (quantidadeMelange < 1000) {
                            colheitadeirasDisponiveis -= 2;
                            penalidadeImperador += 1;
                            System.out.println("Você não consegue pagar o Imperador.");
                            System.out.println();
                            System.out.println("O Imperador confisca 2 de suas colheitadeiras.");
                            System.out.println();
                            System.out.println("Você recebe uma penalidade do Imperador.");
                            System.out.println();
                        } else {
                            quantidadeMelange -= 1000;
                            System.out.println("Você pagou o tributo do Imperador.");
                            System.out.println();
                        }
                        break;
                    case 2:
                        if (quantidadeMelange < 1000) {
                            i = 13;
                            penalidadeImperador += 1;
                            System.out.println("Você não consegue pagar o Imperador.");
                            System.out.println();
                            System.out.println("Você foi destituído do cargo de Governador de " + Utilitarios.colorirTexto("verde", "Arrakis"));
                            System.out.println();
                        } else {
                            quantidadeMelange -= 1000;
                            System.out.println("Você pagou o tributo do Imperador.");
                            System.out.println();
                        }
                        break;
                }
            }
        }
        Utilitarios.gerarRelatorioFinal(melangeAcumulada, colheitadeirasDisponiveis, ataquesSofridos, penalidadeImperador, ciclosJogados);
    }
}