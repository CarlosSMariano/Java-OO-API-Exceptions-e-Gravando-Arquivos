package br.com.filme.screenmatch.calculos;

import br.com.filme.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    //    Atributos
    private int tempoTotal;

//    Métodos

    //Sobrecarga de métodos:
//    public void inclui(Filme f){
//        tempoTotal += f.getDuracaoEmMinutos();
//    }
//    public void inclui(Serie s){
//        tempoTotal += s.getDuracaoEmMinutos();
//    }

    // Polimorfismo(Muitas formas): Podendo chamar um objeto de várias fomas.
    public void inclui(Titulo t){
        System.out.println("Adicionando duração em minutos de: "+ t);
        tempoTotal += t.getDuracaoEmMinutos();
    }

    //    Getters and Setters
    public int getTempoTotal(){
        return tempoTotal;
    }


}
