package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket( 15000);
        basket.clear();
        basket.add("Milk", 40, 400, 5);
        basket.add("Cheese", 80, 600, 5);
        basket.add("Bread", 410, 700, 5);
        basket.print("Корзина 1");


        Basket basket1 = new Basket();
        basket1.clear();
        basket1.add("Pepsi", 60, 450, 8);
        basket1.add("Cheese", 80, 600 );
        basket1.add("Bread", 410, 700,10);
        basket1.print( "\n" + "Корзина 2");

        Basket basket2 = new Basket();
        basket2.clear();
        basket2.add("Cola", 62, 425, 2);
        basket2.add("Cheese", 80, 600, 5);
        basket2.add("Bread", 110, 300, 2);
        basket2.print("\n" + "Корзина 3");

        System.out.println("Корзин создано: " + Basket.getCount() + "\n" +
                "Количество товаров: " + Basket.getItemsCount()  + "\n" +
                "Цена товаров: " + Basket.getItemsPrice() + "\n" +
                "Средняя цена товара: " + Basket.getAveragePriceItems() + "\n" +
                "Средняя цена корзины: " + Basket.getAveragePriceBasket());
    }
}
