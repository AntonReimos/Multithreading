public class Operator implements Employee {
    private int salary;

    public Operator() {
        this.salary = getMonthSalary();
    }

    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public int getMonthSalary() {
        salary = 35_000;
        return salary;
    }
}
