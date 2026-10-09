package desafio7;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public Endereco buscar(String cep) throws IOException, InterruptedException {
        String somenteDigitos = cep.replace("-", "").trim();
        if (!somenteDigitos.matches("\\d{8}")) {
            throw new CepInvalidoException("CEP deve ter 8 dígitos: " + cep);
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/" + somenteDigitos + "/json/"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new CepInvalidoException("Erro na consulta (HTTP " + response.statusCode() + ")");
        }

        Endereco endereco = gson.fromJson(response.body(), Endereco.class);
        // ViaCEP responde 200 com {"erro": "true"} quando o CEP não existe
        if (endereco.cep() == null) {
            throw new CepInvalidoException("CEP não encontrado: " + cep);
        }
        return endereco;
    }
}
