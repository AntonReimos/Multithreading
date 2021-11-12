package ru.skillbox;

public class Keyboard {
    public double getWeight() {
        return weight;
    }

    private final double weight;

    public static keyboardType type;


    public static keyboardBacklightType backlightType;


    public Keyboard(keyboardType type, keyboardBacklightType backlightType, double weight) {
        Keyboard.type = type;
        Keyboard.backlightType = backlightType;
        this.weight = weight;
    }

    public String toString() {
        return "Клавиатура: " + type + ", наличие подсветки: " + backlightType + ", весом: " + weight;
    }
}

