package br.com.viaCep.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorEnderecos {
//    Atributos
    private List<Endereco> enderecos;
    private Gson gson;
    private String caminho;

//    Construtor
    public GerenciadorEnderecos(String caminho){
        this.enderecos = new ArrayList<>();
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        this.caminho = caminho;
    }

    public void adicionarLista(Endereco end){
        this.enderecos.add(end);
        salvarEndereco();
    }

    public void salvarEndereco(){
        try(FileWriter writer = new FileWriter(this.caminho);) {
            gson.toJson(this.enderecos, writer);
            System.out.println("Endereço salvo com sucesso!");
        }catch (IOException e){
            System.out.println("Erro ao salvar arquivo"+ e.getMessage());
        }
    }

}
