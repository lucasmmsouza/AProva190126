package com.example.prova190126.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tabela_personagens")
public class Personagem {

    @PrimaryKey
    @SerializedName("_id")
    private int id;

    @SerializedName("name")
    private String nome;

    @SerializedName("imageUrl")
    private String urlImagem;

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

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}