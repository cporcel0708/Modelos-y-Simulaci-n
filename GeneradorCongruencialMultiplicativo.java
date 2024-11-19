package org.example;

public class GeneradorCongruencialMultiplicativo {
    private int seed;
    private int a;
    private int m;

    public GeneradorCongruencialMultiplicativo(int seed, int a, int m) {
        this.seed = seed;
        this.a = a;
        this.m = m;
    }

    public double next() {
        seed = (a * seed) % m;
        double normalized = seed / (double) m;
        return Math.round(normalized * 100000.0) / 100000.0;  // Redondea a 5 decimales
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }
}

