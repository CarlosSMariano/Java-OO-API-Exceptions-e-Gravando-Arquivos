package br.com.viaCep.modelos;

import java.util.ArrayList;
import java.util.List;

public class Endereco {
    //    Atributos
    private String cep;
    private String logradouro;
    private String bairro;
    private String uf;
    private String estado;


    //    Construtor
    public Endereco(EnderecoViaCep viaCep){
        this.cep = viaCep.cep();
        this.logradouro = viaCep.logradouro();
        this.bairro = viaCep.bairro();
        this.uf = viaCep.uf();
        this.estado = viaCep.estado();
    }

    @Override
    public String toString() {
        return """
                Cep: %s
                Logradouro: %s
                Bairro: %s
                Uf: %s
                Estado: %s
                """.formatted(cep, logradouro, bairro, uf, estado);
    }
}
