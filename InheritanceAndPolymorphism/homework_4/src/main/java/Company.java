import java.util.ArrayList;
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


    static ArrayList<Workers> companyEmployee;


    public Company() {
        companyEmployee = new ArrayList<>();

        CompanyIncome();
    }

    public static int CompanyIncome() {
        int companyIncome = 0;
        int MAX_INCOME = 25_000_000;
        int incone = (int) (Math.random() * MAX_INCOME);
        companyIncome = incone;
        return companyIncome;
    }

    //Добавление одного сотрудника
    public void hire(Workers o) {
        companyEmployee.add(o);
    }

    public void hireAll(int salary, String name) {

    }

    public void fire() {

    }

    public List<Workers> getTopSalaryStaff(int count) {

        return companyEmployee;
    }


//    public List<Employee> getLowestSalaryStaff(int count) {
//        return;
//    }



}
