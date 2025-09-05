package edu.dosw.lab.Servicios;
import  edu.dosw.lab.modelo.Banco;

import java.util.List;

/**
 * Clase que valida los números de cuenta de acuerdo con las reglas del negocio.
 */
public class ValidadorCuenta {

    /**
     * Valida si un número de cuenta tiene exactamente 10 dígitos numéricos.
     */
    public boolean validarFormato(String numeroCuenta) {
        return numeroCuenta.matches("\\d{10}");
    }

    /**
     * Valida si el número de cuenta corresponde a un banco registrado.
     */
    public boolean validarBanco(String numeroCuenta, List<Banco> bancos) {
        String codigoBanco = numeroCuenta.substring(0, 2);
        return bancos.stream()
                .anyMatch(b -> b.getCodigoBanco().equals(codigoBanco));
    }
}
