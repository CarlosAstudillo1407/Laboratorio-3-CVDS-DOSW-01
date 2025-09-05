package edu.dosw.lab.testing;
import edu.dosw.lab.Servicios.ValidadorCuenta;
import edu.dosw.lab.Servicios.GestorCuentas;
import  edu.dosw.lab.modelo.Cliente;
import  edu.dosw.lab.modelo.Cuenta;
import  edu.dosw.lab.modelo.Banco;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class GestorCuentasTest {

    Cliente cliente;
    GestorCuentas gestor;
    List<Banco> bancos;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Juan");
        bancos = Arrays.asList(new Banco("01", "BANCOLOMBIA"), new Banco("02", "DAVIVIENDA"));
        gestor = new GestorCuentas(new ValidadorCuenta());
    }

    @Test
    void debeCrearCuentaValida() {
        Cuenta cuenta = gestor.crearCuenta(cliente, "0123456789", bancos.get(0), bancos);
        assertEquals("0123456789", cuenta.getNumeroCuenta());
        assertEquals(0.0, cuenta.getSaldo());
    }

    @Test
    void debeDepositarEnCuenta() {
        gestor.crearCuenta(cliente, "0123456789", bancos.get(0), bancos);
        gestor.depositar(cliente, "0123456789", 500);
        assertEquals(500, gestor.consultarSaldo(cliente, "0123456789"));
    }

    @Test
    void debeLanzarErrorSiCuentaNoExiste() {
        assertThrows(IllegalArgumentException.class,
                () -> gestor.depositar(cliente, "9999999999", 200));
    }
}