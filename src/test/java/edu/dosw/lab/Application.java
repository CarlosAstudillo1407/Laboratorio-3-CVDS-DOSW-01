package edu.dosw.lab;

import edu.dosw.lab.modelo.Banco;
import edu.dosw.lab.modelo.Cliente;
import edu.dosw.lab.modelo.Cuenta;

import java.util.Scanner;

public class Application {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Crear algunos bancos
        Banco banco1 = new Banco("01", "BANCOLOMBIA");
        Banco banco2 = new Banco("02", "DAVIVIENDA");

        // Crear un cliente
        Cliente cliente = new Cliente("Juan");

        // Interacción con el usuario
        System.out.println("Bienvenido a la aplicación!");
        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();

        // Crear cuenta para el cliente
        Cuenta cuenta = new Cuenta(numeroCuenta, banco1);
        cliente.agregarCuenta(cuenta);

        System.out.println("Cuenta creada exitosamente para " + cliente.getNombre());
        System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Saldo inicial: " + cuenta.getSaldo());

        // Depositar dinero en la cuenta
        System.out.print("Ingrese el monto a depositar: ");
        double monto = scanner.nextDouble();
        cuenta.depositar(monto);

        System.out.println("Nuevo saldo: " + cuenta.getSaldo());

        // Buscar una cuenta
        System.out.print("Ingrese el número de cuenta para buscar: ");
        scanner.nextLine();  // Limpiar el buffer
        String buscarNumeroCuenta = scanner.nextLine();
        if (cliente.buscarCuenta(buscarNumeroCuenta).isPresent()) {
            System.out.println("Cuenta encontrada: " + buscarNumeroCuenta);
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }
}
