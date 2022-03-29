public class TopManager implements Employee {
    private static int TopManagerSalary;
    private final int CAPITAL = 10_000_000;
    private final int MAX_SALARY = 80_000;
    private final int MIN_SALARY = 120_000;
    private int salary;

    public TopManager() {
        this.salary = getMonthSalary();
    }

    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public int getMonthSalary() {
        int salary = 0;
        salary = (int) (MIN_SALARY + (Math.random() * (MAX_SALARY - MIN_SALARY)));

        if (Company.getCompanyIncome() < CAPITAL) {
            TopManagerSalary = salary;
        } else {
            TopManagerSalary = (int) (salary + salary * 1.5);
        }
        return TopManagerSalary;
    }
}
