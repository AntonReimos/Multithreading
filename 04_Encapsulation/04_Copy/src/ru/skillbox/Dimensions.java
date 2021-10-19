package ru.skillbox;

public class Dimensions {

    private double deliveryVolume;
    private final double height;
    private final double lenght;
    private final double winth;

    public Dimensions(double height, double lenght, double winth) {
        this.height = height;
        this.lenght = lenght;
        this.winth = winth;
    }

    public Dimensions setHeight(double height) {
        return new Dimensions(height, lenght, winth);
    }

    public Dimensions setLenght(double lenght) {
        return new Dimensions(height, lenght, winth);
    }

    public Dimensions setWinth(double winth) {
        return new Dimensions(height, lenght, winth);
    }


    public double getDeliveryVolume() {
        deliveryVolume = height * lenght * winth;
        return deliveryVolume;
    }
}
