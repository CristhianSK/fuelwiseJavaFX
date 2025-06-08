package com.example.demo1;

public class Veiculo {
    private String placa;
    private String modelo;
    private String observacao;
    private String anoFabricacao;
    private String fabricante;


    public Veiculo(String placa, String modelo, String anoFabricacao, String observacao, String fabricante){
        this.placa = placa;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.observacao = observacao;
        this.fabricante = fabricante;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
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
    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String litragem) {
        this.fabricante = litragem;
    }

    public void mostrarDados(){
        System.out.println("Placa do veículo: "+placa);
        System.out.println("Modelo do veículo: "+modelo);
        System.out.println("Ano de Fabricação do veículo: "+ anoFabricacao);
        System.out.println("Fabricante do veículo: "+fabricante);
        System.out.println("Observação do veículo: "+observacao);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");


    }

}
