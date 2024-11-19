package org.example;

public class DistribucionBinomial {
    private int n;
    private double p;

    public DistribucionBinomial(int n, double p) {
        this.n = n;
        this.p = p;
    }

    public int calcularX(double[] numerosAleatorios) {
        int x = 0;
        for (double num : numerosAleatorios) {
            if (num < p) {
                x++;
            }
        }
        return x;
    }
}

