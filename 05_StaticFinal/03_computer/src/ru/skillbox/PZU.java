package ru.skillbox;

public class PZU {
    private final int pzuVolume;

    public double getPzuWeight() {
        return pzuWeight;
    }

    private final double pzuWeight;

    public static pzuType type;

    public PZU(pzuType type, int pzuVolume, double pzuWeight) {
        this.type = type;
        this.pzuVolume = pzuVolume;
        this.pzuWeight = pzuWeight;

    }

    public String toString() {
        return "Тип диска: " + type + ", объемом: " + pzuVolume + ", весом: " + pzuWeight;
    }
}
