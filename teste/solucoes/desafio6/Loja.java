package desafio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Loja {
    public static void main(String[] args) {
        List<Produto> carrinho = new ArrayList<>();
        carrinho.add(new Jogo("Zelda", 300, "Switch"));
        carrinho.add(new Livro("Clean Code", 90, "Robert C. Martin"));
        carrinho.add(new Jogo("FIFA", 250, "PS5"));
        carrinho.add(new Livro("Java Efetivo", 120, "Joshua Bloch"));

        Collections.sort(carrinho);
        System.out.println("Ordenado por preço: " + carrinho);

        double total = 0;
        for (Produto produto : carrinho) {
            total += produto.getPrecoFinal();
            if (produto instanceof Livro livro) {
                System.out.println("Livro de " + livro.getAutor() + ": " + livro.getNome());
            }
        }
        System.out.printf("Total com impostos: R$ %.2f%n", total);
    }
}
