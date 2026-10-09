package desafio5;

public class ContaPoupanca extends Conta {
    private final double taxaMensal;

    public ContaPoupanca(String titular, double taxaMensal) {
        super(titular);
        this.taxaMensal = taxaMensal;
    }

    public void renderJuros() {
        depositar(getSaldo() * taxaMensal);
    }

    @Override
    public String toString() {
        return "[Poupança] " + super.toString();
    }
}
