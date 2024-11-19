package org.example;

import java.util.Scanner;

public class PruebaFrecuencia {
    public static boolean realizarPrueba(double[] numeros, double valorAceptacion) {
        int[] frecuencias = new int[10];

        for (double numero : numeros) {
            int rango = (int) (numero * 10);
            frecuencias[rango]++;
        }

        double chiCuadrado = 0.0;
        double valorEsperado = numeros.length / 10.0;

        for (int frecuencia : frecuencias) {
            chiCuadrado += Math.pow(frecuencia - valorEsperado, 2) / valorEsperado;
        }

        System.out.println("Valor de chi-cuadrado: " + chiCuadrado);

        return chiCuadrado < valorAceptacion;
        //grad de significacion sirver para sabe rel valor real
    }
}

