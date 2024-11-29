package com.example.treinos;

public class Movimento {
    private int id;
    private String nome;
    private  String tipo;
    private String descricao;
    private String video;




    public Movimento(int id, String nome, String tipo, String descricao, String video) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.video = video;

    }

    public Movimento(){
        this.id = 0;
        this.nome = "";
        this.tipo = "";
        this.descricao = "";
        this.video = "";
    }
    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
