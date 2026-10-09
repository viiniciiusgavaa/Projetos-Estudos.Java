import java.util.Scanner;

public class Desafio4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1 - Soma | 2 - Subtração | 3 - Multiplicação | 4 - Divisão | 0 - Sair");
            System.out.print("Opção: ");
            opcao = scan.nextInt();

            if (opcao >= 1 && opcao <= 4) {
                System.out.print("Dois números: ");
                double a = scan.nextDouble();
                double b = scan.nextDouble();

                switch (opcao) {
                    case 1:
                        System.out.println("Resultado: " + (a + b));
                        break;
                    case 2:
                        System.out.println("Resultado: " + (a - b));
                        break;
                    case 3:
                        System.out.println("Resultado: " + (a * b));
                        break;
                    case 4:
                        if (b == 0) {
                            System.out.println("Não é possível dividir por zero!");
                        } else {
                            System.out.println("Resultado: " + (a / b));
                        }
                        break;
                }
            } else if (opcao != 0) {
                System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Até mais!");
    }
}
