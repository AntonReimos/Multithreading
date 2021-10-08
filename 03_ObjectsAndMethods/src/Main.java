public class Main {

    public static void main(String[] args){
        Basket basket = new Basket();
        basket.add("Milk", 40, 400, 5);
        basket.add("Cheese", 80, 600, 5);
        basket.add("Bread", 410, 700, 2);
        basket.print("Milk");



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
