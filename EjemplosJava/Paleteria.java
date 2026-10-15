import java.util.Scanner;

public class Paleteria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalDias = 2;
        int totalSabores = 3;

        String[] sabores = {"Fresa", "Limón", "Coco"};
        double[] precios = {15.0, 12.0, 18.0};

        //Ciclo
        for (int dia = 1; dia <= totalDias; dia++) {
            double totalDia = 0.0;

            System.out.println("Día " + dia);

            for (int i = 0; i < totalSabores; i++) {
                System.out.print("Cantidad vendidas de paletas de " + sabores[i] + ": ");
                int cantidadVendida = scanner.nextInt();

                totalDia += cantidadVendida * precios[i];  
            }

            System.out.println("Total de ventas del día " + dia + ": $" + totalDia);
            System.out.println();
        }

        scanner.close();
    }
}