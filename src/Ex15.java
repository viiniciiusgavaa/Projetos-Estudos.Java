void main() {
    Scanner scan = new Scanner(System.in);
    double[] notas = new double[5];
    double soma = 0;

    for (int i = 0; i < notas.length; i++){
        System.out.println("Nota " + (i + 1) + ": ");
        notas[i] = scan.nextDouble();
        soma += notas[i];
    }

    double maior = notas[0];
    double menor = notas[0];
    double media = soma / notas.length;
    int acimaDaMedia = 0;

    for (int i = 0; i < notas.length; i++){
        if (notas[i] > maior){
            maior = notas[i];
        }
        if (notas[i] < menor){
            menor = notas[i];
        }
        if (notas[i] > media){
            acimaDaMedia++;
        }
    }

    System.out.println("Maior: " + maior);
    System.out.println("Menor: " + menor);
    System.out.printf("Média: %.2f%n", media);
    System.out.println("Acima da média: " + acimaDaMedia);
}
