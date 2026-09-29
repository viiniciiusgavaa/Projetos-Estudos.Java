void main() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Informe um valor: ");
    double val = scan.nextDouble();
    double reajustado = val + (val * 0.05);
    System.out.println("Reajustado: "+reajustado);
}