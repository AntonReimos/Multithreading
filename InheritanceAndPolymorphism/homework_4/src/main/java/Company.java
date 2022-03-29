import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {

    //TODO:1. Создайте класс компании Company, содержащей сотрудников и реализующей методы:
    // найм одного сотрудника — hire(),
    // найм списка сотрудников – hireAll(),
    // увольнение сотрудника – fire(),
    // получение значения дохода компании – getIncome().
    // В чем хранить данные? HashMap ? treeMap ?
    // =
    // Аргументы и возвращаемое значение методов выберите на основании логики работы вашего приложения.
    // 2. Создайте два метода, возвращающие список указанной длины (count).
    // Они должны содержать сотрудников, отсортированных по убыванию и возрастанию заработной платы:
    // List<Employee> getTopSalaryStaff(int count),
    // List<Employee> getLowestSalaryStaff(int count).
    // =
    // Operator — зарплата складывается только из фиксированной части.
    // Каждый класс сотрудника должен имплементировать интерфейс Employee.
    // В интерфейсе Employee должен быть объявлен метод, возвращающий зарплату сотрудника:
    // getMonthSalary()
    // Аргументы и возвращаемое значение метода выберите в соответствии с логикой начисления зарплат.
    // В интерфейсе при необходимости объявляйте необходимые методы.

    private static ArrayList<Employee> companyEmployee;
    private static int companyIncome;

    public Company(int income) {
        companyEmployee = new ArrayList<>();
        companyIncome = income;
    }

    public static int getCompanyIncome() {
        return companyIncome;
    }

    public static ArrayList<Employee> getCompanyEmployee() {
        return companyEmployee;
    }

    public void hire(Employee employee) {
        companyEmployee.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        companyEmployee.addAll(employees);

    }

    public void fire(Employee employee) {
        companyEmployee.remove(employee);

    }

    public List<Employee> getTopSalaryStaff(int count) {
        companyEmployee.sort(Comparator.comparingInt(Employee::getSalary).reversed());
        List<Employee> out = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            out.add(companyEmployee.get(i));
        }
        return out;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        companyEmployee.sort(Comparator.comparingInt(Employee::getSalary));
        List<Employee> out = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            out.add(companyEmployee.get(i));
        }
        return out;
    }

}
