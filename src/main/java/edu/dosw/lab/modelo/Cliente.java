package edu.dosw.lab.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Cliente {
    private String nombre;
    private List<Cuenta> cuentas;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.cuentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public Optional<Cuenta> buscarCuenta(String numeroCuenta) {
        return cuentas.stream()
                .filter(c -> c.getNumeroCuenta().equals(numeroCuenta))
                .findFirst();
    }
}
