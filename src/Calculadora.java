import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();

        System.out.println("\nEscolha uma operação:");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");

        System.out.print("Digite a opção: ");
        int opcao = scanner.nextInt();

        double resultado;

        if (opcao == 1) {
            resultado = num1 + num2;
            System.out.println("Resultado: " + resultado);

        } else if (opcao == 2) {
            resultado = num1 - num2;
            System.out.println("Resultado: " + resultado);

        } else if (opcao == 3) {
            resultado = num1 * num2;
            System.out.println("Resultado: " + resultado);

        } else if (opcao == 4) {
            if (num2 != 0) {
                resultado = num1 / num2;
                System.out.println("Resultado: " + resultado);
            } else {
                System.out.println("Não é possível dividir por zero!");
            }

        } else {
            System.out.println("Opção inválida!");
        }

        scanner.close();
    }
}
