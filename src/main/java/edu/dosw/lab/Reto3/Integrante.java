package edu.dosw.lab.Reto3;
import java.util.Scanner;

public class Integrante {
    private String nombre;
    private EstrategiaVotacion estrategiaVotacion;

    public Integrante(String nombre, EstrategiaVotacion estrategiaVotacion) {
        this.nombre = nombre;
        this.estrategiaVotacion = estrategiaVotacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int votar(Scanner scanner) {
        return estrategiaVotacion.votar(scanner);
    }
}
