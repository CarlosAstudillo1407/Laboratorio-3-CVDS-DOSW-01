package edu.dosw.lab.modelo;

public class Cuenta {
    private String numeroCuenta; // Debe tener 10 dígitos
    private double saldo;
    private Banco banco;

    public Cuenta(String numeroCuenta, Banco banco) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0.0;
        this.banco = banco;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        this.saldo += monto;
    }
}