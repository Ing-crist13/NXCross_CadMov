package com.example.treinos;

public class User {
    private int id;
    private String nome;
    private int cpf;
    private  int telefone;
    private String email;
    private Character imagem;

    public User(int id, String nome, int cpf, int telefone, String email, Character imagem) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.imagem = imagem;
    }
    public User() {
        this.id = 0;
        this.nome = "";
        this.cpf = 0;
        this.telefone = 0;
        this.email = "";
        this.imagem = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getImagem() {
        return imagem;
    }

    public void setImagem(Character imagem) {
        this.imagem = imagem;
    }
}
