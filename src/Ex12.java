void main() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Digite um número: ");
    int n = scan.nextInt();
    int pares = 0;
    int impares = 0;

    for (int i = 1; i <= n; i++){
        if (i % 2 == 0){
            System.out.println(i + " - par");
            pares++;
        } else {
            System.out.println(i + " - ímpar");
            impares++;
        }
    }

    System.out.println("Pares: " + pares + " | Ímpares: " + impares);
}
