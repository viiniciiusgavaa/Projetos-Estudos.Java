void main() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Digite um número: ");
    int n = scan.nextInt();

    if (n < 0){
        System.out.println("Número inválido");
    } else if (n == 0){
        System.out.println("0! = 1");
    } else {
        long fatorial = 1;
        String conta = "";

        for (int i = n; i >= 1; i--){
            fatorial *= i;
            conta += i;
            if (i > 1){
                conta += " x ";
            }
        }

        System.out.println(conta + " = " + fatorial);
    }
}
