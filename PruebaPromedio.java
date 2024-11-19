package org.example;

import java.util.Scanner;

public class PruebaPromedio {
    public static boolean realizarPrueba(double[] numeros, double valorAceptacion) {
        double promedio = 0.0;
        for (double numero : numeros) {
            promedio += numero;
        }
        promedio /= numeros.length;

        double valorEsperado = 0.5;
        double varianza = 1.0 / 12.0;
        double z0 = (promedio - valorEsperado) * Math.sqrt(numeros.length) / Math.sqrt(varianza);
        z0 = Math.abs(z0);

        System.out.println("El promedio es: " + promedio);
        System.out.println("Valor de z0: " + z0);

        return z0 < valorAceptacion;

        //comparar con la normal
    }
}

