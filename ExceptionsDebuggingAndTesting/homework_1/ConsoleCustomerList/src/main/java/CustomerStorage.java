import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

//TODO: Пропишите в проекте ConsoleCustomerList в классе CustomerStorage
// все возможные варианты защиты от некорректных данных и преждевременного
// завершения метода добавления addCustomer().
// Программа должна выбрасывать исключения (Exception) при неверном:
// количестве компонентов в переданной строке с данными,
// формате номера телефона,
// формате email.

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");

        boolean email = Pattern.matches("[A-Za-z0-9]+@[A-Za-z]+(\\.)[A-Za-z]+", components[INDEX_EMAIL]);
        boolean phone = Pattern.matches("\\+\\d{11}", components[INDEX_PHONE]);

        if (components.length != 4) {
            throw new IllegalArgumentException("Throwable to be thrown, but nothing was thrown.");
        } else if (!email) {
            throw new IllegalArgumentException("Throwable to be thrown, but nothing was thrown.2");
        } else if (!phone) {
            throw new IllegalArgumentException("Throwable to be thrown, but nothing was thrown.3");
        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}