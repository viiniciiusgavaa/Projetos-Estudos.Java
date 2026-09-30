void main() {
    Scanner scan = new Scanner(System.in);
    int secreto = new Random().nextInt(100) + 1;
    int chute;
    int tentativas = 0;

    do {
        System.out.println("Chute um número de 1 a 100: ");
        chute = scan.nextInt();
        tentativas++;

        if (chute < secreto){
            System.out.println("Maior!");
        } else if (chute > secreto){
            System.out.println("Menor!");
        }
    } while (chute != secreto);

    System.out.println("Acertou em " + tentativas + " tentativas!");
}
