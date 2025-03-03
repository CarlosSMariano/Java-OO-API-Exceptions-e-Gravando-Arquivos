package br.com.filme.screenmatch.modelos;
/*
* Lançado oficialmente no Java 16, mas disponível desde o Java 14 de maneira experimental,
* o Record é um recurso que permite representar uma classe imutável, contendo apenas atributos,
* construtor e métodos de leitura, de uma maneira muito simples e enxuta.

Esse recurso se encaixa perfeitamente quando precisamos criar um objeto apenas para
* representar dados, sem nenhum tipo de comportamento.

Para se criar uma classe imutável, sem a utilização do Record, era necessário escrever muito código.*/
public record TituloOmdb(String title, String year, String runtime) {

}
