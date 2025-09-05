package edu.dosw.lab.Reto3;
import java.util.Scanner;

public class EstrategiaFibonacci implements EstrategiaVotacion {

    @Override
    public int votar(Scanner scanner) {
        System.out.print("Vota usando la secuencia Fibonacci (1, 2, 3, 5, 8, 13): ");
        int voto = scanner.nextInt();

        
        while (voto != 1 && voto != 2 && voto != 3 && voto != 5 && voto != 8 && voto != 13) {
            System.out.print("Voto inválido. Vota nuevamente: ");
            voto = scanner.nextInt();
        }

        return voto;
    }
}
