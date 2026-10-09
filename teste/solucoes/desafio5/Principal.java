package desafio5;

public class Principal {
    public static void main(String[] args) {
        Conta corrente = new Conta("Vinicius");
        corrente.depositar(500);

        try {
            corrente.sacar(800);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            corrente.depositar(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        ContaPoupanca poupanca = new ContaPoupanca("Vinicius", 0.01);
        poupanca.depositar(1000);
        poupanca.renderJuros();

        System.out.println(corrente);
        System.out.println(poupanca);
    }
}
