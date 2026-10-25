# Calculadora de Frete (Spring Boot)

Primeiro projeto completo, do começo ao fim: uma página web onde o cliente preenche
o frete, o Spring Boot calcula o **peso cubado** e salva tudo num banco de dados.

## O caminho de uma cotação (pensando em logística)

```
 Página (index.html)        Controller            Service             Repository           Banco H2
 ───────────────────  →  ───────────────  →  ───────────────  →  ───────────────  →  ──────────
 cliente preenche e       recebe o pedido      confere as regras     guarda e busca       onde tudo
 clica em Calcular        (a portaria)         e faz o cálculo       (o estoque)          fica salvo
                                               (a operação)
```

E a resposta faz o caminho de volta até aparecer na tela. É a "entrega ao cliente final".

## Os arquivos, na ordem em que a cotação passa por eles

| Arquivo | Papel |
|---|---|
| `src/main/resources/static/index.html` | A tela: formulário e tabela de cotações |
| `controller/FreteController.java` | Recebe `POST /api/cotacoes` (calcular) e `GET /api/cotacoes` (listar) |
| `dto/CotacaoRequest.java` | O que chega da tela (como o seu `Scanner`) |
| `service/FreteService.java` | Valida e calcula o peso cubado |
| `model/Cotacao.java` | A cotação como ela fica no banco (`@Entity` = uma tabela) |
| `repository/CotacaoRepository.java` | Salva e busca no banco, sem escrever SQL |
| `dto/CotacaoResponse.java` | O que volta para a tela (como o seu `println`) |
| `resources/application.properties` | Configuração do banco |

**Peso cubado:** `altura × largura × comprimento` (em cm) ÷ 1.000.000 × 300 (fator rodoviário de 300 kg/m³).

## Como rodar

1. No IntelliJ: **File > Open** e escolha a pasta `frete-app` (não a pasta do repositório inteiro).
2. Espere o Maven baixar as dependências.
3. Rode a classe `FreteApplication`.
4. Abra **http://localhost:8080** no navegador.

Para ver o banco por dentro, abra **http://localhost:8080/h2-console**, use
JDBC URL `jdbc:h2:file:./data/frete`, usuário `sa`, senha vazia, e rode `SELECT * FROM COTACAO;`.

## Como aprender com ele: refaça do zero

Crie um projeto novo no [start.spring.io](https://start.spring.io) e refaça em etapas, **digitando**.
Só passe para a próxima etapa quando a anterior rodar.

1. **Controller:** `GET /ola` devolvendo um texto. Abra no navegador.
2. **Request/Response:** `POST /api/cotacoes` recebendo o `CotacaoRequest` e devolvendo o cálculo,
   ainda tudo dentro do Controller. Teste no Postman ou no Insomnia.
3. **Service:** tire o cálculo do Controller e leve para o `FreteService`.
4. **Banco:** adicione as dependências `Spring Data JPA` e `H2`, crie a `Cotacao` (`@Entity`)
   e o `CotacaoRepository`, e salve cada cotação.
5. **Listar:** `GET /api/cotacoes` devolvendo tudo o que foi salvo.
6. **Tela:** coloque o `index.html` em `resources/static`.

Pronto: você fez o ciclo inteiro. Depois disso, para evoluir:
- calcular o **valor** do frete usando o maior entre peso real e peso cubado;
- completar o CRUD com buscar por id, editar (`PUT`) e apagar (`DELETE`);
- validar a entrada com `@Valid` e `@NotBlank`;
- trocar o H2 por PostgreSQL ou MySQL.
