import java.util.Scanner;
import java.util.concurrent.*;

public class GerenciamentoDeEspeciarias {

    public static void main(String[] args) throws InterruptedException {
        int colheitadeirasDisponiveis;
        int quantidadeMelange;
        int fremenContratados;
        int opcaoEscolhida;
        int colheitadeirasEnviadas;
        int melangeRecebida;
        boolean fimCiclo;

        colheitadeirasDisponiveis = 10;
        quantidadeMelange = 0;
        fremenContratados = 0;
        Scanner scan = new Scanner(System.in);

        for (int i = 1; i <= 12; i++) {
            colheitadeirasEnviadas = 0;
            melangeRecebida = 0;
            fimCiclo = false;

            System.out.println("Boas-Vindas Governador de "+ Utilitarios.colorirTexto("verde","Arrakis")+"!");
            Utilitarios.esperar(1);
            System.out.println("Ciclo " + i);
            System.out.println("Colheitadeiras disponíveis: " + colheitadeirasDisponiveis);
            System.out.println("Quantidade de Melange disponível:" + quantidadeMelange);
            System.out.println("Grupos Fremen contratados: " + fremenContratados);
            System.out.println();

            while(fimCiclo == false){
                System.out.println("Escolha uma opção: ");
                System.out.println("1 - Ver recursos atuais ");
                System.out.println("2 - Comprar colheitadeira (500 Melange) ");
                System.out.println("3 - Contratar grupo Fremen (200 Melange / ciclo cada) ");
                System.out.println("4 - Enviar colheitadeiras ");
                System.out.println("5 - Passar ciclo ");

                opcaoEscolhida = scan.nextInt();
                System.out.println();

                switch(opcaoEscolhida){
                    case 1:
                        System.out.println("Colheitadeiras disponíveis = " + colheitadeirasDisponiveis);
                        System.out.println("Quantidade de Melange disponível = " + quantidadeMelange);
                        System.out.println("Grupos Fremen contratados = " + fremenContratados);

                        System.out.println();
                        break;

                    case 2:
                        if(quantidadeMelange < 500) {
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

                        if(colheitadeirasEnviadas < 1 || colheitadeirasEnviadas > colheitadeirasDisponiveis) {
                            if(colheitadeirasEnviadas < 1) {
                                System.out.println("Você deve enviar ao menos 1 colheitadeira.");
                            } else {
                                System.out.println("Você não possui " + colheitadeirasEnviadas + " colheitadeiras.");
                            }
                        } else {
                            fimCiclo = true;
                        }

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
            scan.close();
        }
    }
}
