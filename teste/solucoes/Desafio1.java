import java.util.Scanner;

public class Desafio1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Idade: ");
        int idade = scan.nextInt();

        if (idade < 0) {
            System.out.println("Idade inválida");
        } else if (idade <= 12) {
            System.out.println("Criança");
        } else if (idade <= 17) {
            System.out.println("Adolescente");
        } else if (idade <= 59) {
            System.out.println("Adulto");
        } else {
            System.out.println("Idoso");
        }
    }
}
