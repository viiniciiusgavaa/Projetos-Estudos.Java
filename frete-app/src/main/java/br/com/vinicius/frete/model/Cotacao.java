package br.com.vinicius.frete.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

// @Entity: cada objeto Cotacao vira uma linha na tabela COTACAO do banco.
@Entity
public class Cotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origem;
    private String destino;
    private double peso;
    private double altura;
    private double largura;
    private double comprimento;
    private double pesoCubado;
    private LocalDateTime criadaEm;

    // O JPA precisa de um construtor vazio para montar o objeto a partir do banco
    protected Cotacao() {
    }

    public Cotacao(String origem, String destino, double peso,
                   double altura, double largura, double comprimento, double pesoCubado) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.pesoCubado = pesoCubado;
        this.criadaEm = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public double getLargura() {
        return largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public double getPesoCubado() {
        return pesoCubado;
    }

    public LocalDateTime getCriadaEm() {
        return criadaEm;
    }
}
