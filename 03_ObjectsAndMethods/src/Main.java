public class Main {

    public static void main(String[] args){
        Basket basket = new Basket();
        basket.add("Milk", 40, 400, 5);
        basket.add("Cheese", 80, 600, 5);
        basket.add("Bread", 410, 700, 2);
        basket.print("Milk");
    }
}
