package com.example.demo1;

import java.util.Locale;

public class Veiculo {
    private String placa;
    private String modelo;
    private String observacao;
    private String eixos;
    private String litragem;


    public Veiculo(String placa, String modelo, String eixos, String observacao, String litragem){
        this.placa = placa;
        this.modelo = modelo;
        this.eixos = eixos;
        this.observacao = observacao;
        this.litragem = litragem;
    }

    public String getEixos() {
        return eixos;
    }

    public void setEixos(String eixos) {
        this.eixos = eixos;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getLitragem() {
        return litragem;
    }

    public void setLitragem(String litragem) {
        this.litragem = litragem;
    }

    public void mostrarDados(){
        System.out.println("Placa do veículo: "+placa);
        System.out.println("Modelo do veículo: "+modelo);
        System.out.println("Eixos do veículo: "+eixos);
        System.out.println("Capacidade de litragem do veículo: "+litragem);
        System.out.println("Observação do veículo: "+observacao);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");


    }

}
