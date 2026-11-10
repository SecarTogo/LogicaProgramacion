import java.util.Scanner;

public class Vivero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Productos y Precios
        String[] productos = {"Cactus", "Suculenta", "Maceta", "Tierra", "Fertilizante"};
        double[] precios = {45.5, 35.5, 60.0, 80.0, 95.0};
        
        // Días
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};

        final int DIAS = 6;
        final int NUM_PRODUCTOS = 5;

        // Matriz1: Unidades vendidas
        int[][] matrizUnidades = new int[DIAS][NUM_PRODUCTOS];

        // Matriz 2: Monto en pesos por día
        double[][] matrizMontos = new double[DIAS][NUM_PRODUCTOS];


        System.out.println("          SISTEMA DE CONTROL DE VENTAS - VIVERO               ");

        // Captura de datos día por día y producto por producto
        for (int i = 0; i < DIAS; i++) {
            System.out.println("\n>>> REGISTRO DE VENTAS: " + dias[i].toUpperCase() + " <<<");

            for (int j = 0; j < NUM_PRODUCTOS; j++) {
                int cantidad = -1;

                // Validación de 0 o número positivo
                do {
                    System.out.printf("Ingrese unidades vendidas de %s ($%.2f): ", productos[j], precios[j]);
                    if (scanner.hasNextInt()) {
                        cantidad = scanner.nextInt();
                        if (cantidad < 0) {
                            System.out.println("Error: La cantidad no puede ser negativa.");
                        }
                    } else {
                        System.out.println("Error: Debe ingresar un número entero válido.");
                        scanner.next(); // Limpiar entrada incorrecta
                    }
                } while (cantidad < 0);


                matrizUnidades[i][j] = cantidad;
                matrizMontos[i][j] = cantidad * precios[j];
            }
        }

        // MATRIZ DE CANTIDADES VENDIDAS POR DÍA Y TOTAL SEMANAL
        System.out.println("CANTIDAD DE UNIDADES VENDIDAS (POR DÍA)");
        
        // Encabezado de columnas
        System.out.printf("%-12s | %-10s | %-10s | %-10s | %-10s | %-12s%n", 
                "Día", productos[0], productos[1], productos[2], productos[3], productos[4]);
        System.out.println("----------------------------------------------------------------------------");

        // Filas por día
        for (int i = 0; i < DIAS; i++) {
            System.out.printf("%-12s | %-10d | %-10d | %-10d | %-10d | %-12d%n",
                    dias[i],
                    matrizUnidades[i][0],
                    matrizUnidades[i][1],
                    matrizUnidades[i][2],
                    matrizUnidades[i][3],
                    matrizUnidades[i][4]);
        }
        System.out.println("----------------------------------------------------------------------------");

        // Totales semanales por producto
        int[] totalUnidadesSemana = new int[NUM_PRODUCTOS];
        for (int j = 0; j < NUM_PRODUCTOS; j++) {
            for (int i = 0; i < DIAS; i++) {
                totalUnidadesSemana[j] += matrizUnidades[i][j];
            }
        }
        System.out.printf("%-12s | %-10d | %-10d | %-10d | %-10d | %-12d%n",
                "TOTAL SEMANA",
                totalUnidadesSemana[0],
                totalUnidadesSemana[1],
                totalUnidadesSemana[2],
                totalUnidadesSemana[3],
                totalUnidadesSemana[4]);
        System.out.println("============================================================================");


        // SALIDA 2: MATRIZ DE GANANCIA MONETARIA POR DÍA
        System.out.println("MATRIZ 2: GANANCIA MONETARIA POR DÍA EN PESOS (NO ACUMULATIVO)");
        // Encabezado de columnas
        System.out.printf("%-12s | %-11s | %-11s | %-11s | %-11s | %-12s%n", 
                "Día", productos[0], productos[1], productos[2], productos[3], productos[4]);
        System.out.println("---------------------------------------------------------------------------------");

        // Filas por día con importe monetario
        for (int i = 0; i < DIAS; i++) {
            System.out.printf("%-12s | $%-10.2f | $%-10.2f | $%-10.2f | $%-10.2f | $%-11.2f%n",
                    dias[i],
                    matrizMontos[i][0],
                    matrizMontos[i][1],
                    matrizMontos[i][2],
                    matrizMontos[i][3],
                    matrizMontos[i][4]);
        }
        System.out.println("---------------------------------------------------------------------------------");

        // Total monetario por producto a lo largo de la semana
        double[] totalDineroSemana = new double[NUM_PRODUCTOS];
        double granTotalSemana = 0;

        for (int j = 0; j < NUM_PRODUCTOS; j++) {
            for (int i = 0; i < DIAS; i++) {
                totalDineroSemana[j] += matrizMontos[i][j];
            }
            granTotalSemana += totalDineroSemana[j];
        }

        System.out.printf("%-12s | $%-10.2f | $%-10.2f | $%-10.2f | $%-10.2f | $%-11.2f%n",
                "TOTAL SEMANA",
                totalDineroSemana[0],
                totalDineroSemana[1],
                totalDineroSemana[2],
                totalDineroSemana[3],
                totalDineroSemana[4]);
        System.out.println("=================================================================================");
        System.out.printf("TOTAL GENERAL RECAUDADO EN LA SEMANA: $%.2f pesos%n", granTotalSemana);
        System.out.println("=================================================================================");

        scanner.close();
    }
}