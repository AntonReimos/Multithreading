package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Delivery delivery = new Delivery(
                600,
                "Басовая 19",
                true,
                false,
                "AF65ED76"
        );

        Dimensions dimensions = new Dimensions(
                5,
                2,
                3
        );

        Delivery delivery1 = new Delivery(
                400,
                "Ткатская 24, к1, 120",
                true,
                true,
                "EF86HGE"
        );

        Dimensions dimensions1 = new Dimensions(
                5,
                10,
                2
        );

        Delivery delivery2 = new Delivery();

        delivery = delivery.setDeliveryAddress("Адрес доставки");
        delivery2 = delivery2.setDeliveryAddress("Следующий адрес");

        Dimensions dimensions2 = new Dimensions(
                10,
                5,
                3
        );

        System.out.println(delivery);
        System.out.println(dimensions.getDeliveryVolume());
        System.out.println(delivery1);
        System.out.println(dimensions1.getDeliveryVolume());
        System.out.println(delivery2);
        System.out.println(dimensions2.getDeliveryVolume());

    }
}