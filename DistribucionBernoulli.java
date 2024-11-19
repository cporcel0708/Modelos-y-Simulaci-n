package org.example;

public class DistribucionBernoulli {
    private double p;

    public DistribucionBernoulli(double p) {
        this.p = p;
    }

    public int calcularX(double numAleatorio) {
        return numAleatorio < p ? 1 : 0;
    }
}

