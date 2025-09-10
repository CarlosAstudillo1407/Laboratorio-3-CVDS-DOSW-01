package edu.dosw.lab.testing;

import edu.dosw.lab.modelo.Banco;
import edu.dosw.lab.modelo.Cuenta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    private Cuenta cuenta;
    private Banco banco;

    @BeforeEach
    void setUp() {
        banco = new Banco("01", "BANCOLOMBIA");
        cuenta = new Cuenta("0123456789", banco);
    }

    @Test
    void testCrearCuenta() {
        assertEquals("0123456789", cuenta.getNumeroCuenta());
        assertEquals(0.0, cuenta.getSaldo());
    }

    @Test
    void testDepositarDinero() {
        cuenta.depositar(100.0);
        assertEquals(100.0, cuenta.getSaldo());
    }

    @Test
    void testDepositarMontoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(-50.0));
    }

    @Test
    void testDepositarMontoCero() {
        assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(0.0));
    }
}
