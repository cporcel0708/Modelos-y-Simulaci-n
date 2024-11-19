package org.example;
public class LFSR {
    private int seed;
    private int tap;

    public LFSR(int seed, int tap) {
        this.seed = seed;
        this.tap = tap;
    }

    public double next() {
        int bit = ((seed >> 0) ^ (seed >> tap)) & 1;
        seed = (seed >> 1) | (bit << 31);
        double normalized = (seed & 0x7FFFFFFF) / (double) Integer.MAX_VALUE;
        return Math.round(normalized * 100000.0) / 100000.0;  // Redondea a 5 decimales
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }
}


