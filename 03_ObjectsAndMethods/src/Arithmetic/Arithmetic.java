public class Arithmetic {

    public int a = 0;
    public int b = 0;

    public void add(int var1, int var2) {
        a = var1;
        b = var2;

    }

    public int sum() {
        return a + b;
    }

    public int multiplication() {
        return a * b;
    }

    public int max() {
        return (a > b ? a : b);
    }

    public int min() {
        return (a < b ? a : b);
    }

}