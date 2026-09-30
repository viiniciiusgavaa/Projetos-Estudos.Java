void main() {
    Scanner scan = new Scanner(System.in);
    int quantidade = 0;
    int soma = 0;

    System.out.println("Digite números (0 para parar): ");
    int num = scan.nextInt();

    while (num != 0){
        soma += num;
        quantidade++;
        num = scan.nextInt();
    }

    if (quantidade > 0){
        double media = (double) soma / quantidade;
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Soma: " + soma);
        System.out.printf("Média: %.2f%n", media);
    } else {
        System.out.println("Nenhum número foi digitado");
    }
}
