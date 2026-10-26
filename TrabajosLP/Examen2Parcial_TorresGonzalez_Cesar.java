import java.util.Scanner;
import java.util.ArrayList;

public class Examen2Parcial_TorresGonzalez_Cesar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // AVISO: Maestra, por alguna razón el código a veces no funciona y otras sí.
        // Sinceramente no sé por qué sea, Dios ha abandonado este proyecto y a todos nosotros
        // En caso de que en la terminal salte error, vuelva a correrlo y debería de funcionar.

        // olvídelo, era por la ubicación del archivo

        // Arreglos de productos y precios, ArrayList para clientes
        String[] productos = {"Chocolate", "Paleta", "Gomitas", "Galletas"};
        double[] precios = {18.0, 12.0, 25.0, 15.0};

        ArrayList<String> clientes = new ArrayList<>();
        
        // Contadores y acumuladores
        int[] unidadesVendidas = new int[4];       
        double[] ingresosPorProducto = new double[4];
        
        double dineroTotalBruto = 0;
        double dineroTotalDescuentos = 0;
        double dineroTotalNeto = 0;

        // Menú de dulcería
        System.out.println("    BIENVENIDO A LA DULCERÍA DE SAN JUAN BAUTISTA DE LA SALLE    ");

        // Registro de clientes
        int numClientes = 0;
        do {
            System.out.print("Ingrese la cantidad de clientes de hoy (mayor a 0): ");
            if (scanner.hasNextInt()) {
                numClientes = scanner.nextInt();
                if (numClientes <= 0) {
                    System.out.println("Error: El número de clientes de hoy deben ser mayor a 0.");
                }
            } else {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.next();
            }
        } while (numClientes <= 0);
        scanner.nextLine();

        // Arreglo para guardar el gasto total neto de cada cliente (para el promedio y reportes y eso)
        double[] totalPorCliente = new double[numClientes];

        // Registro de compras
        for (int i = 0; i < numClientes; i++) {
            System.out.println("\n--------------------------------------------------");
            System.out.println("Atendiendo al Cliente número " + (i + 1) + " de " + numClientes);
            System.out.print("Ingrese el nombre del bello cliente: ");
            String nombreCliente = scanner.nextLine();
            clientes.add(nombreCliente);

            double gastoClienteBruto = 0;
            char continuarComprando;

            do {
                // Catálogo de productos
                System.out.println("\n--- Catálogo de Productos ---");
                System.out.println("1. " + productos[0] + " - $" + precios[0]);
                System.out.println("2. " + productos[1] + " - $" + precios[1]);
                System.out.println("3. " + productos[2] + " - $" + precios[2]);
                System.out.println("4. " + productos[3] + " - $" + precios[3]);


                int codigo = 0;
                do {
                    System.out.print("Ingrese el código del producto que desea comprar (1-4): ");
                    if (scanner.hasNextInt()) {
                        codigo = scanner.nextInt();
                        if (codigo < 1 || codigo > 4) {
                            System.out.println("Error: No vendemos tantos productos, hijo. Debe ser entre 1 y 4.");
                        }
                    } else {
                        System.out.println("Error: Ingrese un número válido.");
                        scanner.next();
                    }
                } while (codigo < 1 || codigo > 4);

                int cantidad = 0;
                do {
                    System.out.print("Ingrese la cantidad deseada: ");
                    if (scanner.hasNextInt()) {
                        cantidad = scanner.nextInt();
                        if (cantidad <= 0) {
                            System.out.println("Error: Si vas a comprar, debe ser mayor a 0.");
                        }
                    } else {
                        System.out.println("Error: Ingrese un número válido.");
                        scanner.next();
                    }
                } while (cantidad <= 0);

                // Calcular importe
                double importeProducto = 0;
                int indice = codigo - 1;

                switch (codigo) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        importeProducto = precios[indice] * cantidad;
                        unidadesVendidas[indice] += cantidad;
                        ingresosPorProducto[indice] += importeProducto;
                        break;
                    default:
                        System.out.println("Código no reconocido.");
                        break;
                }

                gastoClienteBruto += importeProducto;
                System.out.println("-> Importe de esta compra: $" + importeProducto);

                // Preguntar si desea comprar algo más
                System.out.print("¿Desea agregar otro producto? (s/n): ");
                continuarComprando = scanner.next().toLowerCase().charAt(0);
                scanner.nextLine();

            } while (continuarComprando == 's');

            // Aplicación de descuento por volumen)
            double descuentoCliente = 0;
            if (gastoClienteBruto > 100.0) {
                descuentoCliente = gastoClienteBruto * 0.05;
            }
            double gastoClienteNeto = gastoClienteBruto - descuentoCliente;

            totalPorCliente[i] = gastoClienteNeto;
            dineroTotalBruto += gastoClienteBruto;
            dineroTotalDescuentos += descuentoCliente;
            dineroTotalNeto += gastoClienteNeto;
        }

        // Tabla de registros de ventas
        System.out.println("         REPORTE DE VENTAS            ");
        System.out.println("======================================");
        System.out.printf("%-12s | %-12s | %-15s | %-15s%n", "Producto", "Precio Unit.", "Cant. Vendida", "Importe Bruto");
        System.out.println("--------------------------------------");
        for (int i = 0; i < 4; i++) {
            System.out.printf("%-12s | $%-11.2f | %-15d | $%-14.2f%n", 
                productos[i], precios[i], unidadesVendidas[i], ingresosPorProducto[i]);
        }

        // Reporte final
        System.out.println("==================================================");
        System.out.println("                   REPORTE FINAL                  ");
        System.out.println("==================================================");
        System.out.println("Cantidad total de clientes atendidos hoy: " + numClientes);
        
        System.out.println("\nLista de nombres de los clientes atendidos hpoy:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(" - " + clientes.get(i) + " (Total pagado: $" + String.format("%.2f", totalPorCliente[i]) + ")");
        }

        System.out.println("\nCantidad total vendida de cada tipo de producto:");
        for (int i = 0; i < 4; i++) {
            System.out.println(" - " + productos[i] + ": " + unidadesVendidas[i] + " unidades");
        }

        System.out.printf("\nTotal de dinero recaudado (Bruto): $%.2f%n", dineroTotalBruto);
        System.out.printf("Total de descuentos aplicados: $%.2f%n", dineroTotalDescuentos);
        System.out.printf("Total de dinero recaudado después de descuentos: $%.2f%n", dineroTotalNeto);

        double promedioVenta = numClientes > 0 ? dineroTotalNeto / numClientes : 0;
        System.out.printf("Promedio de venta por cliente: $%.2f%n", promedioVenta);
        System.out.println("==================================================");

        scanner.close();
    }
}