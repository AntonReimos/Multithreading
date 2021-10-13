package ru.skillbox;

public class Bus {
    public String busName;
    public double gasMileage;
    public int maxSpeed;
    public int numberOfSeats;

    public Bus(String name, double mileage, int speed, int seats) {
        this.busName = name;
        this.gasMileage = mileage;
        this.maxSpeed = speed;
        this.numberOfSeats = seats;
    }

    public String getBusName() {
        return busName;
    }

    public double getGasMileage() {
        return gasMileage;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public void setGasMileage(int gasMileage) {
        this.gasMileage = gasMileage;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
