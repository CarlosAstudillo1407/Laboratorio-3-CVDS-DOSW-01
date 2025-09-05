package edu.dosw.lab.Servicios;
import  edu.dosw.lab.modelo.Banco;
import  edu.dosw.lab.modelo.Cliente;
import  edu.dosw.lab.modelo.Cuenta;



import java.util.List;

/**
 * Clase para gestionar operaciones bancarias básicas.
 */
public class GestorCuentas {
    private ValidadorCuenta validador;

    public GestorCuentas(ValidadorCuenta validador) {
        this.validador = validador;
    }

    /**
     * Crea una cuenta para un cliente, validando las reglas de negocio.
     */
    public Cuenta crearCuenta(Cliente cliente, String numeroCuenta, Banco banco, List<Banco> bancos) {
        if (!validador.validarFormato(numeroCuenta)) {
            throw new IllegalArgumentException("Número de cuenta inválido");
        }
        if (!validador.validarBanco(numeroCuenta, bancos)) {
            throw new IllegalArgumentException("Banco no registrado");
        }
        Cuenta cuenta = new Cuenta(numeroCuenta, banco);
        cliente.agregarCuenta(cuenta);
        return cuenta;
    }

    /**
     * Realiza un depósito en una cuenta existente.
     */
    public void depositar(Cliente cliente, String numeroCuenta, double monto) {
        cliente.buscarCuenta(numeroCuenta)
                .ifPresentOrElse(
                        cuenta -> cuenta.depositar(monto),
                        () -> { throw new IllegalArgumentException("Cuenta no encontrada"); }
                );
    }

    /**
     * Consulta el saldo de una cuenta.
     */
    public double consultarSaldo(Cliente cliente, String numeroCuenta) {
        return cliente.buscarCuenta(numeroCuenta)
                .map(Cuenta::getSaldo)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
    }
}
