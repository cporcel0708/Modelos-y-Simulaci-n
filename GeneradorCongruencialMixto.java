package org.example;

public class GeneradorCongruencialMixto {
    private int seed;
    private int a;
    private int c;
    private int m;

    public GeneradorCongruencialMixto(int seed, int a, int c, int m) {
        this.seed = seed;
        this.a = a;
        this.c = c;
        this.m = m;
    }

    public double next() {
       seed = (a * seed + c) % m;
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


