import java.util.Scanner;

public class GerenciamentoDeEspeciarias {

    public static void main(String[] args) {
        int colheitadeirasDisponiveis;
        int quantidadeMelange;
        int melangeRecebida;
        int fremenContratados;
        int opcaoEscolhida;
        int colheitadeirasEnviadas;
        double fatorClimatico;
        boolean fimCiclo;

        colheitadeirasDisponiveis = 10;
        quantidadeMelange = 0;
        fremenContratados = 0;

        System.out.println();
        System.out.println("Boas-Vindas Governador de " + Utilitarios.colorirTexto("verde", "Arrakis") + "!");
        System.out.println();
        Utilitarios.esperar(2);

        Scanner scan = new Scanner(System.in);
        for (int i = 1; i <= 12; i++) {
            colheitadeirasEnviadas = 0;
            melangeRecebida = 0;
            fimCiclo = false;

            if (i == 4 || i == 7 || i == 10) {
                System.out.println(Utilitarios.colorirTexto("vermelho", "Tributo do imperador"));
                System.out.println();
            }

            System.out.println("Ciclo " + i);
            System.out.println();
            System.out.println("Colheitadeiras disponíveis: " + colheitadeirasDisponiveis);
            System.out.println("Quantidade de Melange disponível:" + quantidadeMelange);
            System.out.println("Grupos Fremen contratados: " + fremenContratados);
            System.out.println();
            Utilitarios.esperar(2);

            while (!fimCiclo) {

                System.out.println("Escolha uma opção: ");
                System.out.println("1 - Ver recursos atuais ");
                System.out.println("2 - Comprar colheitadeira (500 Melange) ");
                System.out.println("3 - Contratar grupo Fremen (200 Melange / ciclo cada) ");
                System.out.println("4 - Enviar colheitadeiras ");
                System.out.println("5 - Passar ciclo ");

                opcaoEscolhida = scan.nextInt();
                System.out.println();
                Utilitarios.esperar(1);

                switch (opcaoEscolhida) {
                    case 1:
                        System.out.println("Colheitadeiras disponíveis = " + colheitadeirasDisponiveis);
                        System.out.println("Quantidade de Melange disponível = " + quantidadeMelange);
                        System.out.println("Grupos Fremen contratados = " + fremenContratados);

                        System.out.println();
                        break;

                    case 2:
                        if (quantidadeMelange < 500) {
                            System.out.println("Quantidade de Melange insuficiente.");
                            System.out.println();
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
                        System.out.println("Quantas colheitadeiras irá enviar: (colheitadeitas disponíveis = " + colheitadeirasDisponiveis + ") ");
                        colheitadeirasEnviadas = scan.nextInt();

                        if (colheitadeirasEnviadas < 1 || colheitadeirasEnviadas > colheitadeirasDisponiveis) {
                            if (colheitadeirasEnviadas < 1) {
                                System.out.println("Você deve enviar ao menos 1 colheitadeira.");
                            } else {
                                System.out.println("Você não possui " + colheitadeirasEnviadas + " colheitadeiras.");
                            }
                        } else {
                            boolean vermeAtacou = Utilitarios.temAtaque(colheitadeirasEnviadas, fremenContratados);
                            for (int j = 0; j < colheitadeirasEnviadas; j++) {
                                int melangeProduzida = Utilitarios.gerarNumeroAleatorio(100, 300);
                                melangeRecebida += melangeProduzida;
                            }
                            if (vermeAtacou) {
                                int colheitadeirasPerdidas = Utilitarios.calcularColheitadeirasPerdidas();
                                melangeRecebida = 0;
                                if (colheitadeirasPerdidas > colheitadeirasEnviadas) {
                                    colheitadeirasDisponiveis -= colheitadeirasEnviadas;
                                    System.out.printf("Você sofreu um ataque de verme e perdeu %d colheitadeiras%nQuantidade atual " +
                                            "de colheitadeiras: %d%n", colheitadeirasEnviadas, colheitadeirasDisponiveis);
                                } else {
                                    if (colheitadeirasDisponiveis < colheitadeirasPerdidas) {
                                        colheitadeirasDisponiveis = 0;
                                        System.out.println("Você sofreu um ataque de verme e perdeu todas as suas " +
                                                "colheitadeiras");

                                    } else {
                                        colheitadeirasDisponiveis -= colheitadeirasPerdidas;
                                        System.out.printf("Você sofreu um ataque de verme e perdeu %d colheitadeiras%nQuantidade atual " +
                                                "de colheitadeiras: %d%n", colheitadeirasEnviadas, colheitadeirasDisponiveis);
                                    }
                                }
                            } else {
                                System.out.printf(Utilitarios.colorirTexto("VERDE", "Você foi bem sucedido e recebeu %d " +
                                        "melanges"), melangeRecebida);
                                quantidadeMelange += melangeRecebida;
                            }
                        }
                        fimCiclo = true;
                        System.out.println();
                        break;

                    case 5:
                        System.out.println("Passou o ciclo atual");
                        System.out.println();
                        fimCiclo = true;
                        break;

                    default:
                        System.out.println("Opção inválida. Escolha uma das opções abaixo.");
                        System.out.println();
                }
            }
        }
    }
}

