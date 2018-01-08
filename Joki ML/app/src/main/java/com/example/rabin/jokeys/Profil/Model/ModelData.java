package com.example.rabin.jokeys.Profil.Model;

/**
 * Created by rabin on 04/01/2018.
 */

public class ModelData {
    String id, nama_game, id_game, ranked;

    public ModelData(){}

    public ModelData(String id, String nama_game, String id_game, String ranked) {
        this.id = id;
        this.nama_game = nama_game;
        this.id_game = id_game;
        this.ranked = ranked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_game() {
        return nama_game;
    }

    public void setNama_game(String nama_game) {
        this.nama_game = nama_game;
    }

    public String getId_game() {
        return id_game;
    }

    public void setId_game(String id_game) {
        this.id_game = id_game;
    }

    public String getRanked() {
        return ranked;
    }

    public void setRanked(String ranked) {
        this.ranked = ranked;
    }
}
