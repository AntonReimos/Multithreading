public class Main {

    public static void main(String[] args){
        Basket basket = new Basket();
        basket.add("Milk", 40, 400, 5);
        basket.add("Cheese", 80, 600, 5);
        basket.add("Bread", 410, 700, 5);
        basket.print("Milk");

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

        Basket basket3 = new Basket();
        basket3.clear();
        basket3.add("Pepsi", 65, 330, 5);
        basket3.print("\n" + "Корзина 4");

        System.out.println("Корзин создано: " + Basket.getCount() + "\n" +
                "Количество товаров: " + Basket.getItemsCount()  + "\n" +
                "Цена товаров: " + Basket.getItemsPrice() + "\n" +
                "Средняя цена товара: " + Basket.getAveragePriceItems() + "\n" +
                "Средняя цена корзины: " + Basket.getAveragePriceBasket());


        Arithmetic arithmetic = new Arithmetic();
        arithmetic.add(11, 60);
        System.out.println(" ");
        System.out.println("Арифметика");
        System.out.println(arithmetic.sum());
        System.out.println(arithmetic.multiplication());
        System.out.println(arithmetic.max());
        System.out.println(arithmetic.min());

        Printer.append("Содержимое текста", "Книга с текстом", 15);
        Printer.append("Книга с текстом", "Странно это все");
        Printer.append("Содержимое текста", "Книга с текстом", 25);
        Printer.print("Очередь на печать");

        System.out.println(Printer.getPendingCount());
        Printer.clear();
        System.out.println(Printer.getPendingCount());
        int getSumCount = Printer.sumCount();
        System.out.println(getSumCount);
    }
}
