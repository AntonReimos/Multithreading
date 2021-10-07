public class Main {
    public static void main(String[] args){
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
