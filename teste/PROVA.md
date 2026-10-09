# Prova de Java: o que eu já aprendi

Prova montada a partir dos exercícios deste repositório (`src/Ex*.java`, `Calculadora.java`),
do projeto **Screenmatch** e da parte de consumo de API (OMDb / ViaCEP).

**Regras:**
- Responda as partes 1 a 6 **sem rodar o código**. Depois confira no [`GABARITO.md`](GABARITO.md).
- Na parte 7, programe de verdade. Só olhe a pasta [`solucoes/`](solucoes/) depois de terminar.
- Pontuação: partes 1 a 6 valem 1 ponto por questão (43 pontos). Os desafios da parte 7 valem 3 pontos cada (21 pontos). **Total: 64.**

| Nota | Nível |
|---|---|
| 58 a 64 | Mandou muito bem, pode avançar |
| 45 a 57 | Base sólida, revise o que errou |
| 32 a 44 | Vale refazer os exercícios dos tópicos que errou |
| menos de 32 | Volte nos fundamentos antes de seguir |

---

## Parte 1: Fundamentos (o que é impresso?)

**1.1**
```java
int x = 7 / 2;
double y = 7 / 2;
double z = 7.0 / 2;
System.out.println(x + " " + y + " " + z);
```

**1.2**
```java
int a = 5;
int b = a++ + ++a;
System.out.println(a + " " + b);
```

**1.3**
```java
System.out.println(1 + 2 + "3" + 4 + 5);
```

**1.4**
```java
System.out.println((int) 9.99 + " " + (double) 7 / 2 + " " + (double) (7 / 2));
```

**1.5** (lembra do `byte dia` no `Ex17`?)
```java
byte b = 127;
b++;
System.out.println(b);
```

**1.6**
```java
int x = 5;
if (x > 3 && x < 5) {
    System.out.println("A");
} else if (x >= 5 || x == 0) {
    System.out.println("B");
} else {
    System.out.println("C");
}
```

**1.7**
```java
int dia = 2;
switch (dia) {
    case 1: System.out.print("A");
    case 2: System.out.print("B");
    case 3: System.out.print("C"); break;
    default: System.out.print("D");
}
```

---

## Parte 2: Laços e arrays

**2.1**
```java
for (int i = 0; i < 10; i += 3) {
    System.out.print(i + " ");
}
```

**2.2**
```java
int n = 10;
do {
    System.out.print(n + " ");
    n++;
} while (n < 5);
```

**2.3** Quantas linhas o `Ex18.java` imprime no total?
```java
int count = 0;
while (count < 10) {
    System.out.println(++count);
    for (int i = 0; i < 10; i++) {
        System.out.println("For" + i);
    }
}
```

**2.4**
```java
int total = 0;
for (int i = 1; i <= 5; i++) {
    if (i == 3) continue;
    if (i == 5) break;
    total += i;
}
System.out.println(total);
```

**2.5**
```java
int[] v = new int[4];
v[1] = 5;
System.out.println(v[0] + v[1] + v.length);
```

**2.6**
```java
int[][] m = {{1, 2}, {3, 4, 5}, {6}};
System.out.println(m.length + " " + m[1].length + " " + m[2][0]);
```

**2.7** O que acontece ao executar `System.out.println(v[4]);` com o `v` da questão 2.5?

---

## Parte 3: Orientação a objetos (classes do Screenmatch)

Use as classes `Titulo`, `Filme`, `Serie`, `Episodio`, `Classificavel` e `CalculadoraDeTempo`
exatamente como estão no seu repositório Screenmatch.

**3.1**
```java
Filme f = new Filme("Matrix", 1999);
f.avalia(8.9);
f.avalia(7);
System.out.println(f.pegaMedia() + " " + f.getClassificacao());
```

**3.2** Em `Filme.getClassificacao()` está escrito `return (int) pegaMedia() / 2;`.
O que acontece primeiro: o cast `(int)` ou a divisão? Com média 9,8, qual é a classificação?
Se a ideia fosse **arredondar** (9,8 vira 5 estrelas), como você escreveria?

**3.3**
```java
Filme v = new Filme("Vingadores", 2012);   // nenhuma avaliação
System.out.println(v.pegaMedia() + " " + v.getClassificacao());
```

**3.4**
```java
Serie s = new Serie("Lost", 2004);
s.setDuracaoEmMinutos(999);
s.setTemporadas(2);
s.setEpisodiosPorTemporada(10);
s.setMinutosPorEpisodio(45);
System.out.println(s.getDuracaoEmMinutos());
```
Por que o `999` foi ignorado? Como se chama esse conceito?

**3.5**
```java
Titulo t = new Filme("Avatar", 2009);
System.out.println(t);
```
Qual `toString()` é chamado, o de `Titulo` ou o de `Filme`? Por quê, se a variável é do tipo `Titulo`?

**3.6** E se fosse `Titulo t2 = new Serie("Dark", 2017); System.out.println(t2);`, o que apareceria?

**3.7** Por que o construtor de `Filme` precisa chamar `super(nome, anoDeLancamento)`?
O que acontece se você apagar essa linha?

**3.8** `Episodio` não herda de `Titulo`, mas pode ser passado para `FiltroRecomendacao.filtra(...)`. Por quê?
O que imprime `filtro.filtra(new Episodio())`?

**3.9** Qual a diferença entre uma `interface` (como `Classificavel`) e uma classe que você herda com `extends` (como `Titulo`)?
Uma classe pode ter dois `extends`? E dois `implements`?

**3.10** Por que os atributos de `Titulo` são `private`, e o acesso é feito por getters e setters?
Qual o nome desse princípio?

**3.11** Qual a diferença entre o `==` e o `.equals()` para comparar duas `String`?

---

## Parte 4: Coleções

**4.1**
```java
List<Titulo> lista = new ArrayList<>();
lista.add(new Filme("avatar", 2009));
lista.add(new Filme("Zorro", 1998));
lista.add(new Filme("Batman", 1989));
Collections.sort(lista);
System.out.println(lista);
```
Por que o `"avatar"` foi para o final?

**4.2** O que acontece se você tirar o `implements Comparable<Titulo>` de `Titulo` e mantiver o `Collections.sort(lista)`?

**4.3** No `PrincipalComListas`, o que faz `if (item instanceof Filme filme && filme.getClassificacao() > 2)`?
Por que não dá para chamar `item.getClassificacao()` direto?

**4.4** Por que declarar `List<Titulo> lista = new ArrayList<>()` em vez de `ArrayList<Titulo> lista = new ArrayList<>()`?

**4.5** Array (`int[]`) ou `ArrayList<Integer>`: cite duas diferenças.

---

## Parte 5: Exceções, records e consumo de API

**5.1**
```java
try {
    System.out.print("a ");
    int r = 1 / 0;
    System.out.print("b ");
} catch (ArithmeticException e) {
    System.out.print("c ");
} finally {
    System.out.println("d");
}
```

**5.2** A API do OMDb retorna `"Runtime": "136 min"`. O que acontece com cada linha?
```java
Integer.parseInt("136 min".substring(0, 3));
Integer.parseInt("136 min".substring(0, 4));
```

**5.3**
```java
record Endereco(String cep, String logradouro, String localidade, String uf) {}

Endereco e = new Gson().fromJson(
    "{\"cep\":\"01001-000\",\"logradouro\":\"Praça da Sé\",\"bairro\":\"Sé\",\"localidade\":\"São Paulo\",\"uf\":\"SP\"}",
    Endereco.class);
System.out.println(e);
```
O que é impresso? O que acontece com o campo `bairro`, que existe no JSON mas não no record?

**5.4** O ViaCEP responde **status 200** com o corpo `{"erro": "true"}` quando o CEP não existe.
O que retorna `endereco.cep()` nesse caso? Como o seu programa deve detectar isso?

**5.5**
```java
record TituloOmdb(String title, String year) {}
String json = "{\"Title\":\"Matrix\",\"Year\":\"1999\"}";

TituloOmdb t1 = new Gson().fromJson(json, TituloOmdb.class);
TituloOmdb t2 = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .create()
        .fromJson(json, TituloOmdb.class);

System.out.println(t1.title() + " | " + t2.title());
```

**5.6** Coloque na ordem certa para fazer uma requisição GET e ler o corpo como `String`:
- (a) `HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());`
- (b) `HttpClient client = HttpClient.newHttpClient();`
- (c) `String json = response.body();`
- (d) `HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();`

**5.7** `client.send(...)` obriga você a tratar `IOException` e `InterruptedException`, mas `Integer.parseInt` não obriga
a tratar `NumberFormatException`. Qual a diferença entre esses dois tipos de exceção?

**5.8** Por que usar `try (FileWriter escrita = new FileWriter("filmes.json")) { ... }` em vez de
abrir o `FileWriter` e chamar `close()` no final?

**5.9** Cite duas vantagens de um `record` sobre uma classe comum com atributos, construtor, getters e `toString()`.

---

## Parte 6: Caça ao bug (no seu próprio código)

**6.1** No `Ex9.java` (IMC), qual mensagem aparece para quem tem IMC **18,55**? E **24,95**? Qual é o erro e como corrigir?

**6.2** No `Ex8.java` (ordenar 3 números), digite `1 5 5`. O que é impresso? Por que está errado e como corrigir?

**6.3** No `Principal` do Screenmatch, o filme `"Vingadores"` nunca é avaliado. Se você chamar
`filtro.filtra(newFilme2)`, o que aparece? Como deixar `pegaMedia()` seguro?

**6.4** O que está errado neste trecho?
```java
double[] notas = new double[5];
for (int i = 0; i <= notas.length; i++) {
    notas[i] = scan.nextDouble();
}
```

---

## Parte 7: Desafios práticos (3 pontos cada)

Crie os arquivos em uma pasta sua (por exemplo `src/desafios/`).

### Desafio 1: Faixa etária (if/else)
Leia uma idade e imprima `Criança` (0 a 12), `Adolescente` (13 a 17), `Adulto` (18 a 59) ou `Idoso` (60 ou mais).
Idade negativa: `Idade inválida`. Teste exatamente os limites: -1, 12, 13, 17, 18, 59, 60.

### Desafio 2: Número primo (laços)
Leia um número e diga se é primo. Teste com 0, 1, 2, 9, 17, 25, 97.
Bônus: pare o laço assim que achar um divisor.

### Desafio 3: Matriz 3x3 (arrays 2D)
Leia uma matriz 3x3, imprima-a alinhada (use `printf("%4d", ...)`) e mostre a soma da diagonal principal.
Com a entrada `1 2 3 4 5 6 7 8 9`, a soma deve ser 15.

### Desafio 4: Calculadora 2.0 (do-while + switch)
Melhore sua `Calculadora.java`: o menu deve repetir até o usuário digitar `0`, usando `switch`.
Mantenha a proteção contra divisão por zero e trate opção inválida.

### Desafio 5: Conta bancária (encapsulamento, herança, exceções)
- `Conta` com `titular` e `saldo` **privados**, `depositar(valor)` e `sacar(valor)`.
- Valor menor ou igual a zero: lance `IllegalArgumentException`.
- Saque maior que o saldo: lance uma exceção sua, `SaldoInsuficienteException`.
- `ContaPoupanca extends Conta` com `renderJuros()` (ex.: 1% ao mês).
- Sobrescreva `toString()` e trate as exceções no `main` com `try/catch`.

### Desafio 6: Loja (classe abstrata, interface, polimorfismo, Comparable)
- Interface `Tributavel` com `double getImposto()`.
- Classe **abstrata** `Produto` (nome, preço) que implementa `Comparable<Produto>` (ordena por preço) e `Tributavel`.
- `Livro` (tem autor, imposto zero) e `Jogo` (tem plataforma, imposto de 15%).
- Coloque 4 produtos em um `List<Produto>`, ordene, imprima, mostre o autor só dos livros (`instanceof`)
  e o total com impostos.
  Com Zelda (300), Clean Code (90), FIFA (250) e Java Efetivo (120), o total é **R$ 842,50**.

### Desafio 7: Buscador de CEP (API + JSON + arquivo)
Use a API `https://viacep.com.br/ws/{cep}/json/` e a biblioteca Gson.
- Leia CEPs do teclado até o usuário digitar `sair`.
- Valide o formato (8 dígitos, aceitando hífen); se inválido, lance `CepInvalidoException`.
- Converta a resposta em um `record Endereco`.
- Trate o caso `{"erro": "true"}` (CEP inexistente) e falhas de conexão sem derrubar o programa.
- No final, salve todos os endereços em `enderecos.json` com `setPrettyPrinting()`.
