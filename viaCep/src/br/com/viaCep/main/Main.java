package br.com.viaCep.main;

import br.com.viaCep.modelos.ConsultarCep;
import br.com.viaCep.modelos.GerenciadorEnderecos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cepBusca = "";
        String caminho = "C:\\Users\\AMD\\OneDrive\\Área de Trabalho\\viaCep\\src\\br\\com\\viaCep\\enderecosJson\\enderecos.json";
        GerenciadorEnderecos gen = new GerenciadorEnderecos(caminho);

        while (!cepBusca.equals("sair")) {
            System.out.println("Digite seu CEP:");
            cepBusca = scanner.next();


            if (cepBusca.equalsIgnoreCase("sair")) {
                break;
            }

            try{
                ConsultarCep consultarCep = new ConsultarCep(cepBusca);
                consultarCep.ViaCep(gen);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Programa encerrado.");
    }
}
