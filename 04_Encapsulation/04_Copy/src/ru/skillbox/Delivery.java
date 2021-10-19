package ru.skillbox;

public class Delivery {

    private final double deliveryWeight;
    private final String deliveryAddress;
    private final boolean deliveryPosition;
    private final boolean deliveryFraglity;
    private final String deliveryNumber;

    @Override
    public String toString() {
        return "===============" + '\n' +
                "Weight=" + deliveryWeight + '\n' +
                "Address='" + deliveryAddress + '\n' +
                "Position=" + deliveryPosition +  '\n' +
                "Fraglity=" + deliveryFraglity + '\n' +
                "Number='" + deliveryNumber;
    }

    public Delivery() {
        deliveryWeight = 0;
        deliveryAddress = "N/A";
        deliveryPosition = false;
        deliveryFraglity = false;
        deliveryNumber = "N/A";
    }

    public Delivery(double deliveryWeight,
                    String deliveryAddress,
                    boolean deliveryPosition,
                    boolean deliveryFraglity,
                    String deliveryNumber) {
        this.deliveryWeight = deliveryWeight;
        this.deliveryAddress = deliveryAddress;
        this.deliveryPosition = deliveryPosition;
        this.deliveryFraglity = deliveryFraglity;
        this.deliveryNumber = deliveryNumber;
    }

    public Delivery setDeliveryWeight(double deliveryWeight) {
        return new Delivery(deliveryWeight,
                deliveryAddress,
                deliveryPosition,
                deliveryFraglity,
                deliveryNumber);
    }

    public Delivery setDeliveryAddress(String deliveryAddress) {
        return new Delivery(deliveryWeight,
                deliveryAddress,
                deliveryPosition,
                deliveryFraglity,
                deliveryNumber);
    }

    public Delivery setDeliveryPosition(boolean deliveryPosition) {
        return new Delivery(deliveryWeight,
                deliveryAddress,
                deliveryPosition,
                deliveryFraglity,
                deliveryNumber);
    }

    public Delivery setDeliveryFraglity(boolean deliveryFraglity) {
        return new Delivery(deliveryWeight,
                deliveryAddress,
                deliveryPosition,
                deliveryFraglity,
                deliveryNumber);
    }

    public Delivery setDeliveryNumber(String deliveryNumber) {
        return new Delivery(deliveryWeight,
                deliveryAddress,
                deliveryPosition,
                deliveryFraglity,
                deliveryNumber);
    }

    public double getDeliveryWeight() {
        return deliveryWeight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isDeliveryPosition() {
        return deliveryPosition;
    }

    public boolean isDeliveryFraglity() {
        return deliveryFraglity;
    }

    public String getDeliveryNumber() {
        return deliveryNumber;
    }

}