package ru.skillbox;

public class RAM {
    private final int ramVolume;
    private final double ramWeight;

    public double getRamWeight() {
        return ramWeight;
    }

    public static ramType type;

    public RAM(ramType type, int ramVolume, double ramWeight) {
        this.ramVolume = ramVolume;
        this.ramWeight = ramWeight;
        this.type = type;

    }

    public String toString() {
        return "Оперативная память: " + type + ", объемом: " + ramVolume + ", весом: " + ramWeight;
    }
}
