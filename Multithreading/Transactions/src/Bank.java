import java.util.*;

public class Bank implements Runnable {

    private Map<String, Account> accounts = new Hashtable<>();
    private final Random random = new Random();
    private final long LIMIT = 50_000;


    @Override
    public void run() {

    }

    // изменять не нужно
    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum)
            throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " " + "Проверка аккаунтов: " + fromAccountNum + " и " + toAccountNum + "!");
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        String firstLock = compare(fromAccountNum, toAccountNum) > 0 ? fromAccountNum : toAccountNum;
        String secondLock = compare(fromAccountNum, toAccountNum) > 0 ? toAccountNum : fromAccountNum;
        if (fromAccountNum.equals(toAccountNum)) {
            System.out.println("Указан одинаковый счет,  передача невозможна");
        } else {
            //synchronized (firstLock) {
              //  synchronized (secondLock) {
                    System.out.println(Thread.currentThread().getName() + " - " + fromAccountNum + " " + toAccountNum);

                    if (amount > LIMIT) {
                        boolean froud = isFraud(fromAccountNum, toAccountNum);
                        accounts.get(fromAccountNum).setBlock(froud);
                        accounts.get(toAccountNum).setBlock(froud);
                        System.out.println("Сумма: " + amount + " Блокировка: " + fromAccountNum + " и " + toAccountNum + "!");
                    } else if (accounts.get(fromAccountNum).isBlock() == false &&
                            accounts.get(toAccountNum).isBlock() == false) {
                        System.out.println(Thread.currentThread().getName() + " Перевод совершен!");
                        System.out.println(Thread.currentThread().getName() +
                                "Было: " + accounts.get(fromAccountNum).getMoney() +
                                " - " + accounts.get(toAccountNum).getMoney());
                        accounts.get(fromAccountNum).describe(amount);
                        accounts.get(toAccountNum).enrollment(amount);
                        System.out.println(Thread.currentThread().getName() +
                                "Стало: " + accounts.get(fromAccountNum).getMoney() +
                                " - " + accounts.get(toAccountNum).getMoney());
                    } else {
                        System.out.println("Счета заблокированы!");
                    }
                }
        //    }
      //  }
    }


    private int compare(String fromAccountName, String toAccountName) {
        return fromAccountName.compareTo(toAccountName);
    }


    public void setMap(String name, Account account) {
        this.accounts.put(name, account);
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        Set<String> keySet = accounts.keySet();
        long sumMoney = 0;
        for (String k : keySet) {
            sumMoney += accounts.get(k).getMoney();
        }
        return sumMoney;
    }
}
