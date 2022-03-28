public class Manager {//implements Employee{
    // TODO:Создайте классы сотрудников с информацией о зарплатах и условиями начисления зарплаты:
    //  Manager — зарплата складывается из фиксированной части и бонуса в виде 5% от заработанных
    //  для компании денег. Количество заработанных денег для компании генерируйте случайным
    //  образом от 115 000 до 140 000 рублей.

    //@Override
    public void hire(String name) {
        int salary = 35_000;
        int earnedForCompany;
        final int MIN_SALARY = 115_000;
        final int MAX_SALARY = 140_000;
        earnedForCompany = (int) (MIN_SALARY + ((Math.random() * (MAX_SALARY - MIN_SALARY))));
        salary = (int) (salary + earnedForCompany * 0.05);
//        super.hire(salary, name);

    }

    //@Override
    public int getMonthSalary() {
        return 0;
    }

    //@Override
    public void hireAll(String name) {

    }

    //@Override
    public void fire() {

    }
}
