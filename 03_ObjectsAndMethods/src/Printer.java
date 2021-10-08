public class Printer {
    public static  String queue = "";
    public static int sumCount = 0;
    public static int count = 0;
    public static int pendingCount = 0;




    public static void append(String text){
        queue = queue + "\n" + text;

    }

    public static void append(String text, String name){
        queue = queue + "\n" + text + name;

    }

    public static void append(String text, String name, int count){
        queue = queue + "\n" + text + " " + name + " " + count;
        pendingCount = pendingCount + count;
        sumCount = pendingCount;
    }

    public static void clear() {
        queue = "";
        pendingCount = 0;
    }

    public static int getPendingCount(){
        return pendingCount;

    }

    public static int sumCount(){
        return sumCount;
    }

    public static void print(String title){
        System.out.println(title);
        System.out.println();
        if(queue.isEmpty()) {
            System.out.println("Очередь на печать пуста");
        }else {
            System.out.println(queue);
        }
    }
}