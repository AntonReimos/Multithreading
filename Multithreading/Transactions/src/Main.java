public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        for (int i = 1; i <= 10; i++) {
            double money = Math.random() * 1_000_000;
            Account account = new Account(i, (long) money);
            bank.setMap(i, account);
        }

//        for (int i = 1; i <= 10; i++) {
//            System.out.println("Номер счета: " + bank.getAccounts().get(i).getAccNumber() + "\n" +
//                    "Остаток на счету: " + bank.getAccounts().get(i).getMoney() + "\n" +
//                    "Блокировка: " + bank.getAccounts().get(i).isBlock());
//        }
        new Thread(() -> {
            try {
                bank.compare(2, 5, 25000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                bank.compare(4, 6, 51000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                bank.compare(1, 3, 15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                bank.compare(7, 3, 75000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println(bank.getSumAllAccounts());

        System.out.println(bank.getBalance(6));
    }
}
