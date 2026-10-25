package br.com.vinicius.frete.service;

import br.com.vinicius.frete.dto.CotacaoRequest;
import br.com.vinicius.frete.dto.CotacaoResponse;
import br.com.vinicius.frete.model.Cotacao;
import br.com.vinicius.frete.repository.CotacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreteService {

    // Fator de cubagem rodoviário: 300 kg por metro cúbico
    private static final double FATOR_CUBAGEM = 300;

    private final CotacaoRepository repository;

    public FreteService(CotacaoRepository repository) {
        this.repository = repository;
    }

    public CotacaoResponse cotar(CotacaoRequest pedido) {
        if (pedido.peso() <= 0 || pedido.altura() <= 0 || pedido.largura() <= 0 || pedido.comprimento() <= 0) {
            throw new IllegalArgumentException("Peso e medidas precisam ser maiores que zero");
        }

        double volumeEmM3 = (pedido.altura() * pedido.largura() * pedido.comprimento()) / 1_000_000;
        double pesoCubado = volumeEmM3 * FATOR_CUBAGEM;

        Cotacao cotacao = new Cotacao(pedido.origem(), pedido.destino(), pedido.peso(),
                pedido.altura(), pedido.largura(), pedido.comprimento(), pesoCubado);
        Cotacao salva = repository.save(cotacao);

        return new CotacaoResponse(salva);
    }

    public List<CotacaoResponse> listar() {
        return repository.findAllByOrderByCriadaEmDesc().stream()
                .map(CotacaoResponse::new)
                .toList();
    }
}
