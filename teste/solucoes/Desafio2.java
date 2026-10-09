import java.util.Scanner;

public class Desafio2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Número: ");
        int n = scan.nextInt();

        boolean primo = n >= 2;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                primo = false;
                break;
            }
        }

        System.out.println(n + (primo ? " é primo" : " não é primo"));
    }
}
