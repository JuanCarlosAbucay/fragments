package com.example.correo;

public class Correo {
    String de;
    String asunto;
    String texto;

    public Correo(String de, String asunto, String texto){
        this.de = de;
        this.asunto = asunto;
    }

    public String getDe() {
        return de;
    }

    public String getAsunto() {
        return asunto;
    }
}
