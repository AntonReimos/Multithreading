import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        for (int i = 1; i <= 10; i++) {
            double money = Math.random() * 1_000_000;
            String name = Integer.toString(i);
            Account account = new Account(name, (long) money);
            bank.setMap(name, account);
        }

        Random random = new Random();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            threads.add(new Thread(() -> {
                try {
                    bank.transfer(String.valueOf(random.nextInt(10)),
                            String.valueOf(random.nextInt(10)), random.nextInt(70000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }


        threads.forEach(Thread::start);
    }
}
