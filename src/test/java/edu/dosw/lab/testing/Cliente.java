package edu.dosw.lab.testing;

import edu.dosw.lab.modelo.Banco;
import edu.dosw.lab.modelo.Cliente;
import edu.dosw.lab.modelo.Cuenta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;
    private Banco banco;
    private Cuenta cuenta;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Juan");
        banco = new Banco("01", "BANCOLOMBIA");
        cuenta = new Cuenta("0123456789", banco);
    }

    @Test
    void testCrearCliente() {
        assertEquals("Juan", cliente.getNombre());
    }

    @Test
    void testAgregarCuenta() {
        cliente.agregarCuenta(cuenta);
        assertEquals(1, cliente.getCuentas().size());
        assertEquals("0123456789", cliente.getCuentas().get(0).getNumeroCuenta());
    }

    @Test
    void testBuscarCuentaExistente() {
        cliente.agregarCuenta(cuenta);
        assertTrue(cliente.buscarCuenta("0123456789").isPresent());
    }

    @Test
    void testBuscarCuentaNoExistente() {
        assertFalse(cliente.buscarCuenta("9999999999").isPresent());
    }
}
