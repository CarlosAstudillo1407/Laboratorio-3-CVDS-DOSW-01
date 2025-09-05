package edu.dosw.lab.modelo;

public class Banco {
    private String codigoBanco; // Ej: "01"
    private String nombreBanco; // Ej: "BANCOLOMBIA"

    public Banco(String codigoBanco, String nombreBanco) {
        this.codigoBanco = codigoBanco;
        this.nombreBanco = nombreBanco;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }
}
