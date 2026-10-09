package desafio6;

public class Jogo extends Produto {
    private final String plataforma;

    public Jogo(String nome, double preco, String plataforma) {
        super(nome, preco);
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    @Override
    public double getImposto() {
        return getPreco() * 0.15;
    }
}
