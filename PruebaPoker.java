package org.example;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PruebaPoker {
    public static boolean realizarPrueba(double[] numeros, double valorAceptacion) {
        Map<String, Integer> combinaciones = new HashMap<>();

        for (double numero : numeros) {
            String numStr = String.format("%.5f", numero).substring(2, 7);
            char[] digitos = numStr.toCharArray();
            Arrays.sort(digitos);  // Aquí necesitamos importar Arrays
            String combinacion = new String(digitos);
            combinaciones.put(combinacion, combinaciones.getOrDefault(combinacion, 0) + 1);
        }

        double chiCuadrado = 0.0;
        double valorEsperado = numeros.length / (double) combinaciones.size();

        for (int frecuencia : combinaciones.values()) {
            chiCuadrado += Math.pow(frecuencia - valorEsperado, 2) / valorEsperado;
        }

        System.out.println("Valor de chi-cuadrado (Prueba de Póker): " + chiCuadrado);

        return chiCuadrado < valorAceptacion;
    }
}


