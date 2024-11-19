package org.example;

public class DistribucionErlang {
    private int k;
    private double lambda;

    public DistribucionErlang(int k, double lambda) {
        this.k = k;
        this.lambda = lambda;
    }

    public double calcularX(double[] numerosAleatorios) {
        double product = 1.0;
        for (double num : numerosAleatorios) {
            product *= num;
        }
        return -Math.log(product) / lambda;
    }
}

