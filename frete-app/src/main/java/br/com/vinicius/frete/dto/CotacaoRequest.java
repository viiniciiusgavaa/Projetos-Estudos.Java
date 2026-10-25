package br.com.vinicius.frete.dto;

// O que chega da tela. Medidas em centímetros, peso em kg.
public record CotacaoRequest(
        String origem,
        String destino,
        double peso,
        double altura,
        double largura,
        double comprimento
) {
}
