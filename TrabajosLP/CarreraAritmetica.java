import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CarreraAritmetica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.print("Dato(s) de entrada: ");
        double valor = sc.nextDouble();

        int mes;
        do {
            System.out.print("Mes de nacimiento (1-12): ");
            mes = sc.nextInt();
        } while (mes < 1 || mes > 12);

        System.out.println("Entrada: " + valor);

        // Etapa 1: Promedio
        int suma5 = 0;
        for (int i = 0; i < 5; i++) {
            suma5 += rnd.nextInt(100) + 1; // 1 a 100
        }
        double promedio = suma5 / 5.0;
        valor = valor + promedio;
        System.out.println("Salida etapa 1 (entrada + promedio): " + valor);

        // Etapa 2: Residuo
        valor = valor + ((int) valor % 7);
        System.out.println("Salida etapa 2 (entrada + residuo): " + valor);

        // Etapa 3: Porcentaje
        valor = valor + (valor * 0.12);
        System.out.println("Salida etapa 3 (entrada + 12%): " + valor);

        // Etapa 4: Suma de valores enteros
        System.out.print("Cantidad de números a sumar (N)");
        int n = sc.nextInt();

        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.print("Valor " + i + ": ");
            numeros.add(sc.nextInt());
        }

        int sumaN = 0;
        for (int num : numeros) {
            sumaN += num;
        }
        valor = valor + sumaN;
        System.out.println("Salida etapa 4 (entrada + suma de N valores): " + valor);

        // Etapa 5: Divisor (1-9)
        int divisor;
        do {
            System.out.print("Elige un divisor (1-9): ");
            divisor = sc.nextInt();
        } while (divisor < 1 || divisor > 9);
        valor = valor / divisor;
        System.out.println("Salida etapa 5 (entrada / divisor): " + valor);

        // Switch por mes
        switch (mes % 2) {
            case 0: // meses pares: valor entero
                int entero = (int) valor;
                System.out.println("Resultado: " + entero);
                break;
            case 1: // meses nones: 4 decimales
                System.out.printf("Resultado: %.4f%n", valor);
                break;
        }

        sc.close();
    }
}