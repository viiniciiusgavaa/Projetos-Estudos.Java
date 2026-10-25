package br.com.vinicius.frete.dto;

import br.com.vinicius.frete.model.Cotacao;

import java.time.LocalDateTime;

// O que volta para a tela.
public record CotacaoResponse(
        Long id,
        String origem,
        String destino,
        double peso,
        double pesoCubado,
        LocalDateTime criadaEm
) {
    public CotacaoResponse(Cotacao cotacao) {
        this(cotacao.getId(), cotacao.getOrigem(), cotacao.getDestino(),
                cotacao.getPeso(), cotacao.getPesoCubado(), cotacao.getCriadaEm());
    }
}
