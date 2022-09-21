import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Bank implements Runnable {

    private Map<Integer, Account> accounts = new HashMap<>();
    private final Random random = new Random();
    private final long LIMIT = 50_000;

    @Override
    public void run() {

    }

    // изменять не нужно
    public synchronized boolean isFraud(Integer fromAccountNum, Integer toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Проверка!");
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(Integer fromAccountNum, Integer toAccountNum, long amount) throws InterruptedException {

        if (amount < LIMIT &&
                accounts.get(fromAccountNum).isBlock() == false &&
                accounts.get(toAccountNum).isBlock() == false) {
            long fromMoney = accounts.get(fromAccountNum).getMoney();
            long toMoney = accounts.get(toAccountNum).getMoney();
            System.out.println("Было: " + toMoney);
            accounts.get(fromAccountNum).setMoney(fromMoney -= amount);
            accounts.get(toAccountNum).setMoney(toMoney += amount);
            System.out.println("Перевод от " +
                    accounts.get(fromAccountNum).getAccNumber() +
                    " получателю " + accounts.get(toAccountNum).getAccNumber() +
                    " совершен" + " Стало: " + accounts.get(toAccountNum).getMoney());
        } else {
            boolean fraud = isFraud(fromAccountNum, toAccountNum, amount);
            if (fraud == true) {
                accounts.get(fromAccountNum).setBlock(true);
                accounts.get(toAccountNum).setBlock(true);
            } else {
                accounts.get(fromAccountNum).setBlock(false);
                accounts.get(toAccountNum).setBlock(false);
            }
        }
    }


    public void compare(Integer fromAccountNum, Integer toAccountNum, long amount) throws InterruptedException {
        int hashFrom = System.identityHashCode(fromAccountNum);
        int hashTo = System.identityHashCode(toAccountNum);
        if (hashFrom < hashTo) {
            synchronized (fromAccountNum) {
                synchronized (toAccountNum) {
                    transfer(fromAccountNum, toAccountNum, amount);
                }
            }
        } else if (hashTo < hashFrom) {
            synchronized (toAccountNum) {
                synchronized (fromAccountNum) {
                    transfer(fromAccountNum, toAccountNum, amount);
                }
            }
        }

    }

    public void setMap(Integer name, Account account) {
        this.accounts.put(name, account);
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(Integer accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        Set<Integer> keySet= accounts.keySet();
        long sumMoney = 0;
        for (Integer k: keySet){
           sumMoney += accounts.get(k).getMoney();
        }
        return sumMoney;
    }
}
