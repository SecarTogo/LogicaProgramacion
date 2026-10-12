package testers;

import java.util.Scanner;

public class ListaNumeros {
    public static void main(String[] args) {
    System.out.println("Escribe 10 números enteros");

    int[] numeros = new int[10];
    Scanner consola = new Scanner(System.in);

    for (int i = 0; i < numeros.length; i++) {
        System.out.println("Escribe el número " + (i + 1));
        numeros[i] = consola.nextInt();
    }
    int mayor = numeros[0];
    int menor = numeros[0];
    int posicionMayor = 0;
    int posicionMenor = 0;  

    for (int i = 1; i < numeros.length; i++) {
        if (numeros[i] > mayor) {
            mayor = numeros[i];
            posicionMayor = i;
        }
        if (numeros[i] < menor) {
            menor = numeros[i];
            posicionMenor = i;
        }
    }
    System.out.println("El número mayor es " + mayor + " y está en la posición " + posicionMayor);
    System.out.println("El número menor es " + menor + " y está en la posición " + posicionMenor);
  }
}