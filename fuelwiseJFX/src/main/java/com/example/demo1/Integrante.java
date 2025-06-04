package com.example.demo1;

import java.util.Locale;

public class Integrante {
    private String email;
    private String nome;
    private String senha;
    private String telefone;
    private String cpf;


    public Integrante(String email, String nome, String senha, String telefone, String cpf){
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void mostrarDados(){
        System.out.println("Email: "+email);
        System.out.println("Nome: "+nome);
        System.out.println("Senha: "+senha);
        System.out.println("Telefone: "+telefone);
        System.out.println("CPF: "+cpf);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");


    }

}
