import java.util.Scanner;

public class Desafio3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        int somaDiagonal = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = scan.nextInt();
                if (i == j) {
                    somaDiagonal += matriz[i][j];
                }
            }
        }

        for (int[] linha : matriz) {
            for (int num : linha) {
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
        System.out.println("Soma da diagonal principal: " + somaDiagonal);
    }
}
