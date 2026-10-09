package desafio6;

public class Livro extends Produto {
    private final String autor;

    public Livro(String nome, double preco, String autor) {
        super(nome, preco);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public double getImposto() {
        return 0; // livros são isentos
    }
}
