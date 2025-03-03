package br.com.filme.screenmatch.principal;

import br.com.filme.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.filme.screenmatch.modelos.Titulo;
import br.com.filme.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String busca = "";

        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equals("sair")) {
            System.out.println("Digite um filme para busca");
            //inferindo tipo
            busca = scanner.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }
            //.replace substitui
            String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=29b70ce6";
            try {
                //Instância responsável pelas requisições HTTP
                HttpClient client = HttpClient.newHttpClient();

                //Instância HttpRequest.newBuilder() usado para construir o objeto HttpRequest
                HttpRequest request = HttpRequest.newBuilder()
                        //define a URI(Uniform Resource Identifier) da requisição http
                        .uri(URI.create(endereco))
                        //Constrói o objeto HttpRequest com base nas configurações definidas
                        .build();

                //Envia a requisição http usando o HttpClient e recebe a responsta como um objeto HttpResponse<String>
                HttpResponse<String> response = client
                        //O BodyHandlers.ofString() indica que o corpo da resposta será retornado como uma string.
                        .send(request, HttpResponse.BodyHandlers.ofString());
                //Imprime o corpo da resposta http.
                String json = response.body();
                System.out.println(json);

                System.out.println("\nMeu titulo Omdb:");

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);


                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("\nTítulo já convertido:");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro:");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ErroDeConversaoDeAnoException/*Exception*/ e) {
                //classe mãe Exceptiion trata erros de modo plural
                //não indicado usar Exception! tratar erros separados
                System.out.println(e.getMessage());
            }

        }
        System.out.println(titulos);
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println("O programa foi finalizado!");
    }
}
