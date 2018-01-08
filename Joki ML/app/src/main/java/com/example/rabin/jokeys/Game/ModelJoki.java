package com.example.rabin.jokeys.Game;

/**
 * Created by Afan on 24/12/2017.
 */

public class ModelJoki {
    String Nama_Joki,  No_HP;

    public ModelJoki(){};

    public ModelJoki(String nama_Joki,  String no_HP) {
        Nama_Joki = nama_Joki;
        No_HP = no_HP;
    }

    public String getNama_Joki() {
        return Nama_Joki;
    }

    public void setNama_Joki(String nama_Joki) {
        Nama_Joki = nama_Joki;
    }

    public String getNo_HP() {
        return No_HP;
    }

    public void setNo_HP(String no_HP) {
        No_HP = no_HP;
    }
}
