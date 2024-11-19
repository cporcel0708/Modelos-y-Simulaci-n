package org.example;

public class DistribucionExponencial {
    private double lambda;

    public DistribucionExponencial(double lambda) {
        this.lambda = lambda;
    }

    public double calcularX(double numAleatorio) {
        return -Math.log(1 - numAleatorio) / lambda;
    }
}

