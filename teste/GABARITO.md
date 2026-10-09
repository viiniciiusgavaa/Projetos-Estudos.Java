# Gabarito

> Só abra depois de responder a [`PROVA.md`](PROVA.md)!

As respostas das partes 1 a 5 foram conferidas rodando o código no Java 21
(as da parte 3 usando as classes do seu Screenmatch como estão hoje).

---

## Parte 1: Fundamentos

| # | Saída | Por quê |
|---|---|---|
| 1.1 | `3 3.0 3.5` | `7 / 2` é divisão **inteira** (dá 3) mesmo que o resultado vá para um `double`. Basta um operando ser `double` (`7.0`) para a divisão ser decimal. |
| 1.2 | `7 12` | `a++` usa 5 e depois vira 6; `++a` vira 7 e depois usa 7. Logo `b = 5 + 7`. |
| 1.3 | `3345` | Da esquerda para a direita: `1 + 2 = 3` (números). Depois de encontrar uma `String`, tudo vira concatenação: `"3" + "3" + "4" + "5"`. |
| 1.4 | `9 3.5 3.0` | O cast **trunca** (não arredonda). `(double) 7 / 2`: o cast vem antes da divisão, então é `7.0 / 2`. `(double) (7 / 2)`: divide inteiro primeiro (3) e só depois converte. |
| 1.5 | `-128` | `byte` vai de -128 a 127. Passou do limite, "dá a volta" (*overflow*). |
| 1.6 | `B` | `x < 5` é falso, então o `&&` inteiro é falso. No segundo, `x >= 5` é verdadeiro e o `\|\|` já basta. |
| 1.7 | `BC` | Sem `break` no `case 2`, a execução "cai" para o `case 3` (*fall-through*) até achar o `break`. |

## Parte 2: Laços e arrays

| # | Resposta | Por quê |
|---|---|---|
| 2.1 | `0 3 6 9` | O incremento é de 3 em 3; 12 já não é `< 10`. |
| 2.2 | `10` | O `do-while` executa o bloco **uma vez antes** de testar a condição. |
| 2.3 | **110 linhas** | 10 voltas do `while`, e cada uma imprime 1 linha mais 10 do `for`: 10 × 11 = 110. |
| 2.4 | `7` | i=1 soma, i=2 soma, i=3 pula (`continue`), i=4 soma, i=5 sai (`break`): 1 + 2 + 4. |
| 2.5 | `9` | Array de `int` começa com zeros: `0 + 5 + 4`. Tudo é `int`, então é soma, não concatenação. |
| 2.6 | `3 3 6` | `m.length` é o número de linhas; `m[1]` tem 3 elementos; `m[2][0]` é 6. Linhas de tamanhos diferentes são permitidas (é o que você fez no `Ex20`). |
| 2.7 | `ArrayIndexOutOfBoundsException` | Índices válidos vão de 0 a `length - 1`, ou seja, de 0 a 3. |

## Parte 3: Orientação a objetos

**3.1** `7.95 3`. A média é (8,9 + 7) / 2 = 7,95. Classificação: `(int) 7.95` = 7, e `7 / 2` = 3 (divisão inteira).

**3.2** O **cast vem primeiro**, porque tem precedência maior que a divisão. Então `(int) 9.8` = 9, e `9 / 2` = **4** (divisão inteira).
Para arredondar: `return (int) Math.round(pegaMedia() / 2);`. Assim 9,8 / 2 = 4,9, que arredonda para 5.

**3.3** `NaN 0`. Sem avaliações, a conta é `0.0 / 0`. Com `double` isso **não** lança exceção, dá `NaN` ("not a number").
E `(int) NaN` vira 0. Se fosse divisão de `int` por zero, aí sim daria `ArithmeticException`.

**3.4** `900` (2 × 10 × 45). `Serie` **sobrescreve** (`@Override`) o `getDuracaoEmMinutos()`, então o atributo
`duracaoEmMinutos` herdado de `Titulo` nunca é lido. O conceito é **sobrescrita de método**, que gera **polimorfismo**.

**3.5** `Filme: Avatar 2009`. O método executado depende do **objeto real** (um `Filme`), não do tipo da variável (`Titulo`).
Isso é polimorfismo, também chamado de *dynamic dispatch*.
Dica: coloque `@Override` em cima do `toString()` de `Filme`. Se você errar o nome do método, o compilador avisa.

**3.6** Algo como `br.com.alura.screenmatch.modelos.Serie@1b6d3586`. Nem `Serie` nem `Titulo` sobrescrevem `toString()`,
então vale o de `Object`: nome da classe + `@` + hash.

**3.7** `Titulo` só tem um construtor, e ele exige `(String, int)`. Toda classe filha precisa chamar um construtor do pai.
Se você não escrever `super(...)`, o Java tenta chamar `super()` sem argumentos, que não existe, e o código **não compila**.

**3.8** Porque `filtra` recebe um `Classificavel`, e `Episodio implements Classificavel`. O método só depende do "contrato"
(`getClassificacao()`), não da hierarquia da classe.
`new Episodio()` tem 0 visualizações, então a classificação é 2 e aparece **`Muito bem avaliado`**.

**3.9** `extends` herda estado (atributos) e comportamento. Uma classe só pode ter **um** `extends`.
Uma `interface` define um contrato do que a classe deve saber fazer, e uma classe pode ter **vários** `implements`
(`Filme extends Titulo implements Classificavel` usa os dois).

**3.10** **Encapsulamento**. Você controla como os dados mudam. Por exemplo, `avalia()` atualiza a soma **e** o total juntos.
Ninguém de fora consegue deixar `totalAvaliacoes` inconsistente, e dá para validar valores no setter.

**3.11** `==` compara se é **o mesmo objeto** na memória. `.equals()` compara o **conteúdo**.
Para texto, use sempre `.equals()` (ou `.equalsIgnoreCase()`).

## Parte 4: Coleções

**4.1** `[Filme: Batman 1989, Filme: Zorro 1998, Filme: avatar 2009]`. O `compareTo` de `String` compara pelos códigos
dos caracteres, e **todas as maiúsculas vêm antes das minúsculas** ('Z' = 90, 'a' = 97).
Para ignorar maiúsculas: `this.getNome().compareToIgnoreCase(outro.getNome())`.

**4.2** **Não compila**. O `Collections.sort(lista)` exige que os elementos sejam `Comparable`.
A alternativa é passar um critério: `lista.sort(Comparator.comparing(Titulo::getNome))`.

**4.3** É *pattern matching* do `instanceof`. Ele testa se `item` é um `Filme` e, se for, já cria a variável `filme` do tipo `Filme`.
`getClassificacao()` não existe em `Titulo`, só em `Filme`, então pela variável `Titulo item` o compilador não deixa chamar.

**4.4** Programar para a **interface**. Se depois você quiser trocar para `LinkedList`, só muda o lado direito,
e os métodos que recebem `List` aceitam qualquer implementação.

**4.5** Exemplos de diferenças:
- Array tem **tamanho fixo**; `ArrayList` cresce sozinho (`add`).
- Array aceita primitivos (`int[]`); `ArrayList` só objetos (`Integer`, com *autoboxing*).
- Array usa `.length` e `v[i]`; `ArrayList` usa `.size()` e `get(i)`.
- `ArrayList` tem métodos prontos (`remove`, `contains`, `sort`...).

## Parte 5: Exceções, records e API

**5.1** `a c d`. A exceção acontece antes do `"b "`. O `catch` trata, e o `finally` **sempre** roda.

**5.2** `substring(0, 3)` vira `"136"`, e o `parseInt` devolve `136`.
`substring(0, 4)` vira `"136 "` (com espaço), e o `parseInt` lança **`NumberFormatException`**.
É exatamente o tipo de erro que aparece no curso com o `Runtime` do OMDb. Por isso vale tratar com `try/catch`.

**5.3** `Endereco[cep=01001-000, logradouro=Praça da Sé, localidade=São Paulo, uf=SP]`.
O `toString()` do record é gerado automaticamente. Campos do JSON que não existem no record (`bairro`) são **ignorados** pelo Gson.

**5.4** Retorna `null`, porque o JSON não tem a chave `cep`, então todos os campos ficam `null`.
Detecte com `if (endereco.cep() == null)` e lance sua exceção. Como o status é 200, olhar só o `statusCode()` não basta.

**5.5** `null | Matrix`. O Gson procura chaves com o **mesmo nome** do campo (`title`), mas o JSON tem `Title`.
A política `UPPER_CAMEL_CASE` faz `title` procurar `Title`. A outra saída é usar `@SerializedName("Title")` no campo.

**5.6** **b, d, a, c**. Primeiro o cliente, depois a requisição, depois envia e por último lê o corpo.

**5.7** `IOException` e `InterruptedException` são exceções **checked**: o compilador obriga você a tratar (`try/catch`)
ou declarar (`throws`). `NumberFormatException` herda de `RuntimeException`, então é **unchecked** e o compilador não obriga.

**5.8** É o *try-with-resources*. Ele fecha o arquivo **automaticamente**, mesmo se der exceção no meio.
Se você esquecer o `close()`, ou der erro antes dele, o conteúdo pode nem ser gravado no arquivo.

**5.9** Algumas vantagens:
- Uma linha substitui construtor, getters, `toString`, `equals` e `hashCode`.
- É **imutável** (campos `final`), o que é perfeito para representar dados que vieram de uma API.
- Fica claro que a classe só carrega dados.

## Parte 6: Caça ao bug

**6.1** Nos dois casos aparece **`Obesidade grau 3 (mórbida)`**. Existem "buracos" entre as faixas:
18,5 a 18,6, 24,9 a 25, 29,9 a 30 e assim por diante. Esses valores não entram em nenhum `if` e caem no `else`.
Correção: como os `else if` são testados em ordem, use só o limite superior:
```java
if (imc < 18.5) { ... }
else if (imc < 25) { ... }   // peso ideal
else if (imc < 30) { ... }
else if (imc < 35) { ... }
else if (imc < 40) { ... }
else { ... }
```

**6.2** Imprime `1 5 5`, mas o certo seria `5 5 1`. Com números **iguais**, `a3 > a2` e `a2 > a3` são os dois falsos.
O código cai no último `else`, que assume que `a1` é o maior.
Correção: use `>=` nas comparações. Ou, mais simples, coloque em um array e use `Arrays.sort`.

**6.3** Aparece `Nao temos muitas avaliacoes ainda`. A média é `NaN`, que vira classificação 0.
Correção em `pegaMedia()`:
```java
if (totalAvaliacoes == 0) {
    return 0;
}
return somaAvaliacao / totalAvaliacoes;
```

**6.4** `i <= notas.length` roda com `i = 5`, e `notas[5]` lança `ArrayIndexOutOfBoundsException`. O certo é `i < notas.length`.

## Parte 7: Desafios

Soluções de referência (todas compilam e foram testadas) estão em [`solucoes/`](solucoes/):

| Desafio | Arquivo(s) |
|---|---|
| 1. Faixa etária | `solucoes/Desafio1.java` |
| 2. Número primo | `solucoes/Desafio2.java` |
| 3. Matriz 3x3 | `solucoes/Desafio3.java` |
| 4. Calculadora 2.0 | `solucoes/Desafio4.java` |
| 5. Conta bancária | `solucoes/desafio5/` |
| 6. Loja | `solucoes/desafio6/` |
| 7. Buscador de CEP | `solucoes/desafio7/` (precisa do `gson.jar` no classpath, igual no Screenmatch) |

Critério de correção para cada desafio (3 pontos):
- **1 ponto**: compila e funciona no caso normal.
- **1 ponto**: trata os casos de borda pedidos (limites, entrada inválida, divisão por zero, CEP inexistente...).
- **1 ponto**: código organizado, com nomes claros, sem repetição desnecessária e usando o recurso pedido
  (`switch`, `private`, `abstract`, `record`...).

Sua solução não precisa ficar igual à de referência. Se funciona e cumpre os critérios, vale ponto.
