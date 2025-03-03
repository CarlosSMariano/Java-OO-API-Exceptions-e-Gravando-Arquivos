package br.com.filme.screenmatch.modelos;

public class Serie extends Titulo {
    //Atributos
    private int temporadas;
    private int episodioPorTemporada;
    private boolean ativa;
    private int minutosPorEpisodio;

    //    Construtor
    public Serie(String nome, int anoDeLancamento){
        super(nome, anoDeLancamento);
    }
//    Métodos


    @Override
    public String toString() {
        return "Série: " + this.getNome()  + "(" + this.getAnoDeLancamento() + ")";
    }

    // Sobrescrevendo um métodos da classe pai
    @Override //A anotação @Override possibilita a sobrescrita de um métodos
    public int getDuracaoEmMinutos() {
        return temporadas * episodioPorTemporada * minutosPorEpisodio;
    }

    //Metodos Getters and Setters
    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodioPorTemporada() {
        return episodioPorTemporada;
    }

    public void setEpisodioPorTemporada(int episodioPorTemporada) {
        this.episodioPorTemporada = episodioPorTemporada;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }
}
