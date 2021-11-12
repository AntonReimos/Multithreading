package ru.skillbox;

public class Monitor {
    private final double diagonal;

    public double getWeight() {
        return weight;
    }

    private final double weight;

    public static matrixType type;

    public Monitor(matrixType type, double diagonal, double weight) {
        Monitor.type = type;
        this.diagonal = diagonal;
        this.weight = weight;
    }

    public String toString() {
        return "Монитор: " + type + ", с диагональю: " + diagonal + ", весом: " + weight;
    }
}