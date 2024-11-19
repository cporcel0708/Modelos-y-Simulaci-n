package org.example;

public class DistribucionNormal {
    private double media;
    private double desviacionEstandar;

    public DistribucionNormal(double[] numerosAleatorios) {
        // Calcular la media
        double suma = 0.0;
        for (double num : numerosAleatorios) {
            suma += num;
        }
        this.media = suma / numerosAleatorios.length;

        // Calcular la desviación estándar
        double sumaCuadrados = 0.0;
        for (double num : numerosAleatorios) {
            sumaCuadrados += Math.pow(num - media, 2);
        }
        this.desviacionEstandar = Math.sqrt(sumaCuadrados / numerosAleatorios.length);
    }

    public double calcularX(double numAleatorio1, double numAleatorio2) {
        double z = Math.sqrt(-2.0 * Math.log(numAleatorio1)) * Math.cos(2.0 * Math.PI * numAleatorio2);
        return media + z * desviacionEstandar;
    }

    public double getMedia() {
        return media;
    }

    public double getDesviacionEstandar() {
        return desviacionEstandar;
    }
}

//correjir: porque en la distribucion, tiene que recibir como parametro la media y la desviacion estandar.

