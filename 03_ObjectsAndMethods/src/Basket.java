public class Basket {

    private static int count = 0;// кол-во корзин
    private String items = ""; // имя продукта
    private int totalPrice = 0; //  цена всей корзины
    private double totalWeight = 0; //  вес всей корзины
    private int limitPrice; // лимит цены
    private double limitWeight; // лимит веса
    private  int  totalCount = 0; //считает количество для каждого объекта
    private static int itemsCount = 0; // считает количество для класса
    private static int itemsPrice = 0; //считает цену для классов
    private static int averagePriceItems = 0;// средняя стоимость продукта
    private static int averagePriceBasket = 0;// средняя стоимость корзины

    public Basket() { // создает стандартную корзину со стандартными параметрами
        increaseCount(1);
        items = "Список товаров:";
        this.limitPrice = 10000;
        this.limitWeight = 6000;
    }

    public Basket(int limit) { //Создает корзину с параметрами и передает их в переменные
        this();
        this.limitPrice = limit;
    }

    public Basket(String items, int totalPrice) { //Создает карзину с параметрами и передает их в переменные
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public Basket(String items, int totalPrice, double totalWeight) { //Создает корзину с параметрами и передает их в переменные
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
        this.totalWeight = totalWeight;
    }

    public static int getCount() { //возвращает количество корзин
        return Basket.count;
    }

    public void increaseCount(int count) { //считает количество корзин
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price, double weight) { // добавление 1 товара
        add(name, price, weight, 1);
    }

    public void add(String name, int price, double weight, int count) { // добавление кол-ва товаров
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limitPrice) {
            error = true;
        }

        if (totalWeight + weight >= limitWeight) {
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
        totalCount = totalCount + count;
        itemsCount = itemsCount + totalCount;
        itemsPrice = itemsPrice + totalPrice ;
    }

    public static int getAveragePriceItems(){
        averagePriceItems = itemsPrice / itemsCount;
        return averagePriceItems;
    }

    public static int getAveragePriceBasket(){
        averagePriceBasket = itemsPrice / count;
        return averagePriceBasket;
    }

    public static int getItemsCount() {
        return itemsCount;
    }

    public static int getItemsPrice() {
        return itemsPrice;
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

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {

            System.out.println(items);
            System.out.println("Цена:" + totalPrice + " Вес:" + totalWeight + " Кол-во:" + totalCount);
        }
    }
}
