package br.com.vinicius.frete.repository;

import br.com.vinicius.frete.model.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Só a interface: o Spring escreve o SQL de save(), findAll(), findById(), deleteById()...
public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {

    // O Spring entende o nome do método e monta a consulta sozinho
    List<Cotacao> findAllByOrderByCriadaEmDesc();
}
