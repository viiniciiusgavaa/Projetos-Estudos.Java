package br.com.vinicius.frete.controller;

import br.com.vinicius.frete.dto.CotacaoRequest;
import br.com.vinicius.frete.dto.CotacaoResponse;
import br.com.vinicius.frete.service.FreteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cotacoes")
public class FreteController {

    private final FreteService service;

    public FreteController(FreteService service) {
        this.service = service;
    }

    // POST /api/cotacoes -> calcula, salva no banco e devolve a cotação
    @PostMapping
    public CotacaoResponse cotar(@RequestBody CotacaoRequest pedido) {
        return service.cotar(pedido);
    }

    // GET /api/cotacoes -> lista as cotações salvas, da mais nova para a mais antiga
    @GetMapping
    public List<CotacaoResponse> listar() {
        return service.listar();
    }

    // Se o Service recusar o pedido, devolve 400 com a mensagem em vez de erro 500
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> tratarErro(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
