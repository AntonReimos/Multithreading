public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private double totalWeight = 0;
    private int limit;
    private double limitWeight;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
        this.limitWeight = 6000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }
    public Basket(String items, int totalPrice, double totalWeight) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
        this.totalWeight = totalWeight;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price, double weight) {
        add(name, price, weight, 1);
    }

    public void add(String name, int price, double weight, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if(totalWeight + weight >= limitWeight){
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
            count + " шт. - " + price + "(" + weight + ")";
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + count * weight;
    }

    public void clear() {
       items = "";
       totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

     public double getTotalWeight() {
        return totalWeight;
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Итоговая цена:" + totalPrice + " Итоговый вес:" + totalWeight);
        }
    }
}
