package br.com.filme.screenmatch.modelos;

import br.com.filme.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel{
    //Atributos
    private  String diretor;

    //Construtor
    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    //Metodos Getters and Setters
    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    //sobrescrevendo Método / implementando
    @Override
    public int getClassificacao() {
//        cast: converter pra outro tipo de dado:
        return (int) obterMedia() / 2 ;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + "(" + this.getAnoDeLancamento() + ")";
    }
}
