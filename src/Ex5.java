void main() {
    Scanner scan = new Scanner(System.in);
    double salMin = 1293.20;
    System.out.println("Informe o seu salário: ");
    double sal = scan.nextDouble();
    double result = sal / salMin;
    System.out.println("O seu salário equivale a "+result+" salários mínimos.");

}