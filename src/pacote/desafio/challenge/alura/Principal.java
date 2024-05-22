package pacote.desafio.challenge.alura;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leia = new Scanner(System.in);
        ConversorApp app = new ConversorApp();
        app.moeda("USD");  //moeda base americana

        // comeca aqui
        int opcao = 0;
        while (opcao != 7) {
            System.out.println("********************************************************" +
                    "\n" +
                    "Seja bem-vindo(a) ao conversor de Moeda :)\n" +
                    "\n1) Dólar -> Peso argentino\n" +
                    "2) Peso argentino -> Dólar\n" +
                    "3) Dólar -> Real brasileiro\n" +
                    "4) Real brasileiro -> Dólar\n" +
                    "5) Dólar -> Peso colombiano\n" +
                    "6) Peso colombiano -> Dólar\n" +
                    "7) Sair\n" +
                    "Escolha uma opção válida\n" +
                    "********************************************************");
            opcao = leia.nextInt();

            if ((opcao < 1) || (opcao > 7)) {
                System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 7.");
            } else if (opcao != 7) {
                System.out.println("Digite um valor que deseja converter:");
                double valor = leia.nextDouble();
                double resultado = 0;

                switch (opcao) {
                    case 1:
                        resultado = app.converter("USD", "ARS", valor);
                        System.out.println("Resultado: " + resultado + " ARS");
                        break;
                    case 2:
                        resultado = app.converter("ARS", "USD", valor);
                        System.out.println("Resultado: " + resultado + " USD");
                        break;
                    case 3:
                        resultado = app.converter("USD", "BRL", valor);
                        System.out.println("Resultado: " + resultado + " BRL");
                        break;
                    case 4:
                        resultado = app.converter("BRL", "USD", valor);
                        System.out.println("Resultado: " + resultado + " USD");
                        break;
                    case 5:
                        resultado = app.converter("USD", "COP", valor);
                        System.out.println("Resultado: " + resultado + " COP");
                        break;
                    case 6:
                        resultado = app.converter("COP", "USD", valor);
                        System.out.println("Resultado: " + resultado + " USD");
                        break;
                }
            }
        }

        leia.close();
    }
}
