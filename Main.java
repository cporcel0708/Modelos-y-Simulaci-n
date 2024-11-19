package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Parámetros de entrada
        System.out.println("Ingrese la semilla: ");
        int seed = scanner.nextInt();

        System.out.println("Ingrese el multiplicador: ");
        int a = scanner.nextInt();

        System.out.println("Ingrese el módulo: ");
        int m = scanner.nextInt();

        System.out.println("Ingrese la constante aditiva (para el generador mixto): ");
        int c = scanner.nextInt();

        double[] numeros = new double[10];

        // Menú de selección del generador
        System.out.println("Seleccione el generador: ");
        System.out.println("1. LFSR");
        System.out.println("2. Generador Congruencial Mixto");
        System.out.println("3. Generador Congruencial Multiplicativo");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ingrese el tap (para LFSR): ");
                int tap = scanner.nextInt();
                LFSR lfsr = new LFSR(seed, tap);
                for (int i = 0; i < 10; i++) {
                    numeros[i] = lfsr.next();
                }
                break;
            case 2:
                GeneradorCongruencialMixto gcm = new GeneradorCongruencialMixto(seed, a, c, m);
                for (int i = 0; i < 10; i++) {
                    numeros[i] = gcm.next();
                }
                break;
            case 3:
                GeneradorCongruencialMultiplicativo gcmul = new GeneradorCongruencialMultiplicativo(seed, a, m);
                for (int i = 0; i < 10; i++) {
                    numeros[i] = gcmul.next();
                }
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        // Mostrar los números generados y normalizados
        System.out.println("Números generados y normalizados:");
        for (double num : numeros) {
            System.out.println(num);
        }

        // Menú de selección de pruebas
        System.out.println("Seleccione la prueba estadística: ");
        System.out.println("1. Prueba del Promedio");
        System.out.println("2. Prueba de Frecuencia");
        System.out.println("3. Prueba Kolmogorov-Smirnov");
        System.out.println("4. Prueba de Póker");
        int pruebaOpcion = scanner.nextInt();                                                           

        System.out.println("Ingrese el valor de aceptación: ");
        String valorAceptacionStr = scanner.next().replace(',', '.');
        double valorAceptacion = Double.parseDouble(valorAceptacionStr);
        boolean resultado;

        switch (pruebaOpcion) {
            case 1:
                resultado = PruebaPromedio.realizarPrueba(numeros, valorAceptacion);
                break;
            case 2:
                resultado = PruebaFrecuencia.realizarPrueba(numeros, valorAceptacion);
                break;
            case 3:
                resultado = PruebaKolmogorovSmirnov.realizarPrueba(numeros, valorAceptacion);
                break;
            case 4:
                resultado = PruebaPoker.realizarPrueba(numeros, valorAceptacion);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        if (resultado) {
            System.out.println("PRUEBA SUPERADA");
        } else {
            System.out.println("PRUEBA NO SUPERADA");
        }

        // Menú de selección de distribuciones
        System.out.println("Seleccione la distribución: ");
        System.out.println("1. Distribución Uniforme");
        System.out.println("2. Distribución Exponencial");
        System.out.println("3. Distribución Bernoulli");
        System.out.println("4. Distribución Normal");
        System.out.println("5. Distribución Binomial");
        System.out.println("6. Distribución Erlang");
        int distribucionOpcion = scanner.nextInt();

        switch (distribucionOpcion) {
            case 1:
                System.out.println("Ingrese el valor mínimo para la Distribución Uniforme:");
                double min = scanner.nextDouble();
                System.out.println("Ingrese el valor máximo para la Distribución Uniforme:");
                double max = scanner.nextDouble();
                DistribucionUniforme distUniforme = new DistribucionUniforme(min, max);
                for (double num : numeros) {
                    System.out.println("Para numAleatorio= " + num + ", x es= " + distUniforme.calcularX(num));
                }
                break;
            case 2:
                System.out.println("Ingrese el valor de lambda para la Distribución Exponencial:");
                double lambdaExp = scanner.nextDouble();
                DistribucionExponencial distExponencial = new DistribucionExponencial(lambdaExp);
                for (double num : numeros) {
                    System.out.println("Para numAleatorio= " + num + ", x es: " + distExponencial.calcularX(num));
                }
                break;
            case 3:
                System.out.println("Ingrese el valor de p para la Distribución Bernoulli:");
                double pBernoulli = scanner.nextDouble();
                DistribucionBernoulli distBernoulli = new DistribucionBernoulli(pBernoulli);
                for (double num : numeros) {
                    System.out.println("Para numAleatorio= " + num + ", x es: " + distBernoulli.calcularX(num));
                }
                break;
            case 4:
                DistribucionNormal distNormal = new DistribucionNormal(numeros);
                System.out.println("Media calculada: " + distNormal.getMedia());
                System.out.println("Desviación estándar calculada: " + distNormal.getDesviacionEstandar());
                for (int i = 0; i < numeros.length; i += 2) {
                    if (i + 1 < numeros.length) {
                        System.out.println("Para numAleatorio1 = " + numeros[i] + " y numAleatorio2 = " + numeros[i + 1] + ", x es: " + distNormal.calcularX(numeros[i], numeros[i + 1]));
                    }
                }
                break;
            case 5:
                System.out.println("Ingrese el número de ensayos n para la Distribución Binomial:");
                int n = scanner.nextInt();
                System.out.println("Ingrese la probabilidad p para la Distribución Binomial:");
                double pBinomial = scanner.nextDouble();
                DistribucionBinomial distBinomial = new DistribucionBinomial(n, pBinomial);
                System.out.println("El valor de x es: " + distBinomial.calcularX(numeros));
                break;
            case 6:
                System.out.println("Ingrese el valor de k para la Distribución Erlang:");
                int k = scanner.nextInt();
                System.out.println("Ingrese el valor de lambda para la Distribución Erlang:");
                double lambdaErlang = scanner.nextDouble();
                DistribucionErlang distErlang = new DistribucionErlang(k, lambdaErlang);
                System.out.println("El valor de x es: " + distErlang.calcularX(numeros));
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
    }
}
