package com.dio.classes;

public class Pessoa {

    private static  int contador = 1;
    private String nome;
    private String email;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
        contador += 1;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "\nnome='" + this.getNome() +
                "\nemail='" + this.getEmail();
    }
}
