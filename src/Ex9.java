void main() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Peso: ");
    double peso = scan.nextDouble();
    System.out.println("Altura (em m): ");
    double altura = scan.nextDouble();
    double imc = peso / (altura * altura);

    if (imc < 18.5){
        System.out.println("Abaixo do peso");
    }else if (18.6 <= imc && imc <= 24.9){
        System.out.println("Peso ideal (parabéns)");
    }else if(imc >= 25 && imc <= 29.9){
        System.out.println("Levente acima do peso");
    }else if(imc >= 30 && imc <= 34.9){
        System.out.println("Obesidade grau 1");
    }else if(imc >= 35 && imc <= 39.9){
        System.out.println("Obesidade grau 2 (severa)");
    } else{
        System.out.println("Obesidade grau 3 (mórbida)");
    }
}