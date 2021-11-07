package ru.skillbox;

public class ArithmeticCalculator {

    private double a = 0;
    private double b = 0;
    private double c = 0;

    public void add(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public static Operation type;

    public ArithmeticCalculator(Operation type) {
        this.type = type;
    }

    public Operation getType() {
        return type;
    }


    public void calculate() {
        if (getType() == Operation.ADD) {
            c = a + b;
        } else if (getType() == Operation.SUBTRACT) {
            c = a - b;
        } else if (getType() == Operation.MULTIPLY) {
            c = a * b;
        }
        System.out.println(c);
    }
}

