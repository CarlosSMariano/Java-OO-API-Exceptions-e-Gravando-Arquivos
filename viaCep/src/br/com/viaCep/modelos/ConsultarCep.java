package br.com.viaCep.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ConsultarCep {

    //    Atributos
    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> response;
    private String enderecoApi;

    private Gson gson;
    private EnderecoViaCep enderecoViaCep;
    private Endereco endereco;
    private String json;



    //    Construtor
    public ConsultarCep (String cep){
        if(cep == null || !cep.matches("\\d{8}")){
            throw new IllegalArgumentException("CEP inválido. O CEP deve conter 8 digitos");
        }
        this.enderecoApi = "https://viacep.com.br/ws/"+cep+"/json/";
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public void ViaCep(GerenciadorEnderecos gen){
        try{
            this.client = HttpClient.newHttpClient();
            this.request = HttpRequest.newBuilder()
                    .uri(URI.create(this.enderecoApi))
                    .build();

            this.response = this.client
                    .send(this.request, HttpResponse.BodyHandlers.ofString());

            this.json = this.response.body();

            if(this.json.contains("\"erro\": true")){
                System.out.println("CEP não encontrado ou inválido.");
                return;
            }

            this.enderecoViaCep = this.gson.fromJson(json, EnderecoViaCep.class);
            this.endereco = new Endereco(this.enderecoViaCep);

            gen.adicionarLista(this.endereco);

        } catch (Exception e) {
            System.out.println("Erro ao consultar o CEP: "+ e.getMessage());
        }
    }
}
