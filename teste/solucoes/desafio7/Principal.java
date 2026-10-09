package desafio7;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        ConsultaCep consulta = new ConsultaCep();
        List<Endereco> enderecos = new ArrayList<>();

        while (true) {
            System.out.print("Digite um CEP (ou 'sair'): ");
            String entrada = scan.nextLine();
            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                Endereco endereco = consulta.buscar(entrada);
                System.out.println(endereco);
                enderecos.add(endereco);
            } catch (CepInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (IOException | InterruptedException e) {
                System.out.println("Falha de conexão: " + e.getMessage());
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter escrita = new FileWriter("enderecos.json")) {
            escrita.write(gson.toJson(enderecos));
        }
        System.out.println(enderecos.size() + " endereço(s) salvo(s) em enderecos.json");
    }
}
