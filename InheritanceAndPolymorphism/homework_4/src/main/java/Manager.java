public class Manager implements Employee {
    private static int ManagerSalary;
    private final int MAX_SALARY = 140_000;
    private final int MIN_SALARY = 115_000;
    private int salary = 50_000;
    // TODO:Создайте классы сотрудников с информацией о зарплатах и условиями начисления зарплаты:
    //  Manager — зарплата складывается из фиксированной части и бонуса в виде 5% от заработанных
    //  для компании денег. Количество заработанных денег для компании генерируйте случайным
    //  образом от 115 000 до 140 000 рублей.


    public Manager() {
        this.salary = getMonthSalary();
    }

    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public int getMonthSalary() {
        ManagerSalary = (int) (MIN_SALARY + ((Math.random() * (MAX_SALARY - MIN_SALARY))));
        ManagerSalary = (int) (salary + ManagerSalary * 0.05);
        return ManagerSalary;
    }
}

