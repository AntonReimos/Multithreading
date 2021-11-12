package ru.skillbox;

public class CPU {
    private final double frequency;
    private final int numbersOfCores;
    private final double cpuWeight;

    public static cpuVendor type;

    public CPU(cpuVendor type, double frequency, int numbersOfCores, double weight) {
        this.frequency = frequency;
        this.numbersOfCores = numbersOfCores;
        this.type = type;
        this.cpuWeight = weight;

    }

    public double getCpuWeight() {
        return cpuWeight;
    }

    public String toString() {
        return "Процессор: " + type + ", c частотой: " + frequency + ", кол-во ядер: " + numbersOfCores;
    }


}
