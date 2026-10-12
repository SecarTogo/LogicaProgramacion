package testers;

import java.util.ArrayList;
import java.util.Scanner;

public class ArreglosLista {
    public static void main(String[] args) {

        String[] alumnos = new String[27];
        boolean[] asistencia = new boolean[27];
        Scanner consola = new Scanner(System.in);

        alumnos[0] = "Álvarez Urrea Chelsea Jeraldyn";
        alumnos[1] = "Avila Ramirez Emmanuel";
        alumnos[2] = "Escareño Solorio Juan Mauricio";
        alumnos[3] = "Escobedo Guerra Victor Manuel";
        alumnos[4] = "González De Alba Francisco Javier";
        alumnos[5] = "Gonzalez Rossi Santiago";
        alumnos[6] = "Hernandez Aguilar Emiliano";
        alumnos[7] = "Lozano Aldana José Mariano";
        alumnos[8] = "Macias Hernandez Luis Leonardo";
        alumnos[9] = "Manrique Morales Fernanda Arely";
        alumnos[10] = "Marquez Esparza Saul Alejandro";
        alumnos[11] = "Meza Lozano Barbara";
        alumnos[12] = "Montoya Sandoval Viery Dassaeb";
        alumnos[13] = "Ornelas González Gael";
        alumnos[14] = "Pimentel Dolores Angel Salvador";
        alumnos[15] = "Piñon Garcia Axel Emmanuel";
        alumnos[16] = "Ramírez Zaldumbide Ignacio Xavier";
        alumnos[17] = "Rodríguez Arellano Cruz Ángel";
        alumnos[18] = "Rodríguez Santoyo Diego Tadeo";
        alumnos[19] = "Sánchez Álvarez Ingrid Regina";
        alumnos[20] = "Sierra Perez José Angel";
        alumnos[21] = "Torres Gonzalez Cesar Santiago";
        alumnos[22] = "Tovar Romero Jhostyn Alexander";
        alumnos[23] = "Trejo Hernández Jorge Alonso";
        alumnos[24] = "Vazquez Gomez Angel De Jesus";
        alumnos[25] = "Vilchis Perez Jose Miguel";
        alumnos[26] = "Viveros Tellez Kevin";

        System.out.println("Escribe true/false para indicar si el alumno asistió o no a clase.");
        int asistencias = 0;
        int faltas = 0;
        ArrayList<String> faltaron = new ArrayList<>();

        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("¿Asistió? " + alumnos[i]);
            boolean respuesta = Boolean.parseBoolean(consola.nextLine());
            asistencia[i] = respuesta;

            if (respuesta) {
                asistencias++;
            } else {
                faltas++;
                faltaron.add(alumnos[i]);
            }
        }
        consola.close();

        //reporte de asistencia
        System.out.println("El número de asistencias es: " + asistencias);

        //reporte de faltas
        System.out.println("El número de faltas es: " + faltas);

        //quienes faltaron
        for (int i = 0; i < faltaron.size(); i++) {
            System.out.println("Alumnos que faltaron: " + faltaron.get(i));
        }
    }
}