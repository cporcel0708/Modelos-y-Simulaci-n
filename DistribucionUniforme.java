package org.example;
public class DistribucionUniforme {
    private double min;
    private double max;

    public DistribucionUniforme(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public double calcularX(double numAleatorio) {
        return min + numAleatorio * (max - min);
    }
}

