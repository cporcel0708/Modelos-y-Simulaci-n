package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class PruebaKolmogorovSmirnov {
    public static boolean realizarPrueba(double[] numeros, double valorAceptacion) {
        Arrays.sort(numeros);
        double dMax = 0.0;

        for (int i = 0; i < numeros.length; i++) {
            double dPlus = (i + 1.0) / numeros.length - numeros[i];
            double dMinus = numeros[i] - i / (double) numeros.length;
            dMax = Math.max(dMax, Math.max(dPlus, dMinus));
        }

        System.out.println("Valor de Dmax: " + dMax);

        return dMax < valorAceptacion;
    }
}

