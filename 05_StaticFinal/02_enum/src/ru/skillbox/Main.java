package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(Operation.ADD);
        arithmeticCalculator.add(7, 8);
        arithmeticCalculator.calculate();
    }
}
