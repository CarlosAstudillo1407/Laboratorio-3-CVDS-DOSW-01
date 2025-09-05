package edu.dosw.lab.testing;
import edu.dosw.lab.Servicios.ValidadorCuenta;
import  edu.dosw.lab.modelo.Banco;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorCuentaTest {

    ValidadorCuenta validador = new ValidadorCuenta();
    List<Banco> bancos = Arrays.asList(new Banco("01", "BANCOLOMBIA"),
                                       new Banco("02", "DAVIVIENDA"));

    @Test
    void debeValidarFormatoCorrecto() {
        assertTrue(validador.validarFormato("0123456789"));
    }

    @Test
    void debeRechazarFormatoIncorrecto() {
        assertFalse(validador.validarFormato("01ABC56789"));
    }

    @Test
    void debeValidarBancoRegistrado() {
        assertTrue(validador.validarBanco("0123456789", bancos));
    }

    @Test
    void debeRechazarBancoNoRegistrado() {
        assertFalse(validador.validarBanco("9912345678", bancos));
    }
}
